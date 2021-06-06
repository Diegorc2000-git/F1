package com.example.molowsapp.teams;

import com.example.molowsapp.R;

import java.util.ArrayList;

public class Datos_Escuderias {

    private ArrayList<Item_Escuderias> datos;

    public Datos_Escuderias() {
        datos = new ArrayList<Item_Escuderias>();
        datos.add(new Item_Escuderias("1", "Mercedes", "Bottas / Hamilton", R.drawable.car_mercedes, R.drawable.datos_mercedes_pilotos));
        datos.add(new Item_Escuderias("2", "Red Bull Racing", "Perez / Verstappen", R.drawable.car_redbull, R.drawable.datos_redbull_pilotos));
        datos.add(new Item_Escuderias("3", "Mclaren", "Ricciardo / Norris", R.drawable.car_mclaren, R.drawable.datos_mclaren_pilotos));
        datos.add(new Item_Escuderias("4", "Ferrari", "Sainz / Lecler", R.drawable.car_ferrari, R.drawable.datos_ferrari_pilotos));
        datos.add(new Item_Escuderias("5", "AlphaTauri", "Gasly / Tsunoda", R.drawable.car_alphatauri, R.drawable.datos_alphatauri_pilotos));
        datos.add(new Item_Escuderias("6", "Aston Martin", "Vettel / Stroll", R.drawable.car_astonmartin, R.drawable.datos_astonmartin_pilotos));
        datos.add(new Item_Escuderias("7", "Alpine", "Alonso / Ocon", R.drawable.car_alpine, R.drawable.datos_alpine_pilotos));
        datos.add(new Item_Escuderias("8", "Alpha Romeo Racing", "Raikkonen / Giovinazzi", R.drawable.car_alpharomeo, R.drawable.datos_alpharomeo_pilotos));
        datos.add(new Item_Escuderias("9", "Williams", "Russel / Lafiti", R.drawable.car_williams, R.drawable.datos_williams_pilotos));
        datos.add(new Item_Escuderias("10", "Haas F1 Team", "Schumacher / Mazepin", R.drawable.car_haas, R.drawable.datos_williamshaas_pilotos));
    }

    public ArrayList<Item_Escuderias> getDatos() {
        return datos;
    }
}
