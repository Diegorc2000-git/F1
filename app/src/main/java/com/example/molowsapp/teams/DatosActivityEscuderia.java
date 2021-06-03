package com.example.molowsapp.teams;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.molowsapp.R;

public class DatosActivityEscuderia extends AppCompatActivity {

    ImageView ivEscuderia;
    ImageView ivDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.escuderia_datos_activity);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Escuderias");
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        //ivEscuderia = findViewById(R.id.ivEscueria);
        ivDatos = findViewById(R.id.ivDatos);

        Item_Escuderias elemento = getIntent().getParcelableExtra(CochesActivity.CLAVE_DATOS_ESCUDERIA);

        //ivEscuderia.setImageResource(elemento.getIdImagenCoche());
        ivDatos.setImageResource(elemento.getIdImagenDatos());

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}