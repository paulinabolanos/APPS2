package com.example.areas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class CalculoFragment extends Fragment {
    private EditText edTxt1, edTxt2;
    private Button btnCalcular;
    private TextView txtVwResultado;
    private View view;
    private String code;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_calculo, container, false);

        edTxt1 = view.findViewById(R.id.edTxt1);
        edTxt2 = view.findViewById(R.id.edTxt2);
        btnCalcular = view.findViewById(R.id.btnCalcular);
        txtVwResultado = view.findViewById(R.id.txtVwResultado);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int field1 = Integer.parseInt(edTxt1.getText().toString());
                int field2 = Integer.parseInt(edTxt2.getText().toString());
                double result = 0;


                switch (code){
                    case "CILINDRO":
                        result =  (2*(Math.PI)*(field1 * field1)) + (2 * (Math.PI) * field1 * field2);
                        break;
                    case "ROMBOIDE":
                    case "RECTANGULO":
                        result =  (field1 * field2);
                        break;
                    case "CONO":
                        result =  (Math.PI) * field1 * (field1 + field2);
                        break;
                    case "PENTAGONO":
                        result = (((field1 * 5) * field2) / 2);
                        break;
                    case "ELIPSE":
                        result = (Math.PI) * field1 * field2;
                        break;
                    case "HEXAGONO":
                        result =  ((field1 * 6) * field2) / 2;
                        break;
                    case "ROMBO":
                    case "TRIANGULO":
                        result = (field1 * field2)/ 2;
                        break;
                    case "OCTAGONO":
                        result =  ((field1 * 8) * field2) / 2;
                        break;
                }


                txtVwResultado.setText("Area: " + result + " cm2");
            }
        });

        return view;
    }

    public void onFromMainToFrag(String figure, String field1, String field2, int image) {
        edTxt1.setHint(field1);
        edTxt2.setHint(field2);
        btnCalcular.setVisibility(View.VISIBLE);
        this.code = figure;
        edTxt1.setText("");
        edTxt2.setText("");
    }
}
