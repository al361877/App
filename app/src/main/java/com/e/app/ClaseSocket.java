package com.e.app;

import android.util.Log;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ClaseSocket {

Socket sk;


public void run(){

    while (true){
        try{
            String ip;
            int puerto;
            //socket cliente
            sk= new Socket();
            //Creamos los objetos para leer y escribir en el socket
            BufferedReader in = new BufferedReader(new InputStreamReader(sk.getInputStream()));
            PrintStream out = new PrintStream(new BufferedOutputStream(sk.getOutputStream()));

            sk.close();
        }catch (IOException e) {
            e.printStackTrace();
            Log.e("socket","error en socket");
        }

    }


}
}
