package com.example.myapplication.objetivo3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.objetivo3.retrofit.Interface.SucursalesApi;
import com.example.myapplication.objetivo3.retrofit.Model.Brigadas;
import com.example.myapplication.objetivo3.retrofit.Interface.BrigadasApi;
import com.example.myapplication.objetivo3.retrofit.Model.Sucursales;
import com.example.myapplication.objetivo3.retrofit.Network.RetrofitInstance;
import com.example.myapplication.objetivo3.retrofit.adapter.CustomAdapter;
import com.example.myapplication.objetivo3.retrofit.adapter.CustomAdapterSucursales;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class centroDeSalud extends AppCompatActivity {

    Button btnMyNss;
    Button btnAjendaCita;
    private CustomAdapterSucursales adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDialog;
    //TextView myJsonTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_centro_de_salud);

        btnMyNss = findViewById(R.id.btnMyNss);
        btnMyNss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(centroDeSalud.this, consultaNSS.class);
                startActivity(myIntent);
            }
        });

        btnAjendaCita = findViewById(R.id.btnAjendaCita);
        btnAjendaCita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(centroDeSalud.this, ajendaCita.class);
                startActivity(myIntent);
            }
        });

        progressDialog = new ProgressDialog(centroDeSalud.this);
        //progressDialog.setTitle("Loading...");
        progressDialog.show();
        progressDialog.setContentView(R.layout.layout_pdialog);

        SucursalesApi service = RetrofitInstance.getRetrofitInstance().create(SucursalesApi.class);
        Call<List<Sucursales>> call = service.getSucursales();

        call.enqueue(new Callback<List<Sucursales>>() {
            @Override
            public void onResponse(Call<List<Sucursales>> call, Response<List<Sucursales>> response) {
                progressDialog.dismiss();
                generateList(response.body());
            }

            @Override
            public void onFailure(Call<List<Sucursales>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(centroDeSalud.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        //myJsonTextView = findViewById(R.id.jsonText);
        //getPosts();
    }

    private void generateList(List<Sucursales> sucursalesList) {
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new CustomAdapterSucursales(this, sucursalesList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(centroDeSalud.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }











    /*
    private void getPosts(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://shrouded-harbor-97268.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        BrigadasApi BrigadasApi = retrofit.create(com.example.myapplication.objetivo3.retrofit.Interface.BrigadasApi.class);
        Call<List<Brigadas>> call = BrigadasApi.getBrigadas();
        call.enqueue(new Callback<List<Brigadas>>() {
            @Override
            public void onResponse(Call<List<Brigadas>> call, Response<List<Brigadas>> response) {
                if (!response.isSuccessful()){
                    myJsonTextView.setText("Codigo de error: "+response.code());
                    return;
                }

                List<Brigadas> postList = response.body();

                for (Brigadas brigadas: postList){
                    String content = "";
                    content += "_id: "+ brigadas.get_Id() + "\n";
                    content += "tipo: "+ brigadas.getTipo() + "\n";
                    content += "descripcion: "+ brigadas.getDescripcion() + "\n";
                    content += "horario: "+ brigadas.getHorario() + "\n";
                    content += "direccion: "+ brigadas.getDireccion() + "\n";
                    content += "latitud: "+ brigadas.getLatitud() + "\n";
                    content += "longitud: "+ brigadas.getLongitud() + "\n\n";
                    myJsonTextView.append(content);
                }
            }

            @Override
            public void onFailure(Call<List<Brigadas>> call, Throwable t) {
                myJsonTextView.setText(t.getMessage());
            }
        });
    }

     */
}
