package com.example.i_fox_v1.listas;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.i_fox_v1.R;

public class ViewHolderResumo extends RecyclerView.ViewHolder {

    TextView tvNomeResumo;
    ImageButton ibCabecalho, ibExcluirResumo;

    public ViewHolderResumo(@NonNull View itemView) {
        super(itemView);

        tvNomeResumo = itemView.findViewById(R.id.tvNomeResumo);
        ibCabecalho = itemView.findViewById(R.id.ibCabecalho);
        ibExcluirResumo = itemView.findViewById(R.id.ibExcluirResumo);

    }

}
