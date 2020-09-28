package com.example.areas;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OpcionesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OpcionesFragment extends Fragment {


    private RadioButton rdBtnCilindro, rdBtnRomboide, rdBtnCono, rdBtnPentagono, rdBtnElipse, rdBtnHexagono,
            rdBtnRectangulo, rdBtnRombo, rdBtnOctagono, rdBtnTriangulo;
    private RadioGroup rdGroup;
    private View view;
    private MainActivity mainActivity;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivity = (MainActivity) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_opciones, container, false);

        rdBtnCilindro = view.findViewById(R.id.rdBtnCilindro);
        rdBtnRomboide = view.findViewById(R.id.rdBtnRomboide);
        rdBtnCono = view.findViewById(R.id.rdBtnCono);
        rdBtnPentagono = view.findViewById(R.id.rdBtnPentagono);
        rdBtnElipse = view.findViewById(R.id.rdBtnElipse);
        rdBtnHexagono = view.findViewById(R.id.rdBtnHexagono);
        rdBtnRectangulo = view.findViewById(R.id.rdBtnRectangulo);
        rdBtnRombo = view.findViewById(R.id.rdBtnRombo);
        rdBtnOctagono = view.findViewById(R.id.rdBtnOctagono);
        rdBtnTriangulo = view.findViewById(R.id.rdBtnTriangulo);
        rdGroup = view.findViewById(R.id.rdGroup);

        rdGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.rdBtnCilindro:
                        mainActivity.onFromMainToFrag("CILINDRO", "Radio","Altura", R.drawable.cilindro);
                        break;
                    case R.id.rdBtnRomboide:
                        mainActivity.onFromMainToFrag("ROMBOIDE", "Base","Altura", R.drawable.romboide);
                        break;
                    case R.id.rdBtnCono:
                        mainActivity.onFromMainToFrag("CONO", "Radio","generatriz",R.drawable.cono);
                        break;
                    case R.id.rdBtnPentagono:
                        mainActivity.onFromMainToFrag("PENTAGONO", "Lado","Apotema", R.drawable.pentagono);
                        break;
                    case R.id.rdBtnElipse:
                        mainActivity.onFromMainToFrag("ELIPSE", "RadioMayor","RadioMenor", R.drawable.elipse);
                        break;
                    case R.id.rdBtnHexagono:
                        mainActivity.onFromMainToFrag("HEXAGONO", "Lado","Ampotema", R.drawable.hexagono);
                        break;
                    case R.id.rdBtnRectangulo:
                        mainActivity.onFromMainToFrag("RECTANGULO", "Base","Altura", R.drawable.rectangulo);
                        break;
                    case R.id.rdBtnRombo:
                        mainActivity.onFromMainToFrag("ROMBO", "DiagonalMayor","DiagonalMenor", R.drawable.rombo);
                        break;
                    case R.id.rdBtnOctagono:
                        mainActivity.onFromMainToFrag("OCTAGONO", "Lado","Ampotema", R.drawable.octagono);
                        break;
                    case R.id.rdBtnTriangulo:
                        mainActivity.onFromMainToFrag("TRIANGULO", "Base","Altura", R.drawable.triangulo);
                        break;
                }
            }
        });

        return view;

    }

    public void onFromMainToFrag(String figure, String field1, String field2, int image) {

    }
}
