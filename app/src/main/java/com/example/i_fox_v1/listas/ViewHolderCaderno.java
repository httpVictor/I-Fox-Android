package com.example.i_fox_v1.listas;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.i_fox_v1.R;

public class ViewHolderCaderno extends RecyclerView.ViewHolder {

    TextView tvNomeCaderno;
    ImageButton ibExcluirCaderno;

    public ViewHolderCaderno(@NonNull View itemView) {
        super(itemView);

        tvNomeCaderno = itemView.findViewById(R.id.tvNomeCaderno);
        ibExcluirCaderno = itemView.findViewById(R.id.ibExcluirCaderno);

    }
    }


