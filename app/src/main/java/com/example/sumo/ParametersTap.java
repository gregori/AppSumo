package com.example.sumo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ParametersTap extends Fragment {

    private Button btnUp;
    private Button btnDown;
    private Button btnLeft;
    private Button btnRight;
    private Button btnAtaque;
    private Button btnSearch;
    private Button btnRecover;

    private EditText edtAtaque;
    private EditText edtRecover;
    private EditText edtSearch;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.parameters_tab, container, false);

        btnUp = view.findViewById(R.id.btnUp);
        btnDown = view.findViewById(R.id.btnDown);
        btnLeft = view.findViewById(R.id.btnLeft);
        btnRight = view.findViewById(R.id.btnRight);

        btnAtaque = view.findViewById(R.id.btnAtaque);
        btnRecover = view.findViewById(R.id.btnRecover);
        btnSearch = view.findViewById(R.id.btnSearch);

        edtAtaque = view.findViewById(R.id.edtAtaque);
        edtRecover = view.findViewById(R.id.edtRecover);
        edtSearch = view.findViewById(R.id.edtSearch);

        OnclickEvents();
        return view;
    }


    private void OnclickEvents() {
        btnAtaque.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonConfig(edtAtaque.getText().toString(), "Ataque");
            }
        });

        btnRecover.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonConfig(edtRecover.getText().toString(), "Recover");
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                buttonConfig(edtSearch.getText().toString(), "Search");
            }
        });
    }

    private void buttonConfig(String edtFiledValue, String field) {
        if (!edtFiledValue.equals("")) {
            /////
        } else
            Toast.makeText(this.getActivity(), "O campo '" + field + "' não pode ser nulo!", Toast.LENGTH_LONG).show();

    }
}

