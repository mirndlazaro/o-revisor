package com.example.orevisor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tLogin = (TextView) findViewById(R.id.tLogin);
                TextView tSenha = (TextView) findViewById(R.id.tSenha);

                String login = tLogin.getText().toString();
                String senha = tSenha.getText().toString();

                if (login.equals("orevisor@gmail.com") && senha.equals("123")) {
                    alert(String.valueOf(R.string.login_efetuado));

                    Intent trocarDeTela = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(trocarDeTela);
                    finish();
                } else {
                    alert(String.valueOf(R.string.login_incorreto));
                }
            }
        });

        TextView tvCadastro = (TextView) findViewById(R.id.tvCadastro);
        tvCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent trocarDeTela = new Intent(LoginActivity.this, CadastroActivity.class);
                startActivity(trocarDeTela);
                finish();
            }
        });
    }

    private void alert(String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();
    }
}