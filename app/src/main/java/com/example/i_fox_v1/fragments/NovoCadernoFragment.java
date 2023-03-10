package com.example.i_fox_v1.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.i_fox_v1.R;
public class NovoCadernoFragment extends Fragment {

    private Button btnSalvar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_novo_caderno, container, false);
        btnSalvar = view.findViewById(R.id.btnSalvarCaderno);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Validação para ver se o caderno foi salvo de fato
                Navigation.findNavController(view).navigate(R.id.criarCad_to_home);
            }
        });


        return view;
    }
}