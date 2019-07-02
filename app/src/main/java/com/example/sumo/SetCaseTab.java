package com.example.sumo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

        btnSetCase1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bluetooth.write("110");
                bluetooth.write("0");
                StrategyNumber = "1";
                EstrategiaSetada = true;
                ShowMessage();
            }
        });

        btnSetCase2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bluetooth.write("120");
                bluetooth.write("0");
                StrategyNumber = "2";
                EstrategiaSetada = true;
                ShowMessage();
            }
        });

        btnSetCase3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bluetooth.write("130");
                bluetooth.write("0");
                StrategyNumber = "3";
                EstrategiaSetada = true;
                ShowMessage();
            }
        });

        btnSetCase4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bluetooth.write("140");
                bluetooth.write("0");
                StrategyNumber = "4";
                EstrategiaSetada = true;
                ShowMessage();
            }
        });

        btnSetCase5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bluetooth.write("150");
                bluetooth.write("0");
                StrategyNumber = "5";
                EstrategiaSetada = true;
                ShowMessage();
            }
        });

        btnSetCase6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bluetooth.write("160");
                bluetooth.write("0");
                StrategyNumber = "6";
                EstrategiaSetada = true;
                ShowMessage();
            }
        });

        btnSetCase7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bluetooth.write("170");
                bluetooth.write("0");
                StrategyNumber = "7";
                EstrategiaSetada = true;
                ShowMessage();
            }
        });

        btnSetCase8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bluetooth.write("180");
                bluetooth.write("0");
                StrategyNumber = "8";
                EstrategiaSetada = true;
                ShowMessage();
            }
        });

        btnSetCase9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bluetooth.write("190");
                bluetooth.write("0");
                StrategyNumber = "9";
                EstrategiaSetada = true;
                ShowMessage();
            }
        });

        btnSetCase10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bluetooth.write("200");
                bluetooth.write("0");
                StrategyNumber = "10";
                EstrategiaSetada = true;
                ShowMessage();
            }
        });

        btnSetCase11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bluetooth.write("210");
                bluetooth.write("0");
                StrategyNumber = "11";
                EstrategiaSetada = true;
                ShowMessage();
            }
        });

        btnSetCase12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bluetooth.write("220");
                bluetooth.write("0");
                StrategyNumber = "12";
                EstrategiaSetada = true;
                ShowMessage();
            }
        });

        btnSetCase13.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bluetooth.write("230");
                bluetooth.write("0");
                StrategyNumber = "13";
                EstrategiaSetada = true;
                ShowMessage();
            }
        });

        btnSetCase14.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bluetooth.write("240");
                bluetooth.write("0");
                StrategyNumber = "14";
                EstrategiaSetada = true;
                ShowMessage();
            }
        });

        btnSetCase15.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bluetooth.write("250");
                bluetooth.write("0");
                StrategyNumber = "15";
                EstrategiaSetada = true;
                ShowMessage();
            }
        });

        btnSetCase16.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                bluetooth.write("255");
                bluetooth.write("0");
                StrategyNumber = "16";
                EstrategiaSetada = true;
                ShowMessage();
            }
        });




        return view;
    }


    private void ShowMessage(){
        if(EstrategiaSetada) {
            txvMessageControl.setText("Estratégia '"+StrategyNumber+ "' Enviada!!");
            EstrategiaSetada = false;
            Toast.makeText(this.getActivity(), "A estratégia pré-definida '" + StrategyNumber + "' foi ativada!!!", Toast.LENGTH_LONG).show();
        }
    }
}
