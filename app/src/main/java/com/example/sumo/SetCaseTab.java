package com.example.sumo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class SetCaseTab extends Fragment implements View.OnClickListener {

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
    private Bluetooth bluetooth = new Bluetooth();
    private String StrategyNumber = "";
    private Boolean EstrategiaSetada = false;

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

        btnSetCase1.setOnClickListener(this);
        btnSetCase2.setOnClickListener(this);
        btnSetCase3.setOnClickListener(this);
        btnSetCase4.setOnClickListener(this);
        btnSetCase5.setOnClickListener(this);
        btnSetCase6.setOnClickListener(this);
        btnSetCase7.setOnClickListener(this);
        btnSetCase8.setOnClickListener(this);
        btnSetCase9.setOnClickListener(this);
        btnSetCase10.setOnClickListener(this);
        btnSetCase11.setOnClickListener(this);
        btnSetCase12.setOnClickListener(this);
        btnSetCase13.setOnClickListener(this);
        btnSetCase14.setOnClickListener(this);
        btnSetCase15.setOnClickListener(this);
        btnSetCase16.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        int strategy = 0;
        byte[] strategyData;

        if (v == this.btnSetCase1) {
            strategy = 1;
        } else if (v == this.btnSetCase2) {
            strategy = 2;
        } else if (v == this.btnSetCase3) {
            strategy = 3;
        } else if (v == this.btnSetCase4) {
            strategy = 4;
        } else if (v == this.btnSetCase5) {
            strategy = 5;
        } else if (v == this.btnSetCase6) {
            strategy = 6;
        } else if (v == this.btnSetCase7) {
            strategy = 7;
        } else if (v == this.btnSetCase8) {
            strategy = 8;
        } else if (v == this.btnSetCase9) {
            strategy = 9;
        } else if (v == this.btnSetCase10) {
            strategy = 10;
        } else if (v == this.btnSetCase11) {
            strategy = 11;
        } else if (v == this.btnSetCase12) {
            strategy = 12;
        } else if (v == this.btnSetCase13) {
            strategy = 13;
        } else if (v == this.btnSetCase14) {
            strategy = 14;
        } else if (v == this.btnSetCase15) {
            strategy = 15;
        } else if (v == this.btnSetCase16) {
            strategy = 16;
        }


        strategyData = Protocol.intToByte(strategy);
        Log.i("Strategy tab", "Value: " + strategyData[0] + " - " + strategyData[1]);
        byte[] data = new byte[] { Protocol.SET_STRATEGY, strategyData[0], strategyData[1] };
        bluetooth.write(data);
    }


    private void ShowMessage(){
        if(EstrategiaSetada) {
            txvMessageControl.setText("Estratégia '"+StrategyNumber+ "' Enviada!!");
            EstrategiaSetada = false;
            Toast.makeText(this.getActivity(), "A estratégia pré-definida '" + StrategyNumber + "' foi ativada!!!", Toast.LENGTH_LONG).show();
        }
    }
}
