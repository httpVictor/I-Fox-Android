package com.example.i_fox_v1.telas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.i_fox_v1.R;
import com.example.i_fox_v1.TelaHomeAluno;

public class TelaLogin extends AppCompatActivity {

    //VARIÁVEIS QUE IRÃO RECEBER OS ELEMENTOS DA TELA
    private Button btnEntrar;
    private TextView tvCadastrar;
    private EditText etUsuario, etSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

        //REFERÊNCIAS DOS COMPONENTES DA ACTIVITY
        btnEntrar = findViewById(R.id.btnEntrar);
        tvCadastrar = findViewById(R.id.tvCadastresse);
        etUsuario = findViewById(R.id.etUsuarioLogin);
        etUsuario = findViewById(R.id.etSenhaLogin);

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //CRIANDO OBJETO DE USUÁRIO

                //CONFIRMAR SE O USUÁRIO EXISTE E SE A SENHA CONDIZ COM A DAQUELE USUÁRIO

                //CASO POSITIVO, LOGAR

                //INDO PARA A TELA INICIAL
                startActivity(new Intent(TelaLogin.this, TelaHomeAluno.class));
                //CASO NEGATIVO, INFORMAR O ERRO

            }
        });

        tvCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //DIRECIONANDO PARA A TELA DE CADASTRO
               startActivity(new Intent(TelaLogin.this, TelaCadastro.class));
            }
        });
    }
}