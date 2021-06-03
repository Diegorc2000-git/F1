package com.example.molowsapp.teams;

import android.os.Parcel;
import android.os.Parcelable;

public class Item_Escuderias implements Parcelable {
    private String posicion;
    private String escuderia;
    private String pilotos;
    private int idImagenCoche;
    private int idImagenDatos;

    public Item_Escuderias(String posicion, String escuderia, String pilotos, int idImagenCoche, int idImagenDatos) {
        this.posicion = posicion;
        this.escuderia = escuderia;
        this.pilotos = pilotos;
        this.idImagenCoche = idImagenCoche;
        this.idImagenDatos = idImagenDatos;
    }

    protected Item_Escuderias(Parcel in) {
        posicion = in.readString();
        escuderia = in.readString();
        pilotos = in.readString();
        idImagenCoche = in.readInt();
        idImagenDatos = in.readInt();

    }

    public static final Creator<Item_Escuderias> CREATOR = new Creator<Item_Escuderias>() {
        @Override
        public Item_Escuderias createFromParcel(Parcel in) {
            return new Item_Escuderias(in);
        }

        @Override
        public Item_Escuderias[] newArray(int size) {
            return new Item_Escuderias[size];
        }
    };

    public String getPosicion() {
        return posicion;
    }

    public String getEscuderia() {
        return escuderia;
    }

    public String getPilotos() {
        return pilotos;
    }

    public int getIdImagenCoche() {
        return idImagenCoche;
    }

    public int getIdImagenDatos() {
        return idImagenDatos;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(posicion);
        dest.writeString(escuderia);
        dest.writeString(pilotos);
        dest.writeInt(idImagenCoche);
        dest.writeInt(idImagenDatos);

    }
}