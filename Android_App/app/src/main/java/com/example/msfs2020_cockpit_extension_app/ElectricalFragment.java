package com.example.msfs2020_cockpit_extension_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.snackbar.Snackbar;

public class ElectricalFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.electrical_layout, container, false);
        FlaskCalls flask = FlaskCalls.getInstance();

        // Set the button listeners
        ToggleButton masterAlternator = v.findViewById(R.id.btnMasterAlternator);
        ToggleButton masterBattery = v.findViewById(R.id.btnMasterBattery);
        ToggleButton standbyBattery = v.findViewById(R.id.btnStandbyBattery);
        ToggleButton avionicsBus1 = v.findViewById(R.id.btnAvionicsBus1);
        ToggleButton avionicsBus2 = v.findViewById(R.id.btnAvionicsBus2);
        ToggleButton beaconLights = v.findViewById(R.id.btnBeaconLights);
        ToggleButton landingLights = v.findViewById(R.id.btnLandingLights);
        ToggleButton taxiLights = v.findViewById(R.id.btnTaxiLights);
        ToggleButton navLights = v.findViewById(R.id.btnNavLights);
        ToggleButton strobeLights = v.findViewById(R.id.btnStrobeLights);

        masterAlternator.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    flask.postToFlaskServer("/event/ALTERNATOR_SET/trigger", "{\"value_to_use\":\"1\"}");
                } else {
                    flask.postToFlaskServer("/event/ALTERNATOR_SET/trigger", "{\"value_to_use\":\"0\"}");
                }
            }
        });
        masterBattery.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    flask.postToFlaskServer("/event/BATTERY1_SET/trigger", "{\"value_to_use\":\"1\"}");
                } else {
                    flask.postToFlaskServer("/event/BATTERY1_SET/trigger", "{\"value_to_use\":\"0\"}");
                }
            }
        });
        standbyBattery.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    flask.postToFlaskServer("/event/BATTERY2_SET/trigger", "{\"value_to_use\":\"1\"}");
                } else {
                    flask.postToFlaskServer("/event/BATTERY2_SET/trigger", "{\"value_to_use\":\"0\"}");
                }
            }
        });
        avionicsBus1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    flask.postToFlaskServer("/event/AVIONICS_MASTER_1_SET/trigger", "{\"value_to_use\":\"1\"}");
                } else {
                    flask.postToFlaskServer("/event/AVIONICS_MASTER_1_SET/trigger", "{\"value_to_use\":\"0\"}");
                }
            }
        });
        avionicsBus2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    flask.postToFlaskServer("/event/AVIONICS_MASTER_2_SET/trigger", "{\"value_to_use\":\"1\"}");
                } else {
                    flask.postToFlaskServer("/event/AVIONICS_MASTER_2_SET/trigger", "{\"value_to_use\":\"0\"}");
                }
            }
        });

        beaconLights.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    flask.postToFlaskServer("/event/BEACON_LIGHTS_SET/trigger", "{\"value_to_use\":\"1\"}");
                } else {
                    flask.postToFlaskServer("/event/BEACON_LIGHTS_SET/trigger", "{\"value_to_use\":\"0\"}");
                }
            }
        });
        landingLights.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    flask.postToFlaskServer("/event/LANDING_LIGHTS_SET/trigger", "{\"value_to_use\":\"1\"}");
                } else {
                    flask.postToFlaskServer("/event/LANDING_LIGHTS_SET/trigger", "{\"value_to_use\":\"0\"}");
                }
            }
        });
        taxiLights.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    flask.postToFlaskServer("/event/TAXI_LIGHTS_SET/trigger", "{\"value_to_use\":\"1\"}");
                } else {
                    flask.postToFlaskServer("/event/TAXI_LIGHTS_SET/trigger", "{\"value_to_use\":\"0\"}");
                }
            }
        });
        navLights.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    flask.postToFlaskServer("/event/NAV_LIGHTS_SET/trigger", "{\"value_to_use\":\"1\"}");
                } else {
                    flask.postToFlaskServer("/event/NAV_LIGHTS_SET/trigger", "{\"value_to_use\":\"0\"}");
                }
            }
        });
        strobeLights.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    flask.postToFlaskServer("/event/STROBES_SET/trigger", "{\"value_to_use\":\"1\"}");
                } else {
                    flask.postToFlaskServer("/event/STROBES_SET/trigger", "{\"value_to_use\":\"0\"}");
                }
            }
        });

        return v;
    }
}
