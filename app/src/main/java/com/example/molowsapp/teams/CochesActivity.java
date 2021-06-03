package com.example.molowsapp.teams;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.molowsapp.DashboardActivity;
import com.example.molowsapp.R;
import com.example.molowsapp.circuits.RacingActivity;

public class CochesActivity extends AppCompatActivity {

    public static final String CLAVE_DATOS_ESCUDERIA = "DATOSESCUDERIA";
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.escuderias_activity);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Escuderias");
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        rv = findViewById(R.id.rvEscuderia);

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        final Datos_Escuderias datos = new Datos_Escuderias();
        AdapterEscuderias ae = new AdapterEscuderias(datos.getDatos());
        ae.setListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = rv.getChildAdapterPosition(v);
                Item_Escuderias elemento = datos.getDatos().get(i);

                Intent intentDatos = new Intent(getApplicationContext(), DatosActivityEscuderia.class);
                intentDatos.putExtra(CLAVE_DATOS_ESCUDERIA, elemento);
                startActivity(intentDatos);
            }
        });
        rv.setAdapter(ae);

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    public void pilotos(View view) {
        /*Intent i = new Intent(this, PilotosActivity.class);
        startActivity(i);*/
    }

    public void noticias(View view) {
        Intent i = new Intent(this, DashboardActivity.class);
        startActivity(i);
    }

    public void circuitos(View view) {
        Intent i = new Intent(this, RacingActivity.class);
        startActivity(i);
    }

}