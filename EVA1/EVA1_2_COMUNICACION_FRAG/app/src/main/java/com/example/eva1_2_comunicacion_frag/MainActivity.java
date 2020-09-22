package com.example.eva1_2_comunicacion_frag;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //1. Recuperar los fragmentos
    ListFragment lista;
    DataFragment datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //2. Acceder
    //Hay un metodo que se ejecuta cuando un fragmento se vincula
    @Override
    public void onAttachFragment(@NonNull Fragment fragment) {
        super.onAttachFragment(fragment);
        if(fragment.getClass() == ListFragment.class)
            lista = (ListFragment)fragment;
        else if(fragment.getClass() == DataFragment.class)
            datos = (DataFragment)fragment;
    }

    //Interfaz de comunicación
    public void onMessageFromFragToMain(String sender, String param){
        if(sender.equals("LISTA")){//Recibimos Información
            //Enviar al fragmento DATA
            datos.onMessageFromMainToFrag(param);
        }else if(sender.equals("DATA")){
            //Imprimir mensaje
            Toast.makeText(this, param, Toast.LENGTH_LONG).show();
        }
    }
}
