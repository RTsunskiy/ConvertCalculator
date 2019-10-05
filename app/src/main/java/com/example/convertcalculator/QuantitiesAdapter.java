package com.example.convertcalculator;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class QuantitiesAdapter extends RecyclerView.Adapter<QuantitiesAdapter.QuantitiesHolder> {

    private List<String> listOfQuantities;
    private Context context;

    public QuantitiesAdapter(List<String> listOfQuantities, Context context) {
        this.listOfQuantities = listOfQuantities;
        this.context = context;
    }



    @NonNull
    @Override
    public QuantitiesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quantity_item, parent, false);
        return new QuantitiesHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final QuantitiesHolder holder, int position) {
        final String item = listOfQuantities.get(position);
        holder.quantityItem.setText(item);
        holder.quantityItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (item.equals("Расстояние")) {
                Intent intent = new Intent(context, ConversationActivity.class);
                intent.putExtra("Distance", item);
                context.startActivity(intent);}
            }
        });
    }

    @Override
    public int getItemCount() {
        return listOfQuantities.size();
    }

    static class QuantitiesHolder extends RecyclerView.ViewHolder {

        private final TextView quantityItem;


        public TextView getQuantityItem() {
            return quantityItem;
        }


        public QuantitiesHolder(@NonNull View itemView) {
            super(itemView);
            quantityItem = itemView.findViewById(R.id.quantities_name);
        }
    }

    }

