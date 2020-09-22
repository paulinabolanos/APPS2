package com.example.eva1_11_clima;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class MainActivity extends AppCompatActivity {
     ListView lstVwClima;

     List<Weather> listCiudades = new ArrayList<>();
     /*Weather[] cities = {
            new Weather ("Chihuahua", 20, "Nublado", R.drawable.light_rain),
            new Weather ("Delicias", -5, "Despejado", R.drawable.sunny),
            new Weather ("Ciudad Juárez", -3, "Nevadas intensas", R.drawable.snow),
            new Weather ("Jiménez", 23, "Lluvias intensas", R.drawable.atmospher),
            new Weather ("Camargo", 30, "Vientos intensos", R.drawable.cloudy),
            new Weather ("Parral", 8, "Lluvias fuertes", R.drawable.rainy),
            new Weather ("Aldama", -2, "Niebla", R.drawable.atmospher),
            new Weather ("Batopilas", 10, "Lluvia ligera", R.drawable.tornado),
            new Weather ("Creel", 11, "Despejado", R.drawable.light_rain),
            new Weather ("Casas Grandes", 23, "Lluvias intensas", R.drawable.light_rain)
    };?*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstVwClima = findViewById(R.id.lstVwClima);
        NukeSSLCerts.nuke(); //Ignorar los certificados
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                "https://samples.openweathermap.org/data/2.5/box/city?bbox=12,32,15,37,10&appid=439d4b804bc8187953eb36d2a8c26a02",
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("list");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                Weather wCiudad = new Weather();
                                wCiudad.setCity(jsonObject.getString("name"));
                                JSONObject jsMain = jsonObject.getJSONObject("main");
                                wCiudad.setTemp((int) jsMain.getDouble("temp"));
                                //--Continuamos 7/sep/2020

                                JSONArray jaClima = jsonObject.getJSONArray("weather");
                                JSONObject joClimaCiudad = jaClima.getJSONObject(0);
                                wCiudad.setDesc(joClimaCiudad.getString("descripption"));
                                int iId = joClimaCiudad.getInt("id");
                                if (iId < 300){//Tormentas
                                    wCiudad.setImage(R.drawable.thunderstorm);
                                }else if(iId < 400){//Lluvia ligera
                                    wCiudad.setImage(R.drawable.light_rain);
                                } else if(iId < 600){//Lluvia intensa
                                    wCiudad.setImage(R.drawable.rainy);
                                }else if(iId < 700){//Nieve
                                    wCiudad.setImage(R.drawable.sunny);
                                }else if(iId < 801){//Despejado
                                    wCiudad.setImage(R.drawable.cloudy);
                                }else if(iId < 900){//Nublado
                                    wCiudad.setImage(R.drawable.tornado);
                                }
                                listCiudades.add(wCiudad);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        //Aqui conectamos el adaptador a nuestros datos
                        lstVwClima.setAdapter(new WeatherAdapter(MainActivity.this,
                                R.layout.mi_layout,
                                listCiudades));
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                }
        );
        Volley.newRequestQueue(this).add(jsonObjectRequest);


        //lstVwClima.setAdapter(new WeatherAdapter(this, R.layout.mi_layout, cities));
    }
    public static class NukeSSLCerts {
        protected static final String TAG = "NukeSSLCerts";

        public static void nuke() {
            try {
                TrustManager[] trustAllCerts = new TrustManager[] {
                        new X509TrustManager() {
                            public X509Certificate[] getAcceptedIssuers() {
                                X509Certificate[] myTrustedAnchors = new X509Certificate[0];
                                return myTrustedAnchors;
                            }

                            @Override
                            public void checkClientTrusted(X509Certificate[] certs, String authType) {}

                            @Override
                            public void checkServerTrusted(X509Certificate[] certs, String authType) {}
                        }
                };

                SSLContext sc = SSLContext.getInstance("SSL");
                sc.init(null, trustAllCerts, new SecureRandom());
                HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
                HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
                    @Override
                    public boolean verify(String arg0, SSLSession arg1) {
                        return true;
                    }
                });
            } catch (Exception e) {
            }
        }
    }

}
