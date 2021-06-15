package com.sliceeup.testjujura.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sliceeup.testjujura.R;
import com.sliceeup.testjujura.model.Product;
import com.sliceeup.testjujura.model.Sales;

import java.util.ArrayList;

public class ListSalesAdapter extends RecyclerView.Adapter<ListSalesAdapter.MyViewHolder> {

    private OnItemClickCallback onItemClickCallback;

    private final ArrayList<Sales> listSales;

    public ListSalesAdapter(ArrayList<Sales> listSales) {
        this.listSales = listSales;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sales, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        Sales sales = listSales.get(position);

        holder.tvIdItem.setText(sales.getItem_id());
        holder.tvQty.setText(sales.getQty());
        holder.tvPrice.setText(sales.getPrice());
        holder.tvtotal.setText(sales.getTotal());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listSales.get(holder.getAdapterPosition()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return listSales.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvIdItem;
        private final TextView tvQty;
        private final TextView tvPrice;
        private final TextView tvtotal;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvIdItem = itemView.findViewById(R.id.tv_item_id);
            tvQty = itemView.findViewById(R.id.tv_qty);
            tvPrice = itemView.findViewById(R.id.tv_price);
            tvtotal = itemView.findViewById(R.id.tv_total);

        }
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public interface OnItemClickCallback {
        void onItemClicked(Sales data);
    }
}
