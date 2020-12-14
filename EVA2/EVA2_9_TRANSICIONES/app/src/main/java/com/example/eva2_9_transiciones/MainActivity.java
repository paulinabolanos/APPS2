package com.example.eva2_9_transiciones;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Intent intent;
    ImageView imgVw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgVw = findViewById(R.id.imgVw);
        intent = new Intent(this, MainActivity2.class);
    }
    public void onClick(View v){
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                this, imgVw, "mi_transicion"
        );
        startActivity(intent, options.toBundle());
    }
}
