package com.e.app;

import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {
//variables de la interfaz
    Button abrir;
    Button cerrar;
    TextView cierreAuto;
    EditText editTextTime;
    Switch bloquear;
    TextView estado;
    String out;
    int puerto;
    String ip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        abrir=(Button)findViewById(R.id.abrir);
        cerrar=(Button)findViewById(R.id.cerrar);
        cierreAuto=(TextView) findViewById(R.id.cierreAuto);
        editTextTime=(EditText) findViewById(R.id.editTextTime);
        bloquear=(Switch) findViewById(R.id.bloquear);
        estado=(TextView) findViewById(R.id.estado);
        ip="192.168.1.175";
        puerto=80;

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitNetwork().build());

    }

    public void envio() {
        try {
            Socket socketCliente=new Socket(ip,puerto);
            PrintWriter salida = new PrintWriter(new OutputStreamWriter(socketCliente.getOutputStream()), true);
            salida.println(out);
            socketCliente.close();
        }catch (IOException e) {
            e.printStackTrace();
            Log.e("socket","Acceso denegado");
        }

}

    public void onClickAbrir(View view) {
        if(estado.getText().equals("Abierto")){
            Toast.makeText(getApplicationContext(),"Error, ya está abierto",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getApplicationContext(),"Abriendo",Toast.LENGTH_SHORT).show();
            abrir();
            envio();
            estado.setText("Abierto");

        }
    }
    public void abrir(){ out="a\n";}
    public void cerrar(){ out= "c\n";}

    public void onClickCerrar(View view){
        if(estado.getText().equals("Cerrado")){
            Toast.makeText(getApplicationContext(),"Error, ya está cerrado",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getApplicationContext(),"Cerrando",Toast.LENGTH_SHORT).show();
            cerrar();
            envio();
            estado.setText("Cerrado");
        }

    }



}