package com.example.rep_2_asyntask_banner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    ImageView imgVw;
    SeekBar seekBar;
    int time = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgVw = findViewById(R.id.imgVw);
        seekBar = findViewById(R.id.seekBar);

        MiClaseAsincrona mcaPrueba = new MiClaseAsincrona();
        mcaPrueba.execute(1000);

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
                time = progress * 100;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    class MiClaseAsincrona extends AsyncTask<Integer, Integer, String> {

        @Override
        protected String doInBackground(Integer... integers) {

            while (true) {
                try {
                    Thread.sleep(time);
                    publishProgress();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            int i = 0;
            switch (i) {
                case 0:
                    imgVw.setImageResource(R.drawable.cloudy);
                    i++;
                    break;
                case 1:
                    imgVw.setImageResource(R.drawable.snow);
                    i++;
                    break;
                case 2:
                    imgVw.setImageResource(R.drawable.sunny);
                    i++;
                    break;
                default:
                    i = 0;
            }
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }
}
