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

public class CrearCarro extends AppCompatActivity {

    private EditText txtPlaca;
    private EditText txtMarca, txtModelo, txtPrecio, txtColor;
    private TextInputLayout cajaPlaca, cajaMarca, cajaModelo, cajaPrecio,cajaColor;

    private ArrayList<Integer>fotos;
    private Resources res;
    private Spinner color;
    private ArrayAdapter<String>adapter;
    private String[]opc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_carro);

        txtPlaca = (EditText)findViewById(R.id.txtPlaca);
        txtMarca = (EditText)findViewById(R.id.txtMarca);
        txtModelo = (EditText)findViewById(R.id.txtModelo);
        txtColor = (EditText)findViewById(R.id.txtColor);
        txtPrecio = (EditText)findViewById(R.id.txtPrecio);

        res = this.getResources();
        cajaPlaca = (TextInputLayout) findViewById(R.id.cajaPlaca);
        cajaMarca = (TextInputLayout)findViewById(R.id.cajaMarca);
        cajaModelo = (TextInputLayout)findViewById(R.id.cajaModelo);
        cajaColor = (TextInputLayout)findViewById(R.id.cajaColor);
        cajaPrecio = (TextInputLayout)findViewById(R.id.cajaPrecio);

        opc = res.getStringArray(R.array.color);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,opc);
        //color.setAdapter(adapter);

        iniciar_fotos();

    }

    public void iniciar_fotos(){
        fotos = new ArrayList<>();
        fotos.add(R.drawable.images);
        fotos.add(R.drawable.images2);
        fotos.add(R.drawable.images3);
    }

    public void guardar(View v){
        if (validar()) {
            Carro p = new Carro(Metodos.fotoAleatoria(fotos), txtPlaca.getText().toString(),
                    txtMarca.getText().toString(), txtModelo.getText().toString(), txtColor.getText().toString(), txtPrecio.getText().toString());
            p.guardar();
            Snackbar.make(v, res.getString(R.string.mensaje_guardado), Snackbar.LENGTH_LONG).setAction("Action", null).show();
            limpiar();
        }
    }

    public void limpiar(View v){
        limpiar();
    }

    public void limpiar(){
        txtPlaca.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        txtColor.setText("");
        txtPrecio.requestFocus();

    }



    public boolean validar(){
        if (validar_vacio(txtPlaca, cajaPlaca))return false;
        else if (validar_vacio(txtMarca, cajaMarca))return false;
        else if (validar_vacio(txtModelo, cajaModelo))return false;
        else if (validar_vacio(txtColor,cajaColor)) return false;
        else if (validar_vacio(txtPrecio,cajaPrecio))return false;

        return true;

    }

    public boolean validar_vacio(TextView t, TextInputLayout ct){
        if (t.getText().toString().isEmpty()){
            t.requestFocus();
            t.setError(res.getString(R.string.no_vacio_error));
            return true;
        }
        return false;
    }
}
