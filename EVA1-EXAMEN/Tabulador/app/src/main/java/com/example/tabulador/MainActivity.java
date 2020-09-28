package com.example.tabulador;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void shuttle(View v){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ShuttleFragment frag = new ShuttleFragment();
        ft.replace(R.id.frameLy, frag);
        ft.commit();
    }

    public void aresV(View v){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        AresVFragment frag = new AresVFragment();
        ft.replace(R.id.frameLy, frag);
        ft.commit();
    }

    public void falcon(View v){
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        FalconFragment frag = new FalconFragment();
        ft.replace(R.id.frameLy, frag);
        ft.commit();
    }
}
