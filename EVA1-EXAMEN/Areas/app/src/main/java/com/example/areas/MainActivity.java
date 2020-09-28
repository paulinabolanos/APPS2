package com.example.areas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private OpcionesFragment opcionesFragment;
    private FigurasFragment figurasFragment;
    private CalculoFragment calculoFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public void onAttachFragment(@NonNull Fragment fragment) {
        super.onAttachFragment(fragment);

        if(fragment.getClass() == OpcionesFragment.class){
            opcionesFragment = (OpcionesFragment) fragment;
        }else if(fragment.getClass() == FigurasFragment.class){
            figurasFragment = (FigurasFragment) fragment;
        }else if(fragment.getClass() == CalculoFragment.class){
            calculoFragment = (CalculoFragment) fragment;
        }
    }


    public void onFromMainToFrag(String figure, String field1, String field2, int image) {
        figurasFragment.onFromMainToFrag(figure,field1,field2,image);
        calculoFragment.onFromMainToFrag(figure,field1,field2,image);
    }
}
