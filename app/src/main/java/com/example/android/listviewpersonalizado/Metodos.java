package com.example.android.listviewpersonalizado;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by android on 21/10/2017.
 */

public class Metodos {
    private Resources res;
    private Carro c;
    public static int fotoAleatoria(ArrayList<Integer> fotos){
        int fotoSeleccionada;
        Random r = new Random();
        fotoSeleccionada = r.nextInt(fotos.size());
        return fotos.get(fotoSeleccionada);
    }

    public static Bundle crear_bundle(Carro c){
        Bundle b = new Bundle();
        b.putString("id", c.getId());
        b.putInt("foto", c.getFoto());
        b.putString("placa", c.getPlaca());
        b.putString("marca", c.getMarca());
        b.putString("modelo", c.getModelo());
        b.putString("color", c.getColor());
        b.putString("precio", c.getPrecio());

        return b;
    }

    public static boolean carrosIguales(Carro c1, Carro c2){
        if(c1.getPlaca().equalsIgnoreCase(c2.getPlaca())){
            return  true;
        }
        return false;
    }

    public static boolean placaExiste(ArrayList<Carro> carros, String placa){
        for (int i = 0; i <carros.size() ; i++) {
            if(carros.get(i).getPlaca().equalsIgnoreCase(placa)){
                return true;
            }
        }
        return false;

    }



}
