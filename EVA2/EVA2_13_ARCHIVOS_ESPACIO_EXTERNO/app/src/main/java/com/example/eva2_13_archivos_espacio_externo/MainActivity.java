package com.example.eva2_13_archivos_espacio_externo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    EditText edTxtDatos;
    String rutaSDApp, rutaSD;
    boolean bLeerEsArch = false;
    final static int PERMISO_ESCRITURA = 100;
    final static String ARCHIVO = "prueba.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edTxtDatos = findViewById(R.id.edTxtDatos);
        rutaSD = Environment.getExternalStorageDirectory().getAbsolutePath();
        rutaSDApp = getExternalFilesDir(null).getAbsolutePath();
        Log.wtf("rutaSD",rutaSD);
        Log.wtf("rutaSD",rutaSDApp);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){//Que version de android tenemos
            if(ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
                    PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions( this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        PERMISO_ESCRITURA);
            }else{
                bLeerEsArch = true;
            }
            }
        else{
            bLeerEsArch = true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode == PERMISO_ESCRITURA){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                bLeerEsArch = true;
            }
        }
    }

    public void guardar(View v){
        if(bLeerEsArch){
            String[] aCadenas = edTxtDatos.getText().toString().split("\n");
            try {
                FileOutputStream fos = new FileOutputStream(rutaSD + "/" + ARCHIVO);
                OutputStreamWriter osw = new OutputStreamWriter(fos);
                BufferedWriter bw = new BufferedWriter(osw);

                for(int i = 0; i < aCadenas.length; i++){
                    bw.append(aCadenas[i]);
                    bw.append("\n");

                }
                bw.close();
            }catch(FileNotFoundException e ){
                e.printStackTrace();
            }catch(IOException e){
                e.printStackTrace();
            }
        }


    }
    public void leer(View v){
        if(bLeerEsArch){
            String sCade;
            try {
                FileInputStream fis = new FileInputStream(rutaSDApp + "/" + ARCHIVO);
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);
                while ((sCade = br.readLine()) != null){
                    edTxtDatos.append(sCade);
                    edTxtDatos.append("\n");
                }
                br.close();
            }catch(FileNotFoundException e){
                e.printStackTrace();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}
