package com.example.molowsapp.circuits;

import android.os.Parcel;
import android.os.Parcelable;

public class Item_Racing implements Parcelable {
    private String fecha;
    private int idImagenRacing;
    private String titulo;
    private  String pais;
    private String descripcion;

    public Item_Racing(String fecha, int idImagenRacing, String titulo, String pais, String descripcion) {
        this.fecha = fecha;
        this.idImagenRacing = idImagenRacing;
        this.titulo = titulo;
        this.pais = pais;
        this.descripcion = descripcion;
    }

    protected Item_Racing(Parcel in) {
        fecha = in.readString();
        idImagenRacing = in.readInt();
        titulo = in.readString();
        pais = in.readString();
        descripcion = in.readString();
    }

    public static final Creator<Item_Racing> CREATOR = new Creator<Item_Racing>() {
        @Override
        public Item_Racing createFromParcel(Parcel in) {
            return new Item_Racing(in);
        }

        @Override
        public Item_Racing[] newArray(int size) {
            return new Item_Racing[size];
        }
    };

    public String getFecha() {
        return fecha;
    }

    public int getIdImagenRacing() {
        return idImagenRacing;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getPais() {
        return pais;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(fecha);
        dest.writeInt(idImagenRacing);
        dest.writeString(titulo);
        dest.writeString(pais);
        dest.writeString(descripcion);
    }
}
