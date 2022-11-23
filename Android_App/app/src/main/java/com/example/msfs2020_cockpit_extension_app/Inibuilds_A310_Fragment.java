package com.example.msfs2020_cockpit_extension_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Inibuilds_A310_Fragment extends Fragment implements View.OnClickListener {
    FlaskCalls flask = FlaskCalls.getInstance();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.a310_layout, container, false);

        Button a310_TOG_EXT_PWR = v.findViewById(R.id.btn_A310_TOG_EXT_PWR);

        // Button listeners
        a310_TOG_EXT_PWR.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();              // Can't use switch case anymore since R.ids are not final anymore
        if (id == R.id.btn_A310_TOG_EXT_PWR) {
            flask.postToFlaskServer("/wt_cj4_event/A310_Ovhd_Elec_Ext_Pwr_Toggle/trigger", null);
        }
    }
}
