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

public class MainActivity extends AppCompatActivity {

    //VARIÁVEIS QUE IRÃO RECEBER OS ELEMENTOS DA TELA
    private Button btnContinuar;
    private TextView tvFrases;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //REFERÊNCIAS DOS COMPONENTES DA ACTIVITY
        btnContinuar = findViewById(R.id.btnContinuar);
        tvFrases = findViewById(R.id.tvFrases);

        //EVENTO PARA A TRANSIÇÃO DE ACTIVITY PARA O LOGIN
        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this , TelaLogin.class));
            }
        });

        //EVENETO PARA RECEBER AS FRASES DO BANCO DE DADOS ALEATÓRIAMENTE
        //Pedir ajuda para o douglas para ele ver oq podemos fazer aq!

    }
}