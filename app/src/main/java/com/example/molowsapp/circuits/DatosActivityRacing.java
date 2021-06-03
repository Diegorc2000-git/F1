package com.example.molowsapp.circuits;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.molowsapp.R;


public class DatosActivityRacing extends AppCompatActivity {

    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.circuitos_datos_activity);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Cirtuitos");
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        iv = findViewById(R.id.ivCircuito);

        Item_Racing elemento  = getIntent().getParcelableExtra(RacingActivity.CLAVE_DATOS_RACING);

        iv.setImageResource(elemento.getIdImagenRacing());
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

}