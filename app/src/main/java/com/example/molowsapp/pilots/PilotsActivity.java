package com.example.molowsapp.pilots;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.molowsapp.DashboardActivity;
import com.example.molowsapp.MainActivity;
import com.example.molowsapp.R;
import com.example.molowsapp.circuits.RacingActivity;
import com.example.molowsapp.teams.CochesActivity;

public class PilotsActivity extends AppCompatActivity {

    public static  final String KEY_PILOTS_INFO = "PILOTSINFO";
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pilots);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Pilots");
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        rv = findViewById(R.id.rvPilots);

        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));

        final info_pilots datos = new info_pilots();
        AdapterPilots ae = new AdapterPilots(datos.getDatos());
        ae.setListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = rv.getChildAdapterPosition(v);
                pilots elemento = datos.getDatos().get(i);

                Intent intentDatos = new Intent(getApplicationContext(), InfoPilotsActivity.class);
                intentDatos.putExtra(KEY_PILOTS_INFO, elemento);
                startActivity(intentDatos);
            }
        });
        rv.setAdapter(ae);
    }

    public void news(View view) {
        Intent i = new Intent(this, DashboardActivity.class);
        startActivity(i);
    }

    public void circuits(View view) {
        Intent i = new Intent(this, RacingActivity.class);
        startActivity(i);
    }

    public void teams(View view) {
        Intent i = new Intent(this, CochesActivity.class);
        startActivity(i);
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

}