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

        EditText etTituloResumoEscrito, etDataResumoEscrito, etResumoEscrito;
        CardView cvResumoEscrito;

        etTituloResumoEscrito = view.findViewById(R.id.etTituloResumoEscrito);
        etDataResumoEscrito = view.findViewById(R.id.etDataResumoEscrito);
        etResumoEscrito = view.findViewById(R.id.etResumo);
        cvResumoEscrito = view.findViewById(R.id.cvResumoEscrito);
        RequestQueue requisicao = Volley.newRequestQueue(getContext());

        String url = "http://localhost:5000/api/Resumo";

        //lendo o código do resumo

        //Lendo o arquivo shared preference
        SharedPreferences ler = this.getActivity().getSharedPreferences("resumoAcessado", Context.MODE_PRIVATE);

        //Ao ler um valor, é necessário indicar o nome do campo e um valor padrão
        //O valor padrão serve para não ficar nulo em caso de não encontrar o campo
        int codigoResumo = ler.getInt("codigo", 0);


        //No caso da busca com o ID, o retorno do webservice é um Array
                //Se o Array estiver vazio, então nã há um produto cadastrado com o código
                //caso contrário, foi possível encontrar um produto com aquele código
                JsonObjectRequest busca = new JsonObjectRequest(
                        Request.Method.GET,
                        url + "/ListarResumoEscrito?id_resumo=" + codigoResumo,
                        null, //Não precisa de passar nada no Body, já foi passado acima
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                if (response.length() == 0) {
                                    Toast.makeText(getContext(),
                                            "Código inválido", Toast.LENGTH_SHORT).show();
                                } else {
                                    //Se há um objeto dentro do Array...
                                    try {
                                        //Criamos um objeto com Produto do índice zero

                                        //Colocar os valores dentro da tela
                                        etTituloResumoEscrito.setText(response.getString("titulo"));
                                        etDataResumoEscrito.setText(response.getString("data_resumo") + "");
                                       etResumoEscrito.setText(response.getString("texto") + "");
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