package com.example.i_fox_v1.telas;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.i_fox_v1.R;
import com.example.i_fox_v1.fragments.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.i_fox_v1.databinding.ActivityTelaHomeAlunoBinding;

public class TelaHomeAluno extends AppCompatActivity {
    private ActivityTelaHomeAlunoBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTelaHomeAlunoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);

        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_perfil, R.id.nav_home, R.id.nav_lembretes, R.id.nav_feed, R.id.nav_loja).build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_tela_home_aluno);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

}