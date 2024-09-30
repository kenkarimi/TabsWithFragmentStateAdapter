package com.example.tabswithfragmentstateadapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

public class Upcoming extends Fragment {

    private LinearLayout lUpcomingOrders;

    public Upcoming() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_upcoming, container, false);
        lUpcomingOrders = (LinearLayout) v.findViewById(R.id.lUpcomingOrders);
        lUpcomingOrders.setVisibility(View.VISIBLE);

        return v;
    }
}
