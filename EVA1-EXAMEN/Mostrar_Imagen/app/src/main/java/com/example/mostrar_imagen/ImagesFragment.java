package com.example.mostrar_imagen;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ImagesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ImagesFragment extends Fragment {
    ImageView imgVw1;
    ImageView imgVw2;
    ImageView imgVw3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_images, container, false);
        imgVw1 = view.findViewById(R.id.imgVw1);
        imgVw2 = view.findViewById(R.id.imgVw2);
        imgVw3 = view.findViewById(R.id.imgVw3);
        return view;
    }

    public void fromMainToFragment(int drawableResource) {
        int previousImg = 0;
        int postImg = 0;
        if(drawableResource == 0){
            previousImg = 8;
            postImg = 1;
        }else if(drawableResource == 8){
            previousImg = 7;
            postImg = 0;
        }else{
            previousImg = drawableResource - 1;
            postImg = drawableResource + 1;
        }
        imgVw1.setImageResource(MainActivity.arrayImg[previousImg]);
        imgVw2.setImageResource(MainActivity.arrayImg[drawableResource]);
        imgVw3.setImageResource(MainActivity.arrayImg[postImg]);
    }
}
