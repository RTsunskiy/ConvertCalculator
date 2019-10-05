package com.example.convertcalculator;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class KilometerResultAdapter extends RecyclerView.Adapter<KilometerResultAdapter.KilometerResultHolder> {

    private TextView itemQuontity;
    private List<String> list;

    public KilometerResultAdapter(List<String> list, TextView itemQuontity) {
        this.list = list;
        this.itemQuontity = itemQuontity;
    }

    @NonNull
    @Override
    public KilometerResultHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kilometer_item, parent, false);
        return new KilometerResultHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final KilometerResultHolder holder, final int position) {
        final String item = list.get(position);
        holder.kilometerResultItemName.setText(item);
        holder.kilometerResultItemName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemQuontity.setText(list.get(position));
                holder.kilometerResultItemName.setBackgroundColor(Color.parseColor("#71a832"));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class KilometerResultHolder extends RecyclerView.ViewHolder {

        private TextView kilometerResultItemName;

        public KilometerResultHolder(@NonNull View itemView) {
            super(itemView);
            kilometerResultItemName = itemView.findViewById(R.id.in_rv);
        }
    }
}
