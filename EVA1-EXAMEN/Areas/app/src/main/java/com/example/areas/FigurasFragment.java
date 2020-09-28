package com.example.areas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FigurasFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FigurasFragment extends Fragment {

    private ImageView imgVw;
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_figuras, container, false);
        imgVw = view.findViewById(R.id.imgView);
        return view;
    }



    public void onFromMainToFrag(String figure, String field1, String field2, int image) {
        imgVw.setImageResource(image);
    }
}
