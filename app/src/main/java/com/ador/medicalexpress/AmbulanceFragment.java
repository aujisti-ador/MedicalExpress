package com.ador.medicalexpress;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class AmbulanceFragment extends Fragment {


    public AmbulanceFragment() {
        // Required empty public constructor
    }

    @Override
    public void onResume() {
        super.onResume();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Ambulance Finder");
        return inflater.inflate(R.layout.fragment_ambulance, container, false);
    }

}
