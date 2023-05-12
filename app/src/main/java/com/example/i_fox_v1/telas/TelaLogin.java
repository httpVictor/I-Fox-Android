package com.example.i_fox_v1.telas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.i_fox_v1.R;
import com.example.i_fox_v1.TelaHomeAluno;
import com.example.i_fox_v1.classes.Caderno;
import com.example.i_fox_v1.classes.Usuario;
import com.example.i_fox_v1.fragments.HomeFragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

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
        etSenha = findViewById(R.id.etSenhaLogin);

        //Usar a classe do Volley para configurar a requisição
        RequestQueue requisicao = Volley.newRequestQueue(this);
        //Caminho do webservice
        //O localhost irá direcionar para o localhost do Android e não do computador
        //aonde o webservice estará executando. Para direcionar ao computador usamos
        //um IP reservado do Android que é o 10.0.2.2
        String url = "http://localhost:5000/api/Usuario/Logar";


        //VALIDAÇÕES

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //CRIANDO OBJETO DE USUÁRIO
                //criando uma variavel para puxar os textos da tela
               String nomeUsuario = etUsuario.getText().toString();
               String senhaUsuario = etSenha.getText().toString();

                Usuario usuario = new Usuario(nomeUsuario, senhaUsuario);

                JSONObject produtoJson = new JSONObject();

                try {

                    //no primeiro parâmetro do método put() usamos o nome do atributo
                    //igual ao do webservice que espera para receber, após isso passamos o seu valor

                    produtoJson.put("nome", nomeUsuario);
                    produtoJson.put("senha", senhaUsuario);
                    produtoJson.put("Email", "");
                    produtoJson.put("Data_nasc", "");

                }catch (JSONException exc){
                    exc.printStackTrace();
                }
                JsonObjectRequest login = new JsonObjectRequest(Request.Method.POST,
                        url, //Caminho do webservice
                        produtoJson,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                if (response.has("mensagem")) {

                                    try {
                                        String status = response.getString("mensagem");
                                        Toast.makeText(TelaLogin.this, status, Toast.LENGTH_SHORT).show();
                                        if(status.equals("logado")){
                                            //Salava as infos
                                            //m é preciso de um nome para o arquivo e o modo de operação
                                            SharedPreferences.Editor gravar = getSharedPreferences(
                                                    "usuarioLogado", //nome do arquivo XML a ser criado
                                                    MODE_PRIVATE).edit(); //PRIVATE -> não será compartilhado
                                            //Informar um nome de campo (chave) e o valor associado a ele
                                            gravar.putString("usuario", nomeUsuario);
                                            gravar.putString("senha", senhaUsuario);
                                            //Para gravar é necessário chamar o método apply() ou commit()
                                            //a diferença é que o commit retorna boolean e podemos testar
                                            if(gravar.commit()) {
                                                Toast.makeText(TelaLogin.this, "Logado!",
                                                        Toast.LENGTH_LONG).show();
                                            }
                                            startActivity(new Intent(TelaLogin.this, TelaHomeAluno.class));

                                        }
                                    } catch (JSONException e) {
                                        throw new RuntimeException(e);
                                    }
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(TelaLogin.this, "Falha no Login", Toast.LENGTH_SHORT).show();
                                etUsuario.setText(error.getMessage());
                            }
                        });
                // pede para executar a requisicao
                requisicao.add(login);


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