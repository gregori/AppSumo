package com.example.sumo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class SetCaseTab extends Fragment {

    private Button btnSetCase1;
    private Button btnSetCase2;
    private Button btnSetCase3;
    private Button btnSetCase4;
    private Button btnSetCase5;
    private Button btnSetCase6;
    private Button btnSetCase7;
    private Button btnSetCase8;
    private Button btnSetCase9;
    private Button btnSetCase10;
    private Button btnSetCase11;
    private Button btnSetCase12;
    private Button btnSetCase13;
    private Button btnSetCase14;
    private Button btnSetCase15;
    private Button btnSetCase16;

    private TextView txvMessageControl;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.setcase_tab, container, false);

        btnSetCase1 = view.findViewById(R.id.btnSetCase1);
        btnSetCase2 = view.findViewById(R.id.btnSetCase2);
        btnSetCase3 = view.findViewById(R.id.btnSetCase3);
        btnSetCase4 = view.findViewById(R.id.btnSetCase4);
        btnSetCase5 = view.findViewById(R.id.btnSetCase5);
        btnSetCase6 = view.findViewById(R.id.btnSetCase6);
        btnSetCase7 = view.findViewById(R.id.btnSetCase7);
        btnSetCase8 = view.findViewById(R.id.btnSetCase8);
        btnSetCase9 = view.findViewById(R.id.btnSetCase9);
        btnSetCase10 = view.findViewById(R.id.btnSetCase10);
        btnSetCase11 = view.findViewById(R.id.btnSetCase11);
        btnSetCase12 = view.findViewById(R.id.btnSetCase12);
        btnSetCase13 = view.findViewById(R.id.btnSetCase13);
        btnSetCase14 = view.findViewById(R.id.btnSetCase14);
        btnSetCase15 = view.findViewById(R.id.btnSetCase15);
        btnSetCase16 = view.findViewById(R.id.btnSetCase16);

        txvMessageControl = view.findViewById(R.id.txvMessageControl);

        return view;
    }
}
