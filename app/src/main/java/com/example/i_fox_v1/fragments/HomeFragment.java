package com.example.i_fox_v1.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.i_fox_v1.R;
import com.example.i_fox_v1.classes.Caderno;
import com.example.i_fox_v1.listas.AdapterCaderno;
import com.example.i_fox_v1.telas.TelaHomeAluno;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Button btnCriarCad = view.findViewById(R.id.btnCriarCad);
        ImageButton imgBtnMap = view.findViewById(R.id.imgBtnMap);
        ImageButton imgBtnClock = view.findViewById(R.id.imgBtnClock);
        ImageButton imgBtnBell = view.findViewById(R.id.imgBtnBell);
        RecyclerView recyclerView = view.findViewById(R.id.rvCaderno);
        TextView txtTestes = view.findViewById(R.id.textView2);

        //Lendo o arquivo shared preference
        SharedPreferences ler = this.getActivity().getSharedPreferences("usuarioLogado", Context.MODE_PRIVATE);

        //Ao ler um valor, é necessário indicar o nome do campo e um valor padrão
        //O valor padrão serve para não ficar nulo em caso de não encontrar o campo
        String usuarioCad = ler.getString("usuario", "");
        String senhaCad = ler.getString("senha", "");

        //txtTestes.setText(usuarioCad);

        //ListView listView = findViewById(R.id.listView);
        List<Caderno> listafinal = new ArrayList();

        //Se for usar no emulador, colocar o IP 10.0.2.2
        //Se for testar no próprio celular, usar localhost
        String url = "http://localhost:5000/api/Caderno";


        //Objeto que fará a requisição ai webservice
        RequestQueue requisicao = Volley.newRequestQueue(getContext());

        //O método que busca todos os Produto retorna um array
        JsonArrayRequest lista = new JsonArrayRequest(Request.Method.GET,
                url + "?nomeUsuario=" + usuarioCad,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //percorrer todos os itens do array
                        for (int i = 0; i < response.length(); i++) {
                            //converter cada posição do array para o objeto JSON
                            try {
                                JSONObject objeto = response.getJSONObject(i);

                                Caderno caderno = new Caderno(objeto.getString("titulo"),
                                        objeto.getString("descricao"),
                                        objeto.getString("icone"),
                                        objeto.getInt("codigo"));
                                listafinal.add(caderno);

                            } catch (JSONException exc) {
                                exc.printStackTrace();

                            }
                        }
                        AdapterCaderno adapter = new AdapterCaderno(getContext(), listafinal);
                        //indicar o layout RecyclerView
                        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                        recyclerView.setAdapter(adapter);

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getContext(), "Erro ao enviar", Toast.LENGTH_SHORT).show();
                    }
                });

        requisicao.add(lista);


        btnCriarCad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Navigation.findNavController(view).navigate(R.id.home_to_criarCad);
            }
        });

       return view;
    }
}