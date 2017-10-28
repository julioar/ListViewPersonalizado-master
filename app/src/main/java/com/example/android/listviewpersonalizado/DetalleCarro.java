package com.example.android.listviewpersonalizado;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Modifier;

public class DetalleCarro extends AppCompatActivity {
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private Carro c;
    private int fot;
    private Bundle bundle;
    private Intent i;
    private ImageView foto;
    private Resources res;
    private TextView plac, mod,marc,col,pre;
    private String placa, marca, modelo, color, precio,id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_carro);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar2);
        //setSupportActionBar(toolbar);

        plac = (TextView)findViewById(R.id.lblPlacaD);
        marc = (TextView)findViewById(R.id.lblMarcaD);
        mod = (TextView)findViewById(R.id.lblModeloD);
        col = (TextView)findViewById(R.id.lblColorD);
        pre = (TextView)findViewById(R.id.lblPrecioD);

        collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collapsing_toolbar);

        foto = (ImageView) findViewById(R.id.fotoCarro);
        res = this.getResources();
        i = getIntent();
        bundle = i.getBundleExtra("datos");

        placa = bundle.getString("placa");

        marca = bundle.getString("marca");
        modelo = bundle.getString("modelo");
        color = bundle.getString("color");
        precio = bundle.getString("precio");
        fot = bundle.getInt("foto");
        id = bundle.getString("id");


        collapsingToolbarLayout.setTitle(marca);
        foto.setImageDrawable(ResourcesCompat.getDrawable(res,fot,null));
        plac.setText(placa);
        marc.setText(marca);
        col.setText(color);
        mod.setText(modelo);

        pre.setText(precio);

    }

    public void eliminar(View v){
        String positivo,negativo;

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(res.getString(R.string.titulo_eliminar_mensaje));
        builder.setMessage(res.getString(R.string.eliminar_mensaje));
        positivo = res.getString(R.string.si_eliminar_mensaje);
        negativo = res.getString(R.string.no_eliminar_mensaje);



        builder.setPositiveButton(positivo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Carro c = new Carro(id);
                c.eliminar();
                onBackPressed();

            }
        });
        builder.setNegativeButton(negativo, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();

    }

    public void onBackPressed(){
        finish();
        Intent i = new Intent(DetalleCarro.this,Principal.class);
        startActivity(i);
    }

    public void editar(View v){
        Intent i = new Intent(DetalleCarro.this, Modificar.class);
        Bundle b = new Bundle();
        b.putString("id", id);
        b.putInt("foto", fot);
        b.putString("placa", placa);
        b.putString("marca", marca);
        b.putString("modelo", modelo);
        b.putString("color", color);
        b.putString("precio", precio);

        i.putExtra("editar",b);
        startActivity(i);
    }

    /*public void editarCarro2(View v){
        finish();

        Intent i = new Intent(DetalleCarro.this, Modificar.class);
        Bundle b = Metodos.crear_bundle(c);
        i.putExtra("datos",b);
        startActivity(i);
    }*/




}
