package com.example.i_fox_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.i_fox_v1.R;
import com.example.i_fox_v1.telas.TelaLogin;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //VARIÁVEIS QUE IRÃO RECEBER OS ELEMENTOS DA TELA
    private Button btnContinuar;
    private TextView tvFrases;
    String[] frases = {"Não é necessário mudar por ninguém além de si.",
            "Não tema a morte, e sim a vida não vivida. Você não precisa viver para sempre, só precisa viver.",
            "A responsabilidade da nossa felicidade é apenas nossa.",
            "Todos temos a energia que precisamos, basta querer.",
            "E no final do dia, somos um dia mais forte."};

    Random random = new Random();
    int numAleatorio = random.nextInt(4);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //REFERÊNCIAS DOS COMPONENTES DA ACTIVITY
        btnContinuar = findViewById(R.id.btnContinuar);
        tvFrases = findViewById(R.id.tvFrases);

        tvFrases.setText(frases[numAleatorio]);
        //EVENTO PARA A TRANSIÇÃO DE ACTIVITY PARA O LOGIN
        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Se tiver algo salvo no shared preferences passar direto para tela inicial

                //Se não passar para a de login
                startActivity(new Intent(MainActivity.this , TelaLogin.class));
            }
        });

        //EVENETO PARA RECEBER AS FRASES DO BANCO DE DADOS ALEATÓRIAMENTE
        //Pedir ajuda para o douglas para ele ver oq podemos fazer aq!

    }
}