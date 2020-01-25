package com.example.myapplication.objetivo3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.R;

public class MenuObjetivo3 extends AppCompatActivity {

    CardView cardObjetivo;
    CardView cardCentroSalud;
    CardView cardBrigadas;
    CardView cardFarmancias;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_objetivo3);

        cardObjetivo = findViewById(R.id.cardObjetivo);
        cardObjetivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MenuObjetivo3.this, DetallesObjetivo3.class);
                startActivity(myIntent);
            }
        });

        cardCentroSalud = findViewById(R.id.cardCentroDeSalud);
        cardCentroSalud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MenuObjetivo3.this, centroDeSalud.class);
                startActivity(myIntent);
            }
        });

        cardBrigadas = findViewById(R.id.cardBrigadas);
        cardBrigadas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MenuObjetivo3.this, brigadasDeSalud.class);
                startActivity(myIntent);
            }
        });

        cardFarmancias = findViewById(R.id.cardFarmancias);
        cardFarmancias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MenuObjetivo3.this, DetallesObjetivo3.class);
                startActivity(myIntent);
            }
        });
    }
}
