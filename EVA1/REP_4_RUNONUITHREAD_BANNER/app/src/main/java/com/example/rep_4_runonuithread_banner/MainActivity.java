package com.example.rep_4_runonuithread_banner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    ImageView imgVw;
    SeekBar seekBar;
    int iCont = 0;
    int tiempo = 1000;

    Handler handler = new Handler();
    Thread thread = new Thread(){
        @Override
        public void run() {
            super.run();
            while (true) {
                try {
                    Thread.sleep(tiempo);
                    handler.post(runnable);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            switch (iCont) {
                case 0:
                    imgVw.setImageResource(R.drawable.cloudy);
                    iCont++;
                    break;
                case 1:
                    imgVw.setImageResource(R.drawable.snow);
                    iCont++;
                    break;
                case 2:
                    imgVw.setImageResource(R.drawable.sunny);
                    iCont++;
                    break;
                default:
                    iCont = 0;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgVw = findViewById(R.id.imgVw);
        seekBar = findViewById(R.id.seekBar);
        thread.start();

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                switch (progress) {
                    case 1:
                        progress = 10;
                        break;
                    case 2:
                        progress = 9;
                        break;
                    case 3:
                        progress = 8;
                        break;
                    case 4:
                        progress = 7;
                        break;
                    case 5:
                        progress = 6;
                        break;
                    case 6:
                        progress = 5;
                        break;
                    case 7:
                        progress = 4;
                        break;
                    case 8:
                        progress = 3;
                        break;
                    case 9:
                        progress = 2;
                        break;
                    case 10:
                        progress = 1;
                        break;

                }
                tiempo = progress * 100;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
