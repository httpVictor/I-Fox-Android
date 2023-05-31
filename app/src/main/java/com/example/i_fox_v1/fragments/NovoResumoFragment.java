package com.example.i_fox_v1.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.i_fox_v1.R;
import com.example.i_fox_v1.classes.Caderno;
import com.example.i_fox_v1.classes.Resumo;
import com.example.i_fox_v1.listas.AdapterResumo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class NovoResumoFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_novo_resumo, container, false);
        ImageView escrito = view.findViewById(R.id.ivEscrito);
        ImageView audio = view.findViewById(R.id.ivAudio);
        ImageView flash = view.findViewById(R.id.ivFlash);
        ImageView foto = view.findViewById(R.id.ivFoto);

        RecyclerView recyclerView = view.findViewById(R.id.rvResumo);

        //Fazendo a requisição para listar
        //ListView listView = findViewById(R.id.listView);
        List<Resumo> listafinal = new ArrayList();

        //Se for usar no emulador, colocar o IP 10.0.2.2
        //Se for testar no próprio celular, usar localhost
        String url = "http://localhost:5000/api/Resumo";

        //Objeto que fará a requisição ai webservice
        RequestQueue requisicao = Volley.newRequestQueue(getContext());

        //O método que busca todos os Produto retorna um array
        JsonArrayRequest lista = new JsonArrayRequest(Request.Method.GET,
                url + "?nomeUsuario=" + 38,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //percorrer todos os itens do array
                        for (int i = 0; i < response.length(); i++) {
                            //converter cada posição do array para o objeto JSON
                            try {
                                JSONObject objeto = response.getJSONObject(i);

                                Resumo resumo = new Resumo(objeto.getInt("codigo"),
                                        objeto.getInt("caderno"),
                                        objeto.getString("titulo"),
                                        objeto.getString("tipo"),
                                        objeto.getString("data_resumo")
                                        );
                                listafinal.add(resumo);

                            } catch (JSONException exc) {
                                exc.printStackTrace();

                            }
                        }
                        AdapterResumo adapter = new AdapterResumo(getContext(), listafinal);
                        //indicar o layout RecyclerView
                        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        recyclerView.setAdapter(adapter);

                        Toast.makeText(getContext(), response.length() + "", Toast.LENGTH_SHORT).show();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), "Erro ao enviar", Toast.LENGTH_SHORT).show();
                    }
                });

        requisicao.add(lista);


        //Evento para passar para o resumo escrito
        escrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.resumo_to_escrito);
            }
        });


        return view;
    }
}