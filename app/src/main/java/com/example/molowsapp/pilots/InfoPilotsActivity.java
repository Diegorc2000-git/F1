package com.example.molowsapp.pilots;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.molowsapp.R;

public class InfoPilotsActivity extends AppCompatActivity {

    ImageView ivPilot;
    TextView tvPilot;
    TextView tvDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_pilots);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setTitle("Pilots Information");
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        ivPilot = findViewById(R.id.ivPilot);
        tvPilot = findViewById(R.id.tvPilot);
        tvDescription = findViewById(R.id.tvDescription);

        pilots pilots = getIntent().getParcelableExtra(PilotsActivity.KEY_PILOTS_INFO);

        ivPilot.setImageResource(pilots.getIdImagenPilot());
        tvPilot.setText(pilots.getName());
        tvDescription.setText(pilots.getDescription());

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

}