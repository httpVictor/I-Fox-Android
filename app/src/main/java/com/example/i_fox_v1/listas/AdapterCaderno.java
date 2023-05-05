package com.example.i_fox_v1.listas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.i_fox_v1.R;
import com.example.i_fox_v1.classes.Caderno;

import java.util.ArrayList;
import java.util.List;

public class AdapterCaderno extends RecyclerView.Adapter<ViewHolderCaderno> {

    Context context;
    //criando a lista dos cadernos
    List<Caderno> listaCaderno = new ArrayList<>();

    //construtor


    public AdapterCaderno(Context context, List<Caderno> listaCaderno) {
        this.context = context;
        this.listaCaderno = listaCaderno;
    }


    @NonNull
    @Override
    public ViewHolderCaderno onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //junta o XML com o Adapter.
        View layout = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_caderno,parent,false);


        return new ViewHolderCaderno(layout);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderCaderno holder, int position) {

        holder.tvNomeCaderno.setText(listaCaderno.get(position).getTitulo());
        holder.tvQntCaderno.setText("Quantidade: "+ listaCaderno.get(position).getDescricao());


    }

    @Override
    public int getItemCount() {
        return listaCaderno.size();
    }
}
