package com.example.sumo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class IOsTap extends Fragment{

    private Button btnSharp;
    private Button btnQTR;
    private ListView lstIOS;
    private Bluetooth bluetooth = new Bluetooth();
    private ArrayAdapter<String> mSensoresArrayAdapter;
    private String SensoresResult = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.ios_tab, container, false);

        btnQTR = view.findViewById(R.id.btnQTR);
        btnSharp = view.findViewById(R.id.btnSharp);
        lstIOS = view.findViewById(R.id.lstIOS);

        mSensoresArrayAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1);

        lstIOS = view.findViewById(R.id.lstIOS);

        btnQTR.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SensoresResult = bluetooth.receiveData("Cor");
                mSensoresArrayAdapter.add(SensoresResult);
                lstIOS.setAdapter(mSensoresArrayAdapter);
            }
        });

        btnSharp.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                SensoresResult = bluetooth.receiveData("Distância");
                mSensoresArrayAdapter.add(SensoresResult);
                lstIOS.setAdapter(mSensoresArrayAdapter);
            }
        });

        return view;
    }
}
