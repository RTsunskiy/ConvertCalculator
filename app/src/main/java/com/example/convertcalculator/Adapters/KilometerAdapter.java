package com.example.convertcalculator.Adapters;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.convertcalculator.R;

import java.util.List;

public class KilometerAdapter extends RecyclerView.Adapter<KilometerAdapter.KilometerHolder> {

    private int index = -1;
    private TextView itemQuontity;
    private List<String> listOfKilometerValue;

    public KilometerAdapter(List<String> listOfKilometerValue, TextView itemQuontity) {
        this.itemQuontity = itemQuontity;
        this.listOfKilometerValue = listOfKilometerValue;
    }

    @NonNull
    @Override
    public KilometerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.kilometer_item, parent, false);
        return new KilometerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final KilometerHolder holder, final int position) {
        final String item = listOfKilometerValue.get(position);
        holder.kilimeterItemName.setText(item);
        holder.kilimeterItemName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            itemQuontity.setText(listOfKilometerValue.get(position));
                index = position;
                notifyDataSetChanged();
            }
        });
        if(index==position){
            holder.kilimeterItemName.setBackgroundColor(Color.parseColor("#FF4081"));
            holder.kilimeterItemName.setTextColor(Color.parseColor("#FFFFFF"));
        }else{
            holder.kilimeterItemName.setBackgroundColor(Color.parseColor("#FFFFFF"));
            holder.kilimeterItemName.setTextColor(Color.parseColor("#000000"));
        }
    }

    @Override
    public int getItemCount() {
        return listOfKilometerValue.size();
    }





    static class KilometerHolder extends RecyclerView.ViewHolder {

        private TextView kilimeterItemName;

        public KilometerHolder(@NonNull View itemView) {
            super(itemView);
            kilimeterItemName = itemView.findViewById(R.id.kilometer_item_name);
        }
    }
}
