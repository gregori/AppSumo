package com.example.sumo;

import android.annotation.SuppressLint;
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
    private Button startStop;

    private EditText edtAtaque;
    private EditText edtRecover;
    private EditText edtSearch;
    private EditText edtKD;
    private EditText edtKP;
    private EditText edtKI;

    private int isRunnig = 0;

    public Bluetooth bluetooth = new Bluetooth();

    @SuppressLint("ClickableViewAccessibility")
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
        btnKP = view.findViewById(R.id.btnKP);
        btnKD = view.findViewById(R.id.btnKD);
        btnKI = view.findViewById(R.id.btnKI);

        btnRight.setText("<");

        edtAtaque = view.findViewById(R.id.edtAtaque);
        edtRecover = view.findViewById(R.id.edtRecover);
        edtSearch = view.findViewById(R.id.edtSearch);
        edtKD = view.findViewById(R.id.edtKD);
        edtKP = view.findViewById(R.id.edtKP);
        edtKI = view.findViewById(R.id.edtKI);

        startStop = view.findViewById(R.id.start_stop);
        startStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isRunnig == 1) {
                    isRunnig = 0;
                    startStop.setText("Start");
                } else {
                    isRunnig = 1;
                    startStop.setText("Stop");
                }

                byte[] value = Protocol.intToByte(isRunnig);
                byte[] data = new byte[] { Protocol.START_STOP_ROBOT, value[0], value[1] };
                bluetooth.write(data);
            }
        });

        btnLeft.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        controlMotor(40, -40);
                        break;

                    case MotionEvent.ACTION_UP:
                        Log.v("MANDA:", "0");
                        controlMotor(0, 0);
                        break;
                }
                return false;
            }
        });

        btnRight.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        controlMotor(-40, 40);
                        break;

                    case MotionEvent.ACTION_UP:
                        Log.v("MANDA:", "0");
                        controlMotor(0, 0);
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
                        controlMotor(40, 40);
                        break;

                    case MotionEvent.ACTION_UP:
                        controlMotor(0, 0);
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
                        controlMotor(-40, -40);
                        break;

                    case MotionEvent.ACTION_UP:
                        controlMotor(0, 0);
                        break;
                }
                return false;
            }
        });

        OnclickEvents();
        return view;
    }

    public void controlMotor(int left, int right) {
        byte[] leftBuff = Protocol.intToByte(left);
        byte[] rightBuff = Protocol.intToByte(right);
        byte[] data = new byte[] { Protocol.MOTOR_CONTROL, leftBuff[0], leftBuff[1], rightBuff[0], rightBuff[1] };
        try {
            bluetooth.write(data);
        } catch (Exception e) {
            Toast.makeText(this.getContext(), "Erro ao mover motores", Toast.LENGTH_LONG);
        }
    }


    private void OnclickEvents() {
        btnAtaque.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                NullButtonValidation(edtAtaque.getText().toString(), "Ataque");
            }
        });

        btnRecover.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                NullButtonValidation(edtRecover.getText().toString(), "Recover");
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                NullButtonValidation(edtSearch.getText().toString(), "Search");
            }
        });

        btnKD.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                NullButtonValidation(edtKD.getText().toString(), "KD");
            }
        });

        btnKP.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                NullButtonValidation(edtKP.getText().toString(), "KP");
            }
        });

        btnKI.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                NullButtonValidation(edtKI.getText().toString(), "KI");
            }
        });
    }

    private void NullButtonValidation(String edtFiledValue, String field) {
        if (!edtFiledValue.equals("")) {
            SendBluetoothParamenters(field);
        } else
            Toast.makeText(this.getActivity(), "O campo '" + field + "' não pode ser nulo!", Toast.LENGTH_LONG).show();
    }

    private void SendBluetoothParamenters(String field){
        Boolean ValorIncorreto = false;
        byte[] value;
        try {
            if (field.equals("Ataque")) {
                if (Integer.valueOf(edtAtaque.getText().toString()) >= 0 && Integer.valueOf(edtAtaque.getText().toString()) <= 255) {
                    value = Protocol.intToByte(Integer.valueOf(edtAtaque.getText().toString()));
                    byte[] data = new byte[] { Protocol.SET_ATTAK, value[0], value[1] };
                    bluetooth.write(data);
                } else {
                    ValorIncorreto = true;
                    Toast.makeText(this.getActivity(), "O valor de 'Ataque' deve estar entre 0 e 255", Toast.LENGTH_LONG).show();
                }
            } else if (field.equals("Recover")) {
                if (Integer.valueOf(edtRecover.getText().toString()) >= 0 && Integer.valueOf(edtRecover.getText().toString()) <= 255) {
                    value = Protocol.intToByte(Integer.valueOf(edtRecover.getText().toString()));
                    byte[] data = new byte[] { Protocol.SET_RECOVER, value[0], value[1] };
                    bluetooth.write(data);
                } else {
                    ValorIncorreto = true;
                    Toast.makeText(this.getActivity(), "O valor de 'Recover' deve estar entre 0 e 255", Toast.LENGTH_LONG).show();
                }
            } else if (field.equals("Search")) {
                if (Integer.valueOf(edtSearch.getText().toString()) >= 0 && Integer.valueOf(edtSearch.getText().toString()) <= 255) {
                    value = Protocol.intToByte(Integer.valueOf(edtSearch.getText().toString()));
                    byte[] data = new byte[] { Protocol.SET_SEARCH, value[0], value[1] };
                    bluetooth.write(data);
                } else {
                    ValorIncorreto = true;
                    Toast.makeText(this.getActivity(), "O valor de 'Search' deve estar entre 0 e 255", Toast.LENGTH_LONG).show();
                }
            } else if (field.equals("KD")) {
                if (Integer.valueOf(edtKD.getText().toString()) >= 0) {
                    value = Protocol.intToByte(Integer.valueOf(edtKD.getText().toString()));
                    byte[] data = new byte[] { Protocol.SET_DELAY, value[0], value[1] };
//                    edtKD.setText("");
                    bluetooth.write(data);
                } else {
                    ValorIncorreto = true;
                    Toast.makeText(this.getActivity(), "O valor de 'KD' deve estar entre 0 e 255", Toast.LENGTH_LONG).show();
                }
            } else if (field.equals("KP")) {
                if (Integer.valueOf(edtKP.getText().toString()) >= 0 && Integer.valueOf(edtKP.getText().toString()) <= 255) {
//                    value = edtKP.getText().toString();
                    bluetooth.write(edtKP.getText().toString());
                    bluetooth.write("0");
                    edtKP.setText("");
                } else {
                    ValorIncorreto = true;
                    Toast.makeText(this.getActivity(), "O valor de 'KP' deve estar entre 0 e 255", Toast.LENGTH_LONG).show();
                }
            } else if (field.equals("KI")) {
                if (Integer.valueOf(edtKI.getText().toString()) >= 0 && Integer.valueOf(edtKI.getText().toString()) <= 255) {
//                    value = edtKI.getText().toString();
                    bluetooth.write(edtKI.getText().toString());
                    edtKI.setText("");
                    bluetooth.write("0");
                } else {
                    ValorIncorreto = true;
                    Toast.makeText(this.getActivity(), "O valor de 'KI' deve estar entre 0 e 255", Toast.LENGTH_LONG).show();
                }
            }

            if (!ValorIncorreto) {
                if (Bluetooth.Erro)
                    Toast.makeText(this.getActivity(), "Erro: Não foi possível enviar os valores!", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(this.getActivity(), "O valor de " + field + " foi enviado com sucesso!", Toast.LENGTH_LONG).show();
            }
        }
        catch (Exception e){
            Toast.makeText(this.getActivity(), "Caracter Inválido", Toast.LENGTH_LONG).show();
        }
    }
}


