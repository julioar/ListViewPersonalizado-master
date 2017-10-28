package com.example.android.listviewpersonalizado;

/**
 * Created by android on 21/10/2017.
 */

public class Carro {
    private String id;
    private int foto;
    private String placa;
    private String marca;
    private String modelo;
    private String color;
    private String precio;

    public Carro(String id, int foto, String placa, String marca, String modelo, String color, String precio) {
        this.id = id;
        this.foto = foto;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
    }
    public Carro(String id){
        this.id=id;
    }
    public Carro( int foto, String placa, String marca, String modelo, String color, String precio) {
        this.foto = foto;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.precio = precio;
    }
    public  Carro() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public void guardar(){
        Datos.guardarCarros(this);
    }

    public void eliminar(){
        Datos.eliminarCarro(this);
    }


}




