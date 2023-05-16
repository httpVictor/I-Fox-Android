package com.example.i_fox_v1.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.i_fox_v1.R;


public class NovoResumoFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_novo_resumo, container, false);
        ImageView escrito = view.findViewById(R.id.ivEscrito);
        ImageView audio = view.findViewById(R.id.ivAudio);
        ImageView flash = view.findViewById(R.id.ivFlash);
        ImageView foto = view.findViewById(R.id.ivFoto);

        //Evento para passar para o resumo escrito
        escrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.resumo_to_escrito);
            }
        });

        //Evento para passar para o resumo audio


        //Evento para passar para o resumo foto


        //Evento para passar para o resumo flashcard

        // Inflate the layout for this fragment
        return view;
    }
}