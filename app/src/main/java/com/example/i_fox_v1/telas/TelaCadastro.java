package com.example.i_fox_v1.telas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.i_fox_v1.R;
public class TelaCadastro extends AppCompatActivity {

    //VARIÁVEIS QUE IRÃO RECEBER OS ELEMENTOS DA TELA
    private Button btnCadastrar;
    private EditText etUsuario, etNasc, etEmail, etSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_cadastro);

        //REFERÊNCIAS DOS COMPONENTES DA ACTIVITY
        btnCadastrar = findViewById(R.id.btnCadastrarCadastro);
        etUsuario = findViewById(R.id.etUsuarioCadastro);
        etNasc = findViewById(R.id.etNascCadastro);
        etEmail = findViewById(R.id.etEmailCadastro);
        etSenha = findViewById(R.id.etSenhaCadastro);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //CRIANDO OBJETO DA CLASSE USUÁRIO

                //INSERINDO USUÁRIO NO BANCO

                //RETORNANDO UM AVISO DE SUCESSO CASO FUNCIONE

                //RETORNANDO POSSÍVEIS ERROS...
            }
        });
    }
}