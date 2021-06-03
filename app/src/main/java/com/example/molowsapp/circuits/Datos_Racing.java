package com.example.molowsapp.circuits;



import com.example.molowsapp.R;

import java.util.ArrayList;

public class Datos_Racing {

    private ArrayList<Item_Racing> datos_racing;

    public Datos_Racing(){
        datos_racing = new ArrayList<Item_Racing>();
        datos_racing.add(new Item_Racing("26/28 APR", R.drawable.circuit_bahrain, "ROUND 1","Bahrain", "Formula 1 Gulf Air Bahrain Grand Prix 2021" ));
        datos_racing.add(new Item_Racing("16/18 APR", R.drawable.circuit_italia,"ROUND 2", "Italy", "Formula 1 Gulf Air Bahrain Grand Prix 2021" ));
        datos_racing.add(new Item_Racing("30/02 \nAPR/MAY", R.drawable.circuit_portugal,"ROUND 3", "Portgal", "Formula 1 Gulf Air Bahrain Grand Prix 2021" ));
        datos_racing.add(new Item_Racing("07/09 MAY", R.drawable.circuit_espania,"ROUND 4", "España", "Formula 1 Gulf Air Bahrain Grand Prix 2021" ));
        datos_racing.add(new Item_Racing("20/23 MAY", R.drawable.circuit_monaco,"ROUND 5", "Monaco", "Formula 1 Gulf Air Bahrain Grand Prix 2021" ));
        datos_racing.add(new Item_Racing("04/06 JUN", R.drawable.circuit_azerbaijan,"ROUND 6", "Azerbaijan", "Formula 1 Gulf Air Bahrain Grand Prix 2021" ));
        datos_racing.add(new Item_Racing("11/13 JUN", R.drawable.circuit_canada,"ROUND 7", "Canada", "Formula 1 Gulf Air Bahrain Grand Prix 2021" ));
        datos_racing.add(new Item_Racing("25/27 JUN", R.drawable.circuit_francia,"ROUND 8", "Francia", "Formula 1 Gulf Air Bahrain Grand Prix 2021" ));
        datos_racing.add(new Item_Racing("02/04 JUL", R.drawable.circuit_austria,"ROUND 9", "Austria", "Formula 1 Gulf Air Bahrain Grand Prix 2021" ));
        datos_racing.add(new Item_Racing("16/18 JUL", R.drawable.circuit_great_britain,"ROUND 10", "Great Britain", "Formula 1 Gulf Air Bahrain Grand Prix 2021" ));
        datos_racing.add(new Item_Racing("30/01 \nJUL-AUG", R.drawable.circuit_hungary,"ROUND 11", "Hungary", "Formula 1 Gulf Air Bahrain Grand Prix 2021" ));
        datos_racing.add(new Item_Racing("27/29 AUG", R.drawable.circuit_belgium,"ROUND 12", "Belgiums", "Formula 1 Gulf Air Bahrain Grand Prix 2021" ));
        datos_racing.add(new Item_Racing("03-05 SEP", R.drawable.circuit_netherlands,"ROUND 13", "Netherlans", "Formula 1 Gulf Air Bahrain Grand Prix 2021" ));
        datos_racing.add(new Item_Racing("10/12 SEP", R.drawable.circuit_italy,"ROUND 14", "Italy", "Formula 1 Gulf Air Bahrain Grand Prix 2021" ));
        datos_racing.add(new Item_Racing("24/26 SEP", R.drawable.circuit_russia,"ROUND 15", "Russia", "Formula 1 Gulf Air Bahrain Grand Prix 2021" ));
        datos_racing.add(new Item_Racing("01/03 OCT", R.drawable.circuit_singapore,"ROUND 16", "Singapore", "Formula 1 Gulf Air Bahrain Grand Prix 2021" ));
        datos_racing.add(new Item_Racing("08/10 OCT", R.drawable.circuit_japan,"ROUND 17", "Japan", "Formula 1 Gulf Air Bahrain Grand Prix 2021" ));
        datos_racing.add(new Item_Racing("22/24 OCT", R.drawable.circuit_united_states,"ROUND 18", "United States", "Formula 1 Gulf Air Bahrain Grand Prix 2021" ));
        datos_racing.add(new Item_Racing("29/31 OCT", R.drawable.circuit_mexico,"ROUND 19", "Mexico", "Formula 1 Gulf Air Bahrain Grand Prix 2021" ));
        datos_racing.add(new Item_Racing("05/07 NOV", R.drawable.circuit_brazil,"ROUND 20", "Brazil", "Formula 1 Gulf Air Bahrain Grand Prix 2021" ));
        datos_racing.add(new Item_Racing("19/21 NOV", R.drawable.circuit_australia,"ROUND 21", "Australia", "Formula 1 Gulf Air Bahrain Grand Prix 2021" ));
        datos_racing.add(new Item_Racing("03/05 DEC", R.drawable.circuit_saudi_arabia,"ROUND 22", "Saudi Arabia", "Formula 1 Gulf Air Bahrain Grand Prix 2021" ));
        datos_racing.add(new Item_Racing("10/12 DEC", R.drawable.circuit_abu_dhabi,"ROUND 23", "Abu Dhabi", "Formula 1 Gulf Air Bahrain Grand Prix 2021" ));
    }

    public ArrayList<Item_Racing> getDatos_racing(){
        return datos_racing;
    }
}
