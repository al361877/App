package com.e.app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
//variables de la interfaz
    Button abrir;
    Button cerrar;
    Switch cierreAutomatico;
    EditText editTextTime;
    Switch bloquear;
    TextView estado;
    String readResource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        abrir=(Button)findViewById(R.id.abrir);
        cerrar=(Button)findViewById(R.id.cerrar);
        cierreAutomatico=(Switch) findViewById(R.id.cierreAutomatico);
        editTextTime=(EditText) findViewById(R.id.editTextTime);
        bloquear=(Switch) findViewById(R.id.bloquear);
        estado=(TextView) findViewById(R.id.estado);




    }

    public void onClickAbrir(View view) {
        if(estado.getText().equals("Abierto")){
            Toast.makeText(getApplicationContext(),"Error, ya está abierto",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(),"Abriendo",Toast.LENGTH_SHORT).show();
            estado.setText("Abierto");
        }


    }
    public void onClickCerrar(View view){
        if(estado.getText().equals("Cerrado")){
            Toast.makeText(getApplicationContext(),"Error, ya está cerrado",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getApplicationContext(),"Cerrando",Toast.LENGTH_SHORT).show();
            estado.setText("Cerrado");
        }

    }

}