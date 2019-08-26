package com.example.sumo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.Toast;

public class SetCaseTab extends Fragment implements View.OnClickListener {

    private Bluetooth bluetooth = new Bluetooth();
    private TableLayout buttonSpace;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.setcase_tab, container, false);
        buttonSpace = view.findViewById(R.id.button_space);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(32, 8, 8, 32);


        for (int i=0; i < 10; i++) {
            Button a = new Button(view.getContext());
            a.setText("Set case " + (i + 1));
            a.setBackground(ContextCompat.getDrawable(view.getContext(), R.drawable.button_principal));
            buttonSpace.addView(a, layoutParams);
            a.setLayoutParams(layoutParams);
            a.setTextColor(Color.parseColor("#DDDDDD"));

            final int finalI = i;
            a.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int strategy = finalI + 1;
                    byte[] strategyData;

                    try {
                        strategyData = Protocol.intToByte(strategy);
                        Log.i("Strategy tab", "Value: " + strategyData[0] + " - " + strategyData[1]);
                        byte[] data = new byte[]{Protocol.SET_STRATEGY, strategyData[0], strategyData[1]};
                        bluetooth.write(data);
                        Toast.makeText(getActivity(), "A estratégia pré-definida '" + strategy + "' foi ativada!!!", Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        Toast.makeText(getActivity(), "Erro ao setar estratégia. Error: " + e.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
            });
        }

        return view;
    }

    @Override
    public void onClick(View v) {


    }
}
