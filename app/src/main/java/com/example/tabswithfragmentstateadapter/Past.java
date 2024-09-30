package com.example.tabswithfragmentstateadapter;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class Past extends Fragment {

    private LinearLayout lPastOrders;

    public Past() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_past, container, false);
        lPastOrders = (LinearLayout) v.findViewById(R.id.lPastOrders);
        lPastOrders.setVisibility(View.VISIBLE);

        return v;
    }
}
