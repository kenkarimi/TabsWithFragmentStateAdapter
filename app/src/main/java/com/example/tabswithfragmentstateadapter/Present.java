package com.example.tabswithfragmentstateadapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

public class Present extends Fragment {

    private LinearLayout lPresentOrders;

    public Present() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_present, container, false);
        lPresentOrders = (LinearLayout) v.findViewById(R.id.lPresentOrders);
        lPresentOrders.setVisibility(View.VISIBLE);

        return v;
    }
}
