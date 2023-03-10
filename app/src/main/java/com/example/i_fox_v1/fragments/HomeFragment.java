package com.example.i_fox_v1.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.i_fox_v1.R;


public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        Button btnCriarCad = view.findViewById(R.id.btnCriarCad);

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