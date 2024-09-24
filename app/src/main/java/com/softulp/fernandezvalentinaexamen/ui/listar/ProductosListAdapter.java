package com.softulp.fernandezvalentinaexamen.ui.listar;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softulp.fernandezvalentinaexamen.modelos.Producto;

import com.softulp.fernandezvalentinaexamen.R;

import java.util.List;
import java.util.Locale;

public class ProductosListAdapter extends RecyclerView.Adapter<ProductosListAdapter.ViewHolderProducto> {

    private List<Producto> productoList;
    private LayoutInflater li;

    public ProductosListAdapter(List<Producto> productoList, LayoutInflater li){
        this.productoList = productoList;
        this.li = li;
    }

    @NonNull
    @Override
    public ViewHolderProducto onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = li.inflate(R.layout.card_note, parent, false);
        return new ViewHolderProducto(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderProducto holder, int position) {
        holder.tvCode.setText("Cod. int:"+productoList.get(position).getCode());
        holder.tvStock.setText("Stock:"+ productoList.get(position).getStock());
        holder.tvDesc.setText(productoList.get(position).getDescription());
        holder.tvPrice.setText("$"+String.format(Locale.getDefault(), "%.2f", productoList.get(position).getPrice()));
    }

    @Override
    public int getItemCount() {
        return productoList.size();
    }

    public class ViewHolderProducto extends RecyclerView.ViewHolder {

        TextView tvCode;
        TextView tvDesc;
        TextView tvPrice;
        TextView tvStock;

        public ViewHolderProducto(@NonNull View itemView) {
            super(itemView);
            tvCode = itemView.findViewById(R.id.tvCode);
            tvDesc = itemView.findViewById(R.id.tvDescripcion);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            tvStock = itemView.findViewById(R.id.tvStock);
        }
    }

}
