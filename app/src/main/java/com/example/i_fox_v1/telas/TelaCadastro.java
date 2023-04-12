package com.example.i_fox_v1.telas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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
                String nome = etUsuario.getText().toString();
                String senha = etSenha.getText().toString();

                //VALIDAÇÕES DO USUÁRIO
                if (nome.length() < 1){
                    Toast.makeText(TelaCadastro.this, "Nome muito curto", Toast.LENGTH_SHORT).show();

                }else {
                    if (nome.length() > 15){
                        Toast.makeText(TelaCadastro.this, "Nome muito longo", Toast.LENGTH_SHORT).show();
                    }else{
                        if (nome != null){
                            Toast.makeText(TelaCadastro.this, "Insira um nome válido", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                //VALIDAÇÕES DA SENHA
                if (senha.length() < 6 ){

                    Toast.makeText(TelaCadastro.this, "A senha é muito curta", Toast.LENGTH_SHORT).show();

                } else{
                    if (senha.length() > 20) {

                        Toast.makeText(TelaCadastro.this, "A senha é muito longa", Toast.LENGTH_SHORT).show();

                    } else{
                        if ( senha != null) {

                            Toast.makeText(TelaCadastro.this, "Insira uma senha válida", Toast.LENGTH_SHORT).show();
                        }
                    }
                }


                //RETORNANDO UM AVISO DE SUCESSO CASO FUNCIONE

                //RETORNANDO POSSÍVEIS ERROS...
            }
        });
    }
}