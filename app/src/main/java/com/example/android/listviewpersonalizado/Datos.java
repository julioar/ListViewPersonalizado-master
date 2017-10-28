package com.example.android.listviewpersonalizado;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

/**
 * Created by android on 21/10/2017.
 */

public class Datos {

    private static  String db = "Carros";
    private static DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();
    private static ArrayList<Carro> carros = new ArrayList();

    public static void guardarCarros(Carro c){

        c.setId(databaseReference.push().getKey());
        databaseReference.child(db).child(c.getId()).setValue(c);
    }

    public static void eliminarCarro(Carro c){
        databaseReference.child(db).child(c.getId()).removeValue();

    }

    public static void setCarros(ArrayList<Carro> car){
        carros = car;
    }

    public static ArrayList<Carro> obtenerCarros(){
        return carros;
    }

    public static void ModificarCarro(Carro c) {
        databaseReference.child(db).child(c.getId()).setValue(c);
    }

}
