package com.example.daniel.informa;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class telalogin extends AppCompatActivity {
    String login;
    String senha;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telalogin);
    }

    public void logar(View view) {
        final EditText l = (EditText) findViewById(R.id.login);
        final EditText s = (EditText) findViewById(R.id.senha);
        login = l.getText().toString();
        senha = s.getText().toString();

        if (login.equals("vilson.l") && (senha.equals("1234"))){
            Intent i = new Intent(this, telaprincipal.class);
            startActivity(i);
        }else {

            Toast toast = Toast.makeText(getApplicationContext(), "Login ou Senha Incorreto(s)", Toast.LENGTH_LONG);
            toast.show();

        }
    }
}
