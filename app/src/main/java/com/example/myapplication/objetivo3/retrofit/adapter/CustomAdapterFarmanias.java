package com.example.myapplication.objetivo3.retrofit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.objetivo3.retrofit.Model.Farmancias;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

public class CustomAdapterFarmanias extends RecyclerView.Adapter<CustomAdapterFarmanias.CustomViewHolder> {

    private List<Farmancias> dataList3;
    private Context context3;

    public CustomAdapterFarmanias(Context context3, List<Farmancias> dataList3) {
        this.context3 = context3;
        this.dataList3 = dataList3;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_farmancias, parent, false);

        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.txtNombre.setText(dataList3.get(position).getFarmancia());
        holder.txtDireccion.setText(dataList3.get(position).getDireccion());

        Picasso.Builder builder = new Picasso.Builder(context3);
        builder.downloader(new OkHttp3Downloader(context3));
        builder.build().load(dataList3.get(position).getImagen())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(holder.coverImageF);
    }

    @Override
    public int getItemCount() {
        return dataList3.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView txtNombre;
        TextView txtDireccion;
        ImageView coverImageF;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;

            txtNombre = mView.findViewById(R.id.nombre);
            txtDireccion = mView.findViewById(R.id.direccion);
            coverImageF = mView.findViewById(R.id.coverImageF);
        }
    }
}
