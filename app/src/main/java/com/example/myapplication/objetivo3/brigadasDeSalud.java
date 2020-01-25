package com.example.myapplication.objetivo3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.objetivo3.retrofit.Interface.BrigadasApi;
import com.example.myapplication.objetivo3.retrofit.Model.Brigadas;
import com.example.myapplication.objetivo3.retrofit.Network.RetrofitInstance;
import com.example.myapplication.objetivo3.retrofit.adapter.CustomAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class brigadasDeSalud extends AppCompatActivity {

    private CustomAdapter adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brigadas_de_salud);

        progressDialog = new ProgressDialog(brigadasDeSalud.this);
        //progressDialog.setTitle("Cargamdo...");
        progressDialog.show();
        progressDialog.setContentView(R.layout.layout_pdialog);

        BrigadasApi service = RetrofitInstance.getRetrofitInstance().create(BrigadasApi.class);
        Call<List<Brigadas>> call = service.getBrigadas();

        call.enqueue(new Callback<List<Brigadas>>() {
            @Override
            public void onResponse(Call<List<Brigadas>> call, Response<List<Brigadas>> response) {
                progressDialog.dismiss();
                generateList(response.body());
            }

            @Override
            public void onFailure(Call<List<Brigadas>> call, Throwable t) {
                progressDialog.dismiss();
                Toast.makeText(brigadasDeSalud.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateList(List<Brigadas> brigadasList) {
        recyclerView = findViewById(R.id.recyclerView);
        adapter = new CustomAdapter(this, brigadasList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(brigadasDeSalud.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }



    /*
    private void getBrigadas(){
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
                    TituloJsonList.setText("Codigo de error: "+response.code());
                    return;
                }

                List<Brigadas> postList = response.body();

                for (Brigadas brigadas: postList){
                    if (brigadas.getTipo().equals("Brigada de consulta medica")){

                        //String content = "";
                        //content += "_id: "+ brigadas.get_Id() + "\n";
                        String titulo = "tipo: "+ brigadas.getTipo() + "\n";
                        //content += "descripcion: "+ brigadas.getDescripcion() + "\n";
                        String fecha = "horario: "+ brigadas.getHorario() + "\n";
                        //content += "direccion: "+ brigadas.getDireccion() + "\n";
                        //content += "latitud: "+ brigadas.getLatitud() + "\n";
                        //content += "longitud: "+ brigadas.getLongitud() + "\n\n";

                        TituloJsonList.append(titulo);
                        FechaJsonList.append(fecha);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Brigadas>> call, Throwable t) {
                TituloJsonList.setText(t.getMessage());
            }
        });
    }

     */
}
