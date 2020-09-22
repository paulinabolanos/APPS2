package com.example.rep_5_servicios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnIniciar, btnDetener;
    Intent inServicio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIniciar = findViewById(R.id.btnIniciar);
        btnDetener = findViewById(R.id.btnDetener);

        inServicio = new Intent(this, MyService.class);
        BroadcastReceiver breceiver = new MiBroadCastReceiver();

        IntentFilter intentFilter = new IntentFilter("MI_SERVICIO");
        registerReceiver(breceiver, intentFilter);

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inServicio.putExtra("DATO", "Dato de la actividad");
                startService(inServicio);
            }
        });

        btnDetener.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(inServicio);
            }
        });

    }


    class MiBroadCastReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            //Procesamos el mensaje
            Log.wtf("MENSAJE", "THREAD");
        }
    }
}

//Leer mensajes de un servicio -- Broadcast Receiver
//Identificar que servicio manda mensaje ---Filtro