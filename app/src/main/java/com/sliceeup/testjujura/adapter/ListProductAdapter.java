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

import java.util.ArrayList;

public class ListProductAdapter extends RecyclerView.Adapter<ListProductAdapter.MyViewHolder> {

    private OnItemClickCallback onItemClickCallback;

    private final ArrayList<Product> listProduct;

    public ListProductAdapter(ArrayList<Product> listProduct) {
        this.listProduct = listProduct;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        Product product = listProduct.get(position);

        holder.tvIdProduct.setText(product.getProduct_id());
        holder.tvName.setText(product.getName());
        holder.tvPrice.setText(product.getPrice());
        holder.tvStock.setText(product.getStock());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listProduct.get(holder.getAdapterPosition()));
            }
        });

        holder.btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.btnAdd.setVisibility(View.VISIBLE);
                holder.btnRemove.setVisibility(View.VISIBLE);
                holder.edQty.setVisibility(View.VISIBLE);
                holder.edQty.setText("1");
                int stock = Integer.parseInt(holder.tvStock.getText().toString());
                stock = stock-1;
                holder.tvStock.setText(String.valueOf(stock));
                holder.btnAddItem.setVisibility(View.GONE);
            }
        });

        holder.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int qty = Integer.parseInt(holder.edQty.getText().toString());
                int stock = Integer.parseInt(holder.tvStock.getText().toString());

                if(stock <= 0){
                    Toast.makeText(v.getContext(), "Stock Habis", Toast.LENGTH_SHORT).show();
                } else {
                    qty = qty+1;
                    holder.edQty.setText(String.valueOf(qty));
                    stock = stock-1;
                    holder.tvStock.setText(String.valueOf(stock));
                }

            }
        });

        holder.btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int qty = Integer.parseInt(holder.edQty.getText().toString());
                int stock = Integer.parseInt(holder.tvStock.getText().toString());
                if(qty < 1){
                    Toast.makeText(v.getContext(), "Item dihapus", Toast.LENGTH_SHORT).show();
                    holder.btnAdd.setVisibility(View.GONE);
                    holder.btnRemove.setVisibility(View.GONE);
                    holder.edQty.setVisibility(View.GONE);
                    holder.edQty.setText("0");
                    holder.btnAddItem.setVisibility(View.VISIBLE);
                } else {
                    qty = qty-1;
                    holder.edQty.setText(String.valueOf(qty));
                    stock = stock+1;
                    holder.tvStock.setText(String.valueOf(stock));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listProduct.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView tvIdProduct;
        private final TextView tvName;
        private final TextView tvPrice;
        private final TextView tvStock;
        private final ImageButton btnAdd;
        private final ImageButton btnRemove;
        private final EditText edQty;
        private final Button btnAddItem;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvIdProduct = itemView.findViewById(R.id.tv_product_id);
            tvName = itemView.findViewById(R.id.tv_name);
            tvPrice = itemView.findViewById(R.id.tv_price);
            tvStock = itemView.findViewById(R.id.tv_stock);
            btnAdd = itemView.findViewById(R.id.img_btn_add);
            btnRemove =itemView.findViewById(R.id.img_btn_remove);
            edQty = itemView.findViewById(R.id.ed_qty);
            btnAddItem = itemView.findViewById(R.id.btn_add_item);

        }
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public interface OnItemClickCallback {
        void onItemClicked(Product data);
    }
}
