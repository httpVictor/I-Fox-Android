package com.example.i_fox_v1.fragments;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.i_fox_v1.R;
import com.example.i_fox_v1.telas.TelaLogin;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class ResumoEscrito extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_resumo_escrito,container,false);

        EditText etTituloResumoEscrito, etDataResumoEscrito;
        CardView cvResumoEscrito;

        etTituloResumoEscrito = view.findViewById(R.id.etTituloResumoEscrito);
        etDataResumoEscrito = view.findViewById(R.id.etDataResumoEscrito);
        cvResumoEscrito = view.findViewById(R.id.cvResumoEscrito);
        RequestQueue requisicao = Volley.newRequestQueue(getContext());

        String url = "http://localhost:5000/api/Resumo";




                //No caso da busca com o ID, o retorno do webservice é um Array
                //Se o Array estiver vazio, então nã há um produto cadastrado com o código
                //caso contrário, foi possível encontrar um produto com aquele código
                JsonArrayRequest busca = new JsonArrayRequest(
                        Request.Method.GET,
                        url + "buscaID?id=" ,
                        null, //Não precisa de passar nada no Body, já foi passado acima
                        new Response.Listener<JSONArray>() {
                            @Override
                            public void onResponse(JSONArray response) {
                                if (response.length() == 0) {
                                    Toast.makeText(getContext(),
                                            "Código inválido", Toast.LENGTH_SHORT).show();
                                } else {
                                    //Se há um objeto dentro do Array...
                                    try {
                                        //Criamos um objeto com Produto do índice zero
                                        JSONObject obj = response.getJSONObject(0);
                                        //Colocar os valores dentro da tela
                                        etTituloResumoEscrito.setText(obj.getString("Titulo"));
                                        etDataResumoEscrito.setText(obj.getString("Data") + "");
                                       // cvResumoEscrito.setsetText(obj.getString("Anotações") + "");
                                    } catch (JSONException exc) {
                                        exc.printStackTrace();
                                        Toast.makeText(getContext(),
                                                "Erro ao ler dados", Toast.LENGTH_SHORT).show();
                                    }
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




    // Inflate the layout for this fragment
        return view;
}
}