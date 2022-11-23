package com.example.msfs2020_cockpit_extension_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AutopilotFragment extends Fragment {
    Button autopilotToggle, headingModeToggle, altitudeHoldModeToggle, navModeToggle, approachModeToggle;
    Button wt_CJ4_FMC_0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.autopilot_layout, container, false);
        FlaskCalls flask = FlaskCalls.getInstance();

        // Autopilot layout objects
        // Note "wt_CJ4" refers to the Working Title Cessna CJ4 mod
        autopilotToggle = v.findViewById(R.id.btnAutoPilot);
        headingModeToggle = v.findViewById(R.id.btnAltitudeHoldMode);
        altitudeHoldModeToggle = v.findViewById(R.id.btnAltitudeHoldMode);
        navModeToggle = v.findViewById(R.id.btnNavMode);
        approachModeToggle = v.findViewById(R.id.btnApproachMode);
        wt_CJ4_FMC_0 = v.findViewById(R.id.btnWT_CJ4_FMC_0);

        // Button listeners
        autopilotToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flask.postToFlaskServer("/event/AP_MASTER/trigger", "{\"value_to_use\":\"1\"}");
            }
        });
        headingModeToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flask.postToFlaskServer("/event/AP_HDG_HOLD/trigger", "{\"value_to_use\":\"1\"}");
            }
        });
        altitudeHoldModeToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flask.postToFlaskServer("/event/AP_ALT_HOLD/trigger", "{\"value_to_use\":\"1\"}");
            }
        });
        navModeToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flask.postToFlaskServer("/event/AP_NAV1_HOLD/trigger", "{\"value_to_use\":\"1\"}");
            }
        });
        approachModeToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flask.postToFlaskServer("/event/AP_APR_HOLD/trigger", "{\"value_to_use\":\"1\"}");
            }
        });
        wt_CJ4_FMC_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_0/trigger", "{\"value_to_use\":\"0\"}");
            }
        });

        return v;
    }
}
