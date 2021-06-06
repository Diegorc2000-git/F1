package com.example.molowsapp.circuits;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.molowsapp.DashboardActivity;
import com.example.molowsapp.R;
import com.example.molowsapp.pilots.PilotsActivity;
import com.example.molowsapp.teams.CochesActivity;

public class RacingActivity extends AppCompatActivity {

    public static final String CLAVE_DATOS_RACING = "DATOSRACING";
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.circuitos_activity);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Circuitos");
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        rv = findViewById(R.id.rvRacing);

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        final Datos_Racing datos = new Datos_Racing();
        AdapterRacing ar = new AdapterRacing(datos.getDatos_racing());
        ar.setListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = rv.getChildAdapterPosition(v);
                Item_Racing elementor = datos.getDatos_racing().get(i);

                Intent intentDatos = new Intent(getApplicationContext(), DatosActivityRacing.class);
                intentDatos.putExtra(CLAVE_DATOS_RACING, elementor);
                startActivity(intentDatos);
            }
        });
        rv.setAdapter(ar);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    public void conductores(View view) {
        Intent i = new Intent(this, CochesActivity.class);
        startActivity(i);
    }

    public void pilotos(View view) {
        Intent i = new Intent(this, PilotsActivity.class);
        startActivity(i);
    }

    public void noticias(View view) {
        Intent i = new Intent(this, DashboardActivity.class);
        startActivity(i);
    }

}