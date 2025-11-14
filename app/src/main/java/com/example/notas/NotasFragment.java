package com.example.notas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NotasFragment extends Fragment {

    private RecyclerView recyclerViewNotas;
    private NotasAdapter adapter;
    private ArrayList<String> listaNotas;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_notas, container, false);

        recyclerViewNotas = view.findViewById(R.id.recyclerViewNotas);

        // Lista inicial de notas (igual você tinha antes)
        listaNotas = new ArrayList<>();
        listaNotas.add("Ron1lson nota");
        listaNotas.add("Comprar pão");
        listaNotas.add("Android");

        adapter = new NotasAdapter(listaNotas);
        recyclerViewNotas.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewNotas.setAdapter(adapter);

        return view;
    }

    // Chamado pela MA quando clicar no botão de add
    public void adicionarNota() {
        if (listaNotas == null || adapter == null) {
            return;
        }

        String titulo = "Nova nota " + (listaNotas.size() + 1);
        listaNotas.add(titulo);
        adapter.notifyItemInserted(listaNotas.size() - 1);
        recyclerViewNotas.scrollToPosition(listaNotas.size() - 1);
    }
}
