package com.example.i_fox_v1.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.i_fox_v1.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PerfilFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_perfil, container, false);
        EditText etUsuario, etSenha, etEmail;
        etUsuario = view.findViewById(R.id.etUsuario);
        etSenha = view.findViewById(R.id.etSenha);
        etEmail = view.findViewById(R.id.etEmail);

        TextView tvNome = view.findViewById(R.id.textNome);
        Button btnAtualizar = view.findViewById(R.id.btnAtualizar);

        //Criar um objeto que fará as requisições para o webservice
        RequestQueue requisicao = Volley.newRequestQueue(getContext());
        String url = "http://localhost:5000/api/Usuario";

        //Ler os dados do SharedPreferences
        SharedPreferences ler = getContext().getSharedPreferences("usuarioLogado", Context.MODE_PRIVATE);
        //Ao ler um valor, é necessário indicar o nome do campo e um valor padrão
        //O valor padrão serve para não ficar nulo em caso de não encontrar o campo
        String usuarioCad = ler.getString("usuario", "");
        String senhaCad = ler.getString("senha", "");
        //Verificar se a senha e usuário são válidos

        //lendo infos do banco
        //No caso da busca com o ID, o retorno do webservice é um Array
        //Se o Array estiver vazio, então nã há um produto cadastrado com o código
        //caso contrário, foi possível encontrar um produto com aquele código
        //No caso da busca com o ID, o retorno do webservice é um Array
        //Se o Array estiver vazio, então nã há um produto cadastrado com o código
        //caso contrário, foi possível encontrar um produto com aquele código

        JsonObjectRequest busca = new JsonObjectRequest(
                Request.Method.GET,
                url + "?nome=" + usuarioCad,
                null, //Não precisa de passar nada no Body, já foi passado acima
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        //Se há um objeto dentro do Array...
                        try {
                            //Colocar os valores dentro da tela
                            tvNome.setText(("Olá " + response.getString("nome")));
                            etUsuario.setText(response.getString("nome"));
                            etEmail.setText(response.getString("email") + "");
                            etSenha.setText(response.getString("senha") + "");
                        } catch (JSONException exc) {
                            exc.printStackTrace();
                            Toast.makeText(getContext(),
                                    "Erro ao ler dados", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                        Toast.makeText(getContext(),
                                "Erro ao enviar", Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requisicao.add(busca); //Envia para o webservice


        //Requisição para atualizar os dados
        btnAtualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Converter os dados do Produto que foram digitados na tela, para JSON
                JSONObject dadosProduto = new JSONObject();
                try {
                    dadosProduto.put("nome", etUsuario.getText().toString());
                    dadosProduto.put("senha", etSenha.getText().toString());
                    dadosProduto.put("email", etEmail.getText().toString());
                } catch (JSONException exc) {
                    exc.printStackTrace();
                }

                //Configura a requisição
                JsonObjectRequest cadastrar = new JsonObjectRequest(
                        Request.Method.PUT, //Método que será usado
                        url, //Caminho do webservice,
                        dadosProduto, //Dados do produto no formato JSON
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                if (response.has("mensagem")) {
                                    Toast.makeText(getContext(),
                                            "Atualizado", Toast.LENGTH_SHORT).show();
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                error.printStackTrace();
                                Toast.makeText(getContext(),
                                        "Erro ao enviar", Toast.LENGTH_SHORT).show();
                            }
                        }
                );
                //Pedir para enviar a requisição do cadastrar
                requisicao.add(cadastrar);
            }
        });



        return view;
    }
}