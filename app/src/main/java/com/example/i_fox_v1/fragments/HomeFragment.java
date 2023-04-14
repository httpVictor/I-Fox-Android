package com.example.i_fox_v1.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.i_fox_v1.R;


public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Button btnCriarCad = view.findViewById(R.id.btnCriarCad);
        ImageButton imgBtnMap = view.findViewById(R.id.imgBtnMap);
        ImageButton imgBtnClock = view.findViewById(R.id.imgBtnClock);
        ImageButton imgBtnBell = view.findViewById(R.id.imgBtnBell);
        TextView TVCadernoCad = view.findViewById(R.id.TVCadernoCad);


        btnCriarCad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Fragment fragCriarCad = new NovoCadernoFragment();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                */
                Navigation.findNavController(view).navigate(R.id.home_to_criarCad);
            }
        });

       return view;
    }
}