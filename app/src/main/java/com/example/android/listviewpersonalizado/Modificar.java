package com.example.android.listviewpersonalizado;

import android.content.Intent;
import android.content.res.Resources;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Modificar extends AppCompatActivity {

    private Resources res;
    private Intent i;
    private Bundle bundle;
    private int foto;
    private String id, placa, marca, modelo, color, precio;
    private Carro carro;

    private TextInputLayout iPlaca, iMarca, iModelo, iPrecio,iColor;
    private EditText txtplaca, txtmarca, txtmodelo, txtcolor,txtprecio;
    private Spinner scolor;

    private ArrayList<Integer> fotos;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar);

        res = this.getResources();

        iPlaca = (TextInputLayout)findViewById(R.id.cajaPlacaM);
        iMarca = (TextInputLayout)findViewById(R.id.cajaMarcaM);
        iModelo = (TextInputLayout)findViewById(R.id.cajaModeloM);
        iColor =  (TextInputLayout)findViewById(R.id.cajaColorM);
        iPrecio = (TextInputLayout)findViewById(R.id.cajaPrecioM);

        txtplaca = (EditText)findViewById(R.id.txtPlacaM);
        txtmarca = (EditText)findViewById(R.id.txtMarcaM);
        txtmodelo = (EditText)findViewById(R.id.txtModeloM);
        txtcolor = (EditText)findViewById(R.id.txtColorM);
        txtprecio = (EditText)findViewById(R.id.txtPrecioM);

        i = getIntent();
        bundle = i.getBundleExtra("editar");
        id = bundle.getString("id");
        foto = bundle.getInt("foto");
        placa = bundle.getString("placa");
        marca = bundle.getString("marca");
        modelo = bundle.getString("modelo");
        color = bundle.getString("color");
        precio = bundle.getString("precio");

        carro = new Carro(id, foto, placa, marca, modelo, color, precio);
        reiniciar();

    }

    public boolean validar(View v){
        if(validar_vacio(txtplaca, iPlaca)){
            return false;
        }else if (validar_vacio(txtmarca, iMarca)){
            return false;
        }else if(validar_vacio(txtmodelo, iModelo)){
            return false;
        }else if(validar_vacio(txtcolor, iColor)){
            return false;
        }else if(validar_vacio(txtprecio, iPrecio)){
            return false;
        }
        return true;
    }

    public boolean validar_vacio(TextView t, TextInputLayout ct){
        if (t.getText().toString().isEmpty()){
            t.requestFocus();
            t.setError(res.getString(R.string.vacio));
            return true;
        }
        return false;
    }
    public void modificar_carro(View v){
        if(validar(v)) {
            Carro c = new Carro(id, foto, txtplaca.getText().toString().trim(),
                    txtmarca.getText().toString().trim(), txtmodelo.getText().toString().trim(),
                    txtcolor.getText().toString(), txtprecio.getText().toString());
            if (Metodos.carrosIguales(carro, c)){
                Datos.ModificarCarro(c);
                Snackbar.make(v, res.getString(R.string.mensaje_exito_modificar), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                onBackPressed(c);
            } else if(Metodos.placaExiste(Datos.obtenerCarros(), c.getPlaca()) == false){
                Datos.ModificarCarro(c);
                Snackbar.make(v, res.getString(R.string.mensaje_exito_modificar), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                onBackPressed(c);
            }else{
                Snackbar.make(v, res.getString(R.string.error), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        }

    }

    private void reiniciar(){
        txtplaca.setText(placa);
        txtmarca.setText(marca);
        txtmodelo.setText(modelo);
        txtcolor.setText(color);
        txtprecio.setText(precio+"");
    }

    public void onBackPressed(Carro c){
        finish();
        Intent i = new Intent(Modificar.this, DetalleCarro.class);
        Bundle b = Metodos.crear_bundle(c);
        i.putExtra("datos", b);
        startActivity(i);
    }
}