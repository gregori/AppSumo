package com.example.sumo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
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
    private Button btnKP;
    private Button btnKD;
    private Button btnKI;

    private EditText edtAtaque;
    private EditText edtRecover;
    private EditText edtSearch;
    private EditText edtKD;
    private EditText edtKP;
    private EditText edtKI;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.parameters_tab, container, false);

        ConnectionTab connTab = new ConnectionTab();

        btnUp = view.findViewById(R.id.btnUp);
        btnDown = view.findViewById(R.id.btnDown);
        btnLeft = view.findViewById(R.id.btnLeft);
        btnRight = view.findViewById(R.id.btnRight);
        btnAtaque = view.findViewById(R.id.btnAtaque);
        btnRecover = view.findViewById(R.id.btnRecover);
        btnSearch = view.findViewById(R.id.btnSearch);
        btnKP = view.findViewById(R.id.btnKP);
        btnKD = view.findViewById(R.id.btnKD);
        btnKI = view.findViewById(R.id.btnKI);

        edtAtaque = view.findViewById(R.id.edtAtaque);
        edtRecover = view.findViewById(R.id.edtRecover);
        edtSearch = view.findViewById(R.id.edtSearch);
        edtKD = view.findViewById(R.id.edtKD);
        edtKP = view.findViewById(R.id.edtKP);
        edtKI = view.findViewById(R.id.edtKI);

        btnLeft.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        //btnLeft.setImageAlpha(100);
                        ToothReadWrite.WriteBuffer((byte)4);
                        break;

                    case MotionEvent.ACTION_UP:
                        //bntLeft.setImageAlpha(255);
                        Log.v("MANDA:", "0");
                        ToothReadWrite.WriteBuffer((byte)0);
                        break;
                }
                return false;
            }
        });
        btnDown.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        //bntRight.setImageAlpha(100);
                        ToothReadWrite.WriteBuffer((byte)8);
                        break;

                    case MotionEvent.ACTION_UP:
                        //bntRight.setImageAlpha(255);
                        ToothReadWrite.WriteBuffer((byte)0);
                        break;
                }
                return false;
            }
        });
        btnUp.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        //bntUp.setImageAlpha(100);
                        ToothReadWrite.WriteBuffer((byte)1);
                        break;

                    case MotionEvent.ACTION_UP:
                        //bntUp.setImageAlpha(255);
                        ToothReadWrite.WriteBuffer((byte)0);
                        break;
                }
                return false;
            }
        });
        btnDown.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        //bntDown.setImageAlpha(100);
                        ToothReadWrite.WriteBuffer((byte)2);
                        break;

                    case MotionEvent.ACTION_UP:
                        //bntDown.setImageAlpha(255);
                        ToothReadWrite.WriteBuffer((byte)0);
                        break;
                }
                return false;
            }
        });

        OnclickEvents();
        return view;
    }


    private void OnclickEvents() {
        btnAtaque.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ButtonNullValidation(edtAtaque.getText().toString(), "Ataque");
            }
        });

        btnRecover.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ButtonNullValidation(edtRecover.getText().toString(), "Recover");
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ButtonNullValidation(edtSearch.getText().toString(), "Search");
            }
        });

        btnKD.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ButtonNullValidation(edtKD.getText().toString(), "KD");
            }
        });

        btnKP.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ButtonNullValidation(edtKP.getText().toString(), "KP");
            }
        });

        btnKI.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                ButtonNullValidation(edtKI.getText().toString(), "KI");
            }
        });
    }

    private void ButtonNullValidation(String edtFiledValue, String field) {
        if (!edtFiledValue.equals("")) {
            switch (field){
                case "Ataque":
                    //FuntionsAtaque();
                case "Recover":
                    //FunctionsRecover();
                case "Search":
                    //FunctionsSearch();
                case "KD":
                    //FunctionsKD();
                case "KP":
                    //FunctionsKP();
                case "KI":
                    //FunctionsKI();
            }
        } else
            Toast.makeText(this.getActivity(), "O campo '" + field + "' não pode ser nulo!", Toast.LENGTH_LONG).show();
    }


}


