package com.example.i_fox_v1.listas;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.i_fox_v1.R;
import com.example.i_fox_v1.classes.Caderno;
import com.example.i_fox_v1.telas.TelaLogin;

import org.json.JSONObject;

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
    public void onBindViewHolder(@NonNull ViewHolderCaderno holder, @SuppressLint("RecyclerView") int position) {

        holder.tvNomeCaderno.setText(listaCaderno.get(position).getTitulo());
        holder.ibExcluirCaderno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //vai exibir uma janela para confirmação do usuario, para verificar se ele deseja
                //realmente apagar o caderno ou não
                AlertDialog.Builder configAlert = new AlertDialog.Builder(context);

                //exibe o titulo da janela
                configAlert.setTitle("Excluir caderno");
                //exibe a mensagem perguntando ao usuario se deseja excluir ou não
                configAlert.setMessage("Você deseja excluir o caderno " + listaCaderno.get(position).getTitulo() + "?");

                configAlert.setPositiveButton("SIM!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String url = "http://localhost:5000/api/Caderno";
                        RequestQueue requisicao = Volley.newRequestQueue(context);
                        JsonObjectRequest apagar = new JsonObjectRequest(Request.Method.DELETE,
                                url + "?id_caderno=" + listaCaderno.get(position).getCodigo(), null,
                                //sem nada no body
                                new Response.Listener<JSONObject>() {
                                    @Override
                                    public void onResponse(JSONObject response) {
                                        Toast.makeText(context, "Removido", Toast.LENGTH_SHORT).show();

                                    }
                                },
                                new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        Toast.makeText(context, "Erro ao Excluir", Toast.LENGTH_SHORT).show();
                                    }
                                }
                        );
                        requisicao.add(apagar);

                    }
                });
                configAlert.setNeutralButton("NÃO!", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();//remove o alert da tela
                    }
                });
                //exibir o alert
                configAlert.create().show();
            }
        });

        //Evento para passar para outro fragment
        holder.tvNomeCaderno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    //passar o código do caderno para pegar na tela de resumos
                    int cod = listaCaderno.get(position).getCodigo();
                    try {
                        //Salva as infos
                        //m é preciso de um nome para o arquivo e o modo de operação
                        SharedPreferences.Editor gravar = view.getContext().getSharedPreferences(
                                "cadernoAcessado", //nome do arquivo XML a ser criado
                                Context.MODE_PRIVATE).edit(); //PRIVATE -> não será compartilhado
                        //Informar um nome de campo (chave) e o valor associado a ele
                        gravar.putInt("codigo", cod);

                        //a diferença é que o commit retorna boolean e podemos testar
                        if(gravar.commit()) {
                            Navigation.findNavController(view).navigate(R.id.fraghome_to_fragResumo);
                        }
                    }catch (Exception e){

                    }

            }
        });
    }

        @Override
        public int getItemCount () {

            return listaCaderno.size();
        }
    }

