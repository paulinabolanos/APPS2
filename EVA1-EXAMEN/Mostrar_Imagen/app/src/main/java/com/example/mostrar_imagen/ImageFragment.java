package com.example.mostrar_imagen;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;



public class ImageFragment extends Fragment {
    ImageView imgVw;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_image, container, false);
        imgVw = view.findViewById(R.id.imgVw);
        return view;
    }


    public void fromMainToFragment(int drawableResource) {
        imgVw.setImageResource(MainActivity.arrayImg[drawableResource]);
    }
}
