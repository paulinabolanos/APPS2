package com.example.eva1_5_cambio_orientacion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    FrameLayout frameLyDetail;
    Intent inDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inDetail = new Intent(this, DetailActivity.class);
    }

    public void onMessageFromFragmentToMain(){
        frameLyDetail = findViewById(R.id.frameLyDetail);
        if(frameLyDetail != null){//Landscape
            //Crear dinámicamente el fragmento Detail
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            DetailFragment detailFragment = new DetailFragment();
            ft.replace(R.id.frameLyDetail, detailFragment);
            ft.commit();
        }else{//Portrait
            startActivity(inDetail);
        }
    }
}
