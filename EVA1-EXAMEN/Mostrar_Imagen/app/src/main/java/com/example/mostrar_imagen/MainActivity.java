package com.example.mostrar_imagen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    ImageFragment imageFragment;
    SeekFragment seekFragment;
    ImagesFragment imagesFragment;
    boolean land = false;
    private int progress=1;
    private int max = 5000;

    static final int arrayImg[] = {R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,
            R.drawable.img6,R.drawable.img7,R.drawable.img8,R.drawable.img9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    protected void onStart() {
        super.onStart();
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            land = false;
        }else if(getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE){
            land = true;
        }
        MiClaseAsincrona myAsynk = new MiClaseAsincrona();
        myAsynk.execute(0);
    }

    @Override
    public void onAttachFragment(@NonNull Fragment fragment) {
        super.onAttachFragment(fragment);
        if(fragment.getClass() == ImageFragment.class){
            imageFragment = (ImageFragment) fragment;
        }else if(fragment.getClass() == SeekFragment.class){
            seekFragment = (SeekFragment) fragment;
        }else if(fragment.getClass() == ImagesFragment.class){
            imagesFragment = (ImagesFragment) fragment;
        }
    }

    public void fromFragmentToMain(int iVal){
        progress = iVal;
    }

    public void setImgToFragment(int drawableResource){
        if(land){
            imagesFragment.fromMainToFragment(drawableResource);
        }else{
            imageFragment.fromMainToFragment(drawableResource);
        }
    }


    class MiClaseAsincrona extends AsyncTask<Integer,Void,Void> {
        private int time = 1000;

        int i = 0;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
            setImgToFragment(i);
            if(i == 8){
                i = 0;
            }else{
                i++;
            }
        }

        @Override
        protected Void doInBackground(Integer... integers) {
            while (true){
                try{
                    time = max - progress;
                    publishProgress();
                    Thread.sleep(time);
                }catch (InterruptedException e){}
            }
        }
    }
}
