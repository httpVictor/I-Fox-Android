package com.example.i_fox_v1.fragments;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.i_fox_v1.R;
import com.example.i_fox_v1.telas.TelaLogin;

import org.json.JSONException;
import org.json.JSONObject;


public class ResumoEscrito extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String url = "http://localhost:5000/api/Caderno";



        /*
            //Salva as infos
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
                Toast.makeText(getContext(), "Logado!",
                        Toast.LENGTH_LONG).show();
            }
*/

    // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_resumo_escrito,container,false);
}
}