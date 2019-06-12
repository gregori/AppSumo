package com.example.sumo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

public class IOsTap extends Fragment{

    private Button btnSharp;
    private Button btnQTR;
    private ListView lstIOS;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.ios_tab, container, false);

        btnQTR = view.findViewById(R.id.btnQTR);
        btnSharp = view.findViewById(R.id.btnSharp);
        lstIOS = view.findViewById(R.id.lstIOS);

        return view;
    }
}
