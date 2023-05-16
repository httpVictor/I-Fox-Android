package com.example.i_fox_v1.telas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.i_fox_v1.R;

import org.json.JSONException;
import org.json.JSONObject;

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

        //Usar a classe do Volley para configurar a requisição
        RequestQueue requisicao = Volley.newRequestQueue(this);
        //Caminho do webservice
        //O localhost irá direcionar para o localhost do Android e não do computador
        //aonde o webservice estará executando. Para direcionar ao computador usamos
        //um IP reservado do Android que é o 10.0.2.2
        String url = "http://localhost:5000/api/Usuario/Cadastrar";

        //Cadastrando um usuario
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //criando um objeto de JSON
                JSONObject produtoJson = new JSONObject();

                try {
                    //no primeiro parâmetro do método put() usamos o nome do atributo
                    //igual ao do webservice que espera para receber, após isso passamos o seu valor
                    produtoJson.put("nome", etUsuario.getText().toString());
                    produtoJson.put("data_nasc", "20050101");
                    produtoJson.put("email", etEmail.getText().toString());
                    produtoJson.put("senha", etSenha.getText().toString());

                }catch (JSONException exc){
                    exc.printStackTrace();
                }
                JsonObjectRequest cadastrar = new JsonObjectRequest(Request.Method.POST,//Usar o POST na requisição
                        url, //Caminho do webservice
                        produtoJson,//o que vai enviar no body
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                if (response.has("mensagem")) {
                                    String resultado;
                                    try {
                                        String status = response.getString("mensagem");
                                        Toast.makeText(TelaCadastro.this, status, Toast.LENGTH_SHORT).show();

                                    } catch (JSONException e) {
                                        throw new RuntimeException(e);
                                    }
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(TelaCadastro.this, "Erro ao cadastrar", Toast.LENGTH_SHORT).show();
                            }
                        });
                //pede para executar a requisição
                requisicao.add(cadastrar);

            }
        });

/*
        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //CRIANDO OBJETO DA CLASSE USUÁRIO

                //INSERINDO USUÁRIO NO BANCO
                String nome = etUsuario.getText().toString();
                String senha = etSenha.getText().toString();

                boolean validarSenha = false;
                boolean validarUsuario = false;
                //VALIDAÇÕES DO USUÁRIO
                if (nome.length() < 1){
                    Toast.makeText(TelaCadastro.this, "Nome muito curto", Toast.LENGTH_SHORT).show();

                }else {
                    if (nome.length() > 15){
                        Toast.makeText(TelaCadastro.this, "Nome muito longo", Toast.LENGTH_SHORT).show();
                    }else{
                        if (nome != null){
                            Toast.makeText(TelaCadastro.this, "Insira um nome válido", Toast.LENGTH_SHORT).show();
                        }else{
                            validarUsuario = true;
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
                        }else{
                            validarSenha = true;
                        }
                    }
                }

                if(validarSenha && validarUsuario){
                    Intent intent = new Intent(TelaCadastro.this, TelaLogin.class);
                    finish();
                }
                //RETORNANDO UM AVISO DE SUCESSO CASO FUNCIONE

                //RETORNANDO POSSÍVEIS ERROS...
            }
        });


 */
    }

}