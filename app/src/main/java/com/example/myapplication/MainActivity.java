package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.objetivo3.DetallesObjetivo3;
import com.example.myapplication.objetivo3.MenuObjetivo3;

public class MainActivity extends Activity {

    Button btnDetallesObj1;
    Button btnDetallesObj2;
    Button btnAccesoObj3;
    //CardView CardObjetivo3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDetallesObj1 = findViewById(R.id.btnDetallesObj1);
        btnDetallesObj1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, DetallesObjetivo1.class);
                startActivity(myIntent);
            }
        });

        btnDetallesObj2 = findViewById(R.id.btnDetallesObj2);
        btnDetallesObj2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, DetallesObjetivo3.class);
                startActivity(myIntent);
            }
        });

        btnAccesoObj3 = findViewById(R.id.btnAccesoObj3);
        btnAccesoObj3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, MenuObjetivo3.class);
                startActivity(myIntent);
            }
        });
    }

}
