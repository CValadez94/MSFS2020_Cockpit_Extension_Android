package com.example.msfs2020_cockpit_extension_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CJ4_AutopilotFragment extends Fragment implements View.OnClickListener {
    FlaskCalls flask = new FlaskCalls();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.cj4_autopilot_layout, container, false);

        // Layout objects
        // Note "CJ4" refers to the Working Title Cessna CJ4 mod
        Button cj4_AP_FD_PRESSED = v.findViewById(R.id.btn_CJ4_AP_FD_PRESSED);
        Button cj4_AP_VS_PRESSED = v.findViewById(R.id.btn_CJ4_AP_VS_PRESSED);
        Button cj4_AP_VNAV_PRESSED = v.findViewById(R.id.btn_CJ4_AP_VNAV_PRESSED);
        Button cj4_AP_VS_INC = v.findViewById(R.id.btn_CJ4_AP_VS_INC);
        Button cj4_AP_VS_DEC = v.findViewById(R.id.btn_CJ4_VS_DEC);
        Button cj4_AP_FLC_PRESSED = v.findViewById(R.id.btn_CJ4_AP_FLC_PRESSED);
        Button cj4_AP_SPEED_DEC = v.findViewById(R.id.btn_CJ4_SPEED_DEC);
        Button cj4_AP_SPEED_INC = v.findViewById(R.id.btn_CJ4_AP_SPEED_INC);
        Button cj4_AP_NAV_PRESSED = v.findViewById(R.id.btn_CJ4_AP_NAV_PRESSED);
        Button cj4_AP_HALFBANK_PRESSED = v.findViewById(R.id.btn_CJ4_AP_HALFBANK_PRESSED);
        Button cj4_AP_HDG_PRESSED = v.findViewById(R.id.btn_CJ4_AP_HDG_PRESSED);
        Button cj4_AP_HDG_DEC = v.findViewById(R.id.btn_CJ4_AP_HDG_DEC);
        Button cj4_AP_HDG_INC = v.findViewById(R.id.btn_CJ4_AP_HDG_INC);
        Button cj4_AP_HDG_SYNC = v.findViewById(R.id.btn_CJ4_AP_HDG_SYNC);
        Button cj4_AP_APPR_PRESSED = v.findViewById(R.id.btn_CJ4_AP_APPR_PRESSED);
        Button cj4_AP_BC_PRESSED = v.findViewById(R.id.btn_CJ4_AP_BC_PRESSED);
        Button cj4_AP_ALT_PRESSED = v.findViewById(R.id.btn_CJ4_AP_ALT_PRESSED);
        Button cj4_AP_ALT_VAR_DEC = v.findViewById(R.id.btn_CJ4_ALT_VAR_DEC);
        Button cj4_AP_ALT_VAR_INC = v.findViewById(R.id.btn_CJ4_AP_ALT_VAR_INC);
        Button cj4_AP_YD_PRESSED = v.findViewById(R.id.btn_CJ4_AP_YD_PRESSED);
        Button cj4_AP_XFR_PRESSED = v.findViewById(R.id.btn_CJ4_AP_XFR_PRESSED);
        Button cj4_AP_MASTER_ON = v.findViewById(R.id.btn_CJ4_AP_MASTER_ON);
        Button cj4_AP_MASTER_OFF = v.findViewById(R.id.btn_CJ4_AP_MASTER_OFF);

        // Button listeners
        cj4_AP_FD_PRESSED.setOnClickListener(this);
        cj4_AP_VS_PRESSED.setOnClickListener(this);
        cj4_AP_VNAV_PRESSED.setOnClickListener(this);
        cj4_AP_VS_INC.setOnClickListener(this);
        cj4_AP_VS_DEC.setOnClickListener(this);
        cj4_AP_FLC_PRESSED.setOnClickListener(this);
        cj4_AP_SPEED_DEC.setOnClickListener(this);
        cj4_AP_SPEED_INC.setOnClickListener(this);
        cj4_AP_NAV_PRESSED.setOnClickListener(this);
        cj4_AP_HALFBANK_PRESSED.setOnClickListener(this);
        cj4_AP_HDG_PRESSED.setOnClickListener(this);
        cj4_AP_HDG_DEC.setOnClickListener(this);
        cj4_AP_HDG_INC.setOnClickListener(this);
        cj4_AP_HDG_SYNC.setOnClickListener(this);
        cj4_AP_APPR_PRESSED.setOnClickListener(this);
        cj4_AP_BC_PRESSED.setOnClickListener(this);
        cj4_AP_ALT_PRESSED.setOnClickListener(this);
        cj4_AP_ALT_VAR_DEC.setOnClickListener(this);
        cj4_AP_ALT_VAR_INC.setOnClickListener(this);
        cj4_AP_YD_PRESSED.setOnClickListener(this);
        cj4_AP_XFR_PRESSED.setOnClickListener(this);
        cj4_AP_MASTER_ON.setOnClickListener(this);
        cj4_AP_MASTER_OFF.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();              // Can't use switch case anymore since R.ids are not final anymore
        if (id == R.id.btn_CJ4_AP_FD_PRESSED) {
            flask.postToFlaskServer("/wt_cj4_event/WT_CJ4_AP_FD_PRESSED/trigger", null);
        } else if (id == R.id.btn_CJ4_AP_VS_PRESSED) {
            flask.postToFlaskServer("/wt_cj4_event/WT_CJ4_AP_VS_PRESSED/trigger", null);
        } else if (id == R.id.btn_CJ4_AP_VNAV_PRESSED) {
            flask.postToFlaskServer("/wt_cj4_event/WT_CJ4_AP_VNAV_PRESSED/trigger", null);
        } else if (id == R.id.btn_CJ4_AP_VS_INC) {
            flask.postToFlaskServer("/wt_cj4_event/WT_CJ4_AP_VS_INC/trigger", null);
        } else if (id == R.id.btn_CJ4_VS_DEC) {
            flask.postToFlaskServer("/wt_cj4_event/WT_CJ4_AP_VS_DEC/trigger", null);
        } else if (id == R.id.btn_CJ4_AP_FLC_PRESSED) {
            flask.postToFlaskServer("/wt_cj4_event/WT_CJ4_AP_FLC_PRESSED/trigger", null);
        } else if (id == R.id.btn_CJ4_SPEED_DEC) {
            flask.postToFlaskServer("/wt_cj4_event/WT_CJ4_AP_SPEED_DEC/trigger", null);
        } else if (id == R.id.btn_CJ4_AP_SPEED_INC) {
            flask.postToFlaskServer("/wt_cj4_event/WT_CJ4_AP_SPEED_INC/trigger", null);
        } else if (id == R.id.btn_CJ4_AP_NAV_PRESSED) {
            flask.postToFlaskServer("/wt_cj4_event/WT_CJ4_AP_NAV_PRESSED/trigger", null);
        } else if (id == R.id.btn_CJ4_AP_HALFBANK_PRESSED) {
            flask.postToFlaskServer("/wt_cj4_event/WT_CJ4_AP_HALFBANK_PRESSED/trigger", null);
        } else if (id == R.id.btn_CJ4_AP_HDG_PRESSED) {
            flask.postToFlaskServer("/wt_cj4_event/WT_CJ4_AP_HDG_PRESSED/trigger", null);
        } else if (id == R.id.btn_CJ4_AP_HDG_DEC) {
            flask.postToFlaskServer("/wt_cj4_event/WT_CJ4_AP_HDG_DEC/trigger", null);
        } else if (id == R.id.btn_CJ4_AP_HDG_INC) {
            flask.postToFlaskServer("/wt_cj4_event/WT_CJ4_AP_HDG_INC/trigger", null);
        } else if (id == R.id.btn_CJ4_AP_HDG_SYNC) {
            flask.postToFlaskServer("/wt_cj4_event/WT_CJ4_AP_HDG_SYNC/trigger", null);
        } else if (id == R.id.btn_CJ4_AP_APPR_PRESSED) {
            flask.postToFlaskServer("/wt_cj4_event/WT_CJ4_AP_APPR_PRESSED/trigger", null);
        } else if (id == R.id.btn_CJ4_AP_BC_PRESSED) {
            flask.postToFlaskServer("/wt_cj4_event/WT_CJ4_AP_BC_PRESSED/trigger", null);
        } else if (id == R.id.btn_CJ4_AP_ALT_PRESSED) {
            flask.postToFlaskServer("/wt_cj4_event/WT_CJ4_AP_ALT_PRESSED/trigger", null);
        } else if (id == R.id.btn_CJ4_ALT_VAR_DEC) {
            flask.postToFlaskServer("/wt_cj4_event/WT_CJ4_AP_ALT_VAR_DEC/trigger", null);
        } else if (id == R.id.btn_CJ4_AP_ALT_VAR_INC) {
            flask.postToFlaskServer("/wt_cj4_event/WT_CJ4_AP_ALT_VAR_INC/trigger", null);
        } else if (id == R.id.btn_CJ4_AP_YD_PRESSED) {
            flask.postToFlaskServer("/wt_cj4_event/WT_CJ4_AP_YD_PRESSED/trigger", null);
        } else if (id == R.id.btn_CJ4_AP_XFR_PRESSED) {
            flask.postToFlaskServer("/wt_cj4_event/WT_CJ4_AP_XFR_PRESSED/trigger", null);
        } else if (id == R.id.btn_CJ4_AP_MASTER_ON) {
            flask.postToFlaskServer("/wt_cj4_event/WT_CJ4_AP_MASTER_ON/trigger", null);
        } else if (id == R.id.btn_CJ4_AP_MASTER_OFF) {
            flask.postToFlaskServer("/wt_cj4_event/WT_CJ4_AP_MASTER_OFF/trigger", null);
        }
    }
}
