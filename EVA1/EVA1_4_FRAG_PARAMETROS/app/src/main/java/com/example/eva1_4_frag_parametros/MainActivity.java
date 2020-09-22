package com.example.eva1_4_frag_parametros;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void crearFrag(View v){
        //Transacción
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        //Crear el fragmento
        ParamFragment paramFragment = ParamFragment.newInstance("Hola mundo!!!" , "valores asignados al fragmento");
        //Reemplazar nuestro Layout con el Fragmento
        ft.replace(R.id.frameLyFrag, paramFragment);
        //Commit
        ft.commit();
    }


}
