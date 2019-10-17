package com.example.daniel.informa;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class cadastrarArtigo extends AppCompatActivity {

    ArrayList<artigo> arrayArtigos= new ArrayList<artigo>();
    artigo objetoArtigo = new artigo();

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_artigo);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void cadastrar(View view) {
        final EditText t = (EditText) findViewById(R.id.titulo);
        final EditText d = (EditText) findViewById(R.id.descricao);
        final Boolean estagio = (Boolean) findViewById(R.id.estagio).isSelected();
        final Boolean bolsa = (Boolean) findViewById(R.id.bolsa).isSelected();
        final Boolean palestra = (Boolean) findViewById(R.id.palestra).isSelected();
        final Boolean projetoExtensao = (Boolean) findViewById(R.id.projetoExtensao).isSelected();
        final Boolean intervaloCultura = (Boolean) findViewById(R.id.intervaloCultural).isSelected();
        final Boolean evento = (Boolean) findViewById(R.id.evento).isSelected();
        final Boolean noticia = (Boolean) findViewById(R.id.noticia).isSelected();
        final Boolean externo = (Boolean) findViewById(R.id.externo).isSelected();
        final Boolean interno = (Boolean) findViewById(R.id.interno).isSelected();

        if (estagio) {
            objetoArtigo.categoria = " Estágio ";
        }else {
            if (bolsa){
                objetoArtigo.categoria = "Bolsa";
            } else {
                if (palestra) {
                    objetoArtigo.categoria = "Palestra";
                }else{
                    if (projetoExtensao){
                        objetoArtigo.categoria = "Projeto de Extensão";
                    }else
                    if (intervaloCultura){
                        objetoArtigo.categoria = "Intervalo Cultural";
                    }
                }
            }
        }

        if (evento){
            objetoArtigo.tipoArtigo = "Evento";
        }else{
            if (noticia){
                objetoArtigo.tipoArtigo = "Notícia";
            }
        }

        if (interno){
            objetoArtigo.publico = "Interno";
        }else{
            if (externo){
                objetoArtigo.publico = "Externo";
            }
        }

        objetoArtigo.setTitulo(t.getText().toString());
        objetoArtigo.setDescricao(d.getText().toString());

        arrayArtigos.add(objetoArtigo);


        myRef.child("Descricao").child("nome").setValue(objetoArtigo.descricao);
        myRef.child("Titulo").child("nome").setValue(objetoArtigo.titulo);
        myRef.child("Categoria").child("nome").setValue(objetoArtigo.categoria);
        myRef.child("publico").child("nome").setValue(objetoArtigo.publico);
        myRef.child("tipoArtigo").child("nome").setValue(objetoArtigo.tipoArtigo);

        Toast toast = Toast.makeText(getApplicationContext(), "Cadastrado Com Sucesso",Toast.LENGTH_LONG);
        toast.show();
    }
}
