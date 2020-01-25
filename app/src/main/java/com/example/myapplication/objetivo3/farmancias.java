package com.example.myapplication.objetivo3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.example.myapplication.R;
import com.example.myapplication.objetivo3.retrofit.adapter.CustomAdapterFarmanias;

public class farmancias extends AppCompatActivity {

    private CustomAdapterFarmanias adapter;
    private RecyclerView recyclerView;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmancias);

        progressDialog = new ProgressDialog(farmancias.this);
        progressDialog.show();
        progressDialog.setContentView(R.layout.layout_pdialog);


    }
}
