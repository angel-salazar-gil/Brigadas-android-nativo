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
import com.example.myapplication.objetivo3.retrofit.Model.Sucursales;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapterSucursales extends RecyclerView.Adapter<CustomAdapterSucursales.CustomViewHolder> {

    private List<Sucursales> dataList2;
    private Context context2;

    public CustomAdapterSucursales(Context context2, List<Sucursales> dataList2){
        this.context2 = context2;
        this.dataList2 = dataList2;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.row_sucursales, parent, false);

        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        holder.txtDescipcion.setText(dataList2.get(position).getDescripcion());
        holder.txtDireccion.setText(dataList2.get(position).getDireccion());

        Picasso.Builder builder = new Picasso.Builder(context2);
        builder.downloader(new OkHttp3Downloader(context2));
        builder.build().load(dataList2.get(position).getImagen())
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
                .into(holder.coverImageS);

    }

    @Override
    public int getItemCount() {
        return dataList2.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;

        TextView txtDescipcion;
        TextView txtDireccion;
        ImageView coverImageS;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;

            txtDescipcion = mView.findViewById(R.id.descripcion);
            txtDireccion = mView.findViewById(R.id.direccion);
            coverImageS = mView.findViewById(R.id.coverImageS);
        }
    }
}
