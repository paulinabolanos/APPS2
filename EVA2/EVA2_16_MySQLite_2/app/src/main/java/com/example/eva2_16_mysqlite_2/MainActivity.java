package com.example.eva2_16_mysqlite_2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listVwDatos;
    SQLiteDatabase sqlDB;
    final String NOMBRE_DB = "mi_base_datos";
    List <String> nombre = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listVwDatos = findViewById(R.id.listVwDatos);

        sqlDB = openOrCreateDatabase(NOMBRE_DB, MODE_PRIVATE, null);
        try{
            sqlDB.execSQL("create table mitabla(id integer primary key autoincrement," +
                    "nombre text," +
                    "apelido text);");
        }catch(SQLException e){
            e.printStackTrace();
        }

        sqlDB.execSQL("insert into mitabla(nombre, apellido) values('PAULINA', 'BOLAOS')");
        sqlDB.execSQL("insert into mitabla(nombre, apellido) values('PAUL', 'BOLAOS')");
        sqlDB.execSQL("insert into mitabla(nombre, apellido) values('PAMELA', 'BOLAOS')");
        sqlDB.execSQL("insert into mitabla(nombre, apellido) values('TERE', 'ESTRADA')");
        sqlDB.execSQL("insert into mitabla(nombre, apellido) values('ROGELIO', 'BOLAOS')");

        Cursor cursor = sqlDB.rawQuery("select * from mitabla;", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            nombre.add(cursor.getString(cursor.getColumnIndex("nombre")) + "" +
                    cursor.getString(cursor.getColumnIndex("apellido")));
            cursor.moveToNext();
        }
        listVwDatos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                nombre));
    }
}
