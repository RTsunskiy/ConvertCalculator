package com.example.convertcalculator.Adapters;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.convertcalculator.Fragments.ConversationFragment;
import com.example.convertcalculator.R;

import java.util.List;

public class QuantitiesAdapter extends RecyclerView.Adapter<QuantitiesAdapter.QuantitiesHolder> {

    private List<String> listOfQuantities;
    private FragmentActivity context;

    public QuantitiesAdapter(List<String> listOfQuantities, FragmentActivity context) {
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
                    context.getSupportFragmentManager()
                            .beginTransaction()
                            .addToBackStack(null)
                            .replace(R.id.root_linear, ConversationFragment.newInstance(item))
                            .commit();
                }
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

