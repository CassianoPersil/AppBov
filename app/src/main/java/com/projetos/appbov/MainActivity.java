package com.projetos.appbov;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText usuario, senha;
    Button btLogar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setando botões as variáveis
        usuario = findViewById(R.id.ctEmail);
        senha = findViewById(R.id.ctSenha);

        usuario.setText("admin@login.com");
        senha.setText("admin");

        btLogar = (Button)findViewById(R.id.btLogar);
        btLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Login l = new Login();
                if(l.logar(usuario.getText().toString(), senha.getText().toString())){
                    Intent intent = new Intent(getBaseContext(),MenudeAnimais.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(getApplicationContext(),"Usuário ou senha incorretos", Toast.LENGTH_SHORT).show();
                }

             }
        });
    }
}
