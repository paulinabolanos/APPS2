package com.example.eva1_2_comunicacion_frag;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends Fragment {
    //Datos de la lista
    String[] datos={
            "Enero",
            "Febrero",
            "Marzo",
            "Abril",
            "Mayo",
            "Junio",
            "Julio",
            "Agosto",
            "Septiembre",
            "Octubre",
            "Noviembre",
            "Diciembre",
            "Enero2",
            "Febrero2",
            "Marzo2",
            "Abril2",
            "Mayo2",
            "Junio2",
            "Julio2",
            "Agosto2",
            "Septiembre2",
            "Octubre2",
            "Noviembre2",
            "Diciembre2",
            "Enero3",
            "Febrero3",
            "Marzo3",
            "Abril3",
            "Mayo3",
            "Junio3",
            "Julio3",
            "Agosto3",
            "Septiembre3",
            "Octubre3",
            "Noviembre3",
            "Diciembre3",
            "Enero4"
    };

    MainActivity main;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        main = (MainActivity)getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FrameLayout frameLayout= (FrameLayout)inflater.inflate(R.layout.fragment_list, container, false);
        //Aqui llenamos la lista
        ListView listVwDatos;
        listVwDatos = frameLayout.findViewById(R.id.listVwDatos);
        listVwDatos.setAdapter(new ArrayAdapter<>(
                main,
                android.R.layout.simple_list_item_1,
                datos
        ));
        //Evento
        listVwDatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Aqui va el codigo
                main.onMessageFromFragToMain("LISTA", datos[position]);
            }
        });
        return frameLayout;
    }
}
