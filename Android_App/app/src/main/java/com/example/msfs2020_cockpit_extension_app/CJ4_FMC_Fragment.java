package com.example.msfs2020_cockpit_extension_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CJ4_FMC_Fragment extends Fragment {
    Button cj4_FMC_A, cj4_FMC_B, cj4_FMC_C, cj4_FMC_D, cj4_FMC_E, cj4_FMC_F, cj4_FMC_G;
    Button cj4_FMC_H, cj4_FMC_I, cj4_FMC_J, cj4_FMC_K, cj4_FMC_L, cj4_FMC_M, cj4_FMC_N;
    Button cj4_FMC_O, cj4_FMC_P, cj4_FMC_Q, cj4_FMC_R, cj4_FMC_S, cj4_FMC_T, cj4_FMC_U;
    Button cj4_FMC_V, cj4_FMC_W, cj4_FMC_X, cj4_FMC_Y, cj4_FMC_Z, cj4_FMC_space, cj4_FMC_slash;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.cj4_fmc_layout, container, false);
        FlaskCalls flask = new FlaskCalls();

        // Autopilot layout objects
        // Note "CJ4" refers to the Working Title Cessna CJ4 mod
        cj4_FMC_A = v.findViewById(R.id.btn_CJ4_FMC_A);
        cj4_FMC_B = v.findViewById(R.id.btn_CJ4_FMC_B);
        cj4_FMC_C = v.findViewById(R.id.btn_CJ4_FMC_C);
        cj4_FMC_D = v.findViewById(R.id.btn_CJ4_FMC_D);
        cj4_FMC_E = v.findViewById(R.id.btn_CJ4_FMC_E);
        cj4_FMC_F = v.findViewById(R.id.btn_CJ4_FMC_F);
        cj4_FMC_G = v.findViewById(R.id.btn_CJ4_FMC_G);
        cj4_FMC_H = v.findViewById(R.id.btn_CJ4_FMC_H);
        cj4_FMC_I = v.findViewById(R.id.btn_CJ4_FMC_I);
        cj4_FMC_J = v.findViewById(R.id.btn_CJ4_FMC_J);
        cj4_FMC_K = v.findViewById(R.id.btn_CJ4_FMC_K);
        cj4_FMC_L = v.findViewById(R.id.btn_CJ4_FMC_L);
        cj4_FMC_M = v.findViewById(R.id.btn_CJ4_FMC_M);
        cj4_FMC_N = v.findViewById(R.id.btn_CJ4_FMC_N);
        cj4_FMC_O = v.findViewById(R.id.btn_CJ4_FMC_O);
        cj4_FMC_P = v.findViewById(R.id.btn_CJ4_FMC_P);
        cj4_FMC_Q = v.findViewById(R.id.btn_CJ4_FMC_Q);
        cj4_FMC_R = v.findViewById(R.id.btn_CJ4_FMC_R);
        cj4_FMC_S = v.findViewById(R.id.btn_CJ4_FMC_S);
        cj4_FMC_T = v.findViewById(R.id.btn_CJ4_FMC_T);
        cj4_FMC_U = v.findViewById(R.id.btn_CJ4_FMC_U);
        cj4_FMC_V = v.findViewById(R.id.btn_CJ4_FMC_V);
        cj4_FMC_W = v.findViewById(R.id.btn_CJ4_FMC_W);
        cj4_FMC_X = v.findViewById(R.id.btn_CJ4_FMC_X);
        cj4_FMC_Y = v.findViewById(R.id.btn_CJ4_FMC_Y);
        cj4_FMC_Z = v.findViewById(R.id.btn_CJ4_FMC_Z);
        cj4_FMC_space = v.findViewById(R.id.btn_CJ4_FMC_space);
        cj4_FMC_slash = v.findViewById(R.id.btn_CJ4_FMC_slash);

        // Button listeners
        cj4_FMC_A.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_A/trigger", "{\"value_to_use\":\"0\"}");
            }
        });

        return v;
    }
}
