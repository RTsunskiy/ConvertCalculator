package com.example.convertcalculator.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.convertcalculator.Adapters.QuantitiesAdapter;
import com.example.convertcalculator.R;

import java.util.Arrays;

public class QuantitiesFragment extends Fragment {

    private RecyclerView rootView;

    public static QuantitiesFragment newInstance() {

        Bundle args = new Bundle();

        QuantitiesFragment fragment = new QuantitiesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = (RecyclerView) inflater.inflate(R.layout.fragment_quantities, container, false);

        initRecyclerView();

        return rootView;
    }

    private void initRecyclerView() {
        RecyclerView quantitiesRV = rootView.findViewById(R.id.quantities_rv);
        LinearLayoutManager manager = new LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false);
        quantitiesRV.setLayoutManager(manager);
        QuantitiesAdapter adapter = new QuantitiesAdapter(Arrays.asList(getResources().getStringArray(R.array.quantities_array)), getActivity());
        DividerItemDecoration decoration = new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL);
        quantitiesRV.addItemDecoration(decoration);
        quantitiesRV.setAdapter(adapter);
    }
}
