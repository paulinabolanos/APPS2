package com.example.eva2_17_mysqlite_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listVwDatos;
    SQLiteDatabase sqlDB;
    final String NOMBRE_DB = "mi_base_datos";
    List<String> nombre = new ArrayList<String>();

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

        //Insert
        ContentValues cvDatos = new ContentValues();
        cvDatos.put("nombre", "Paulina Adriana");
        cvDatos.put("apellido", "Bolaos Estrada");
        sqlDB.insert("mitabla", null,cvDatos);
        cvDatos.clear();
        cvDatos.put("nombre", "Paul Adrian");
        cvDatos.put("apellido", "Bolaos Estrada");
        sqlDB.insert("mitabla", null,cvDatos);
        cvDatos.clear();
        cvDatos.put("nombre", "Pamela Alely");
        cvDatos.put("apellido", "Bolaos Estrada");
        sqlDB.insert("mitabla", null,cvDatos);
        cvDatos.clear();
        long iClave;
        cvDatos.put("nombre", "Rogelio");
        cvDatos.put("apellido", "Bolaos");
        iClave = sqlDB.insert("mitabla", null,cvDatos);
        Toast.makeText(this, iClave + "", Toast.LENGTH_LONG).show();

        //Update
        cvDatos.clear();
        cvDatos.put("nombre", "JUANELO");
        String[] args = {iClave + ""};
        sqlDB.update("mitabla", cvDatos, "id = ?", args);

        //Delete
        String[] args2 = {"PEDRO"};
        sqlDB.delete("mitabla", "nombre = ?", args2);

        //Cursor cursor = sqlDB.rawQuery("select * from mitabla;", null);
        String[] columns = {"id", "nombre", "apellido"};
        String[] args3 = {"Paul"};
        Cursor cursor = sqlDB.query("mitabla", columns, "nombre like ?", args3,
                null, null,"apellido");
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            nombre.add(cursor.getString(cursor.getColumnIndex("id")) + "" +
                    cursor.getString(cursor.getColumnIndex("nombre")) + "" +
                    cursor.getString(cursor.getColumnIndex("apellido")));
            cursor.moveToNext();
        }
        listVwDatos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                nombre));
    }
}
