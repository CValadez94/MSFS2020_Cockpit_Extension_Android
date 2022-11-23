package com.example.msfs2020_cockpit_extension_app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CJ4_FMC_Fragment extends Fragment implements View.OnClickListener, View.OnLongClickListener {
    FlaskCalls flask = new FlaskCalls();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.cj4_fmc_layout, container, false);

        // Layout objects
        // Note "CJ4" refers to the Working Title Cessna CJ4 mod
        Button cj4_FMC_A = v.findViewById(R.id.btn_CJ4_FMC_A);
        Button cj4_FMC_B = v.findViewById(R.id.btn_CJ4_FMC_B);
        Button cj4_FMC_C = v.findViewById(R.id.btn_CJ4_FMC_C);
        Button cj4_FMC_D = v.findViewById(R.id.btn_CJ4_FMC_D);
        Button cj4_FMC_E = v.findViewById(R.id.btn_CJ4_FMC_E);
        Button cj4_FMC_F = v.findViewById(R.id.btn_CJ4_FMC_F);
        Button cj4_FMC_G = v.findViewById(R.id.btn_CJ4_FMC_G);
        Button cj4_FMC_H = v.findViewById(R.id.btn_CJ4_FMC_H);
        Button cj4_FMC_I = v.findViewById(R.id.btn_CJ4_FMC_I);
        Button cj4_FMC_J = v.findViewById(R.id.btn_CJ4_FMC_J);
        Button cj4_FMC_K = v.findViewById(R.id.btn_CJ4_FMC_K);
        Button cj4_FMC_L = v.findViewById(R.id.btn_CJ4_FMC_L);
        Button cj4_FMC_M = v.findViewById(R.id.btn_CJ4_FMC_M);
        Button cj4_FMC_N = v.findViewById(R.id.btn_CJ4_FMC_N);
        Button cj4_FMC_O = v.findViewById(R.id.btn_CJ4_FMC_O);
        Button cj4_FMC_P = v.findViewById(R.id.btn_CJ4_FMC_P);
        Button cj4_FMC_Q = v.findViewById(R.id.btn_CJ4_FMC_Q);
        Button cj4_FMC_R = v.findViewById(R.id.btn_CJ4_FMC_R);
        Button cj4_FMC_S = v.findViewById(R.id.btn_CJ4_FMC_S);
        Button cj4_FMC_T = v.findViewById(R.id.btn_CJ4_FMC_T);
        Button cj4_FMC_U = v.findViewById(R.id.btn_CJ4_FMC_U);
        Button cj4_FMC_V = v.findViewById(R.id.btn_CJ4_FMC_V);
        Button cj4_FMC_W = v.findViewById(R.id.btn_CJ4_FMC_W);
        Button cj4_FMC_X = v.findViewById(R.id.btn_CJ4_FMC_X);
        Button cj4_FMC_Y = v.findViewById(R.id.btn_CJ4_FMC_Y);
        Button cj4_FMC_Z = v.findViewById(R.id.btn_CJ4_FMC_Z);
        //Button cj4_FMC_space = v.findViewById(R.id.btn_CJ4_FMC_space);
        Button cj4_FMC_DIV = v.findViewById(R.id.btn_CJ4_FMC_DIV);
        Button cj4_FMC_LSK1 = v.findViewById(R.id.btn_CJ4_FMC_LSK1);
        Button cj4_FMC_LSK2 = v.findViewById(R.id.btn_CJ4_FMC_LSK2);
        Button cj4_FMC_LSK3 = v.findViewById(R.id.btn_CJ4_FMC_LSK3);
        Button cj4_FMC_LSK4 = v.findViewById(R.id.btn_CJ4_FMC_LSK4);
        Button cj4_FMC_LSK5 = v.findViewById(R.id.btn_CJ4_FMC_LSK5);
        Button cj4_FMC_LSK6 = v.findViewById(R.id.btn_CJ4_FMC_LSK6);
        Button cj4_FMC_RSK1 = v.findViewById(R.id.btn_CJ4_FMC_RSK1);
        Button cj4_FMC_RSK2 = v.findViewById(R.id.btn_CJ4_FMC_RSK2);
        Button cj4_FMC_RSK3 = v.findViewById(R.id.btn_CJ4_FMC_RSK3);
        Button cj4_FMC_RSK4 = v.findViewById(R.id.btn_CJ4_FMC_RSK4);
        Button cj4_FMC_RSK5 = v.findViewById(R.id.btn_CJ4_FMC_RSK5);
        Button cj4_FMC_RSK6 = v.findViewById(R.id.btn_CJ4_FMC_RSK6);
        Button cj4_FMC_1 = v.findViewById(R.id.btn_CJ4_FMC_1);
        Button cj4_FMC_2 = v.findViewById(R.id.btn_CJ4_FMC_2);
        Button cj4_FMC_3 = v.findViewById(R.id.btn_CJ4_FMC_3);
        Button cj4_FMC_4 = v.findViewById(R.id.btn_CJ4_FMC_4);
        Button cj4_FMC_5 = v.findViewById(R.id.btn_CJ4_FMC_5);
        Button cj4_FMC_6 = v.findViewById(R.id.btn_CJ4_FMC_6);
        Button cj4_FMC_7 = v.findViewById(R.id.btn_CJ4_FMC_7);
        Button cj4_FMC_8 = v.findViewById(R.id.btn_CJ4_FMC_8);
        Button cj4_FMC_9 = v.findViewById(R.id.btn_CJ4_FMC_9);
        Button cj4_FMC_0 = v.findViewById(R.id.btn_CJ4_FMC_0);
        Button cj4_FMC_DOT = v.findViewById(R.id.btn_CJ4_FMC_DOT);
        Button cj4_FMC_PLUSMINUS = v.findViewById(R.id.btn_CJ4_FMC_PLUSMINUS);
        Button cj4_FMC_IDX = v.findViewById(R.id.btn_CJ4_FMC_IDX);
        Button cj4_FMC_MSG = v.findViewById(R.id.btn_CJ4_FMC_MSG);
        Button cj4_FMC_DIR = v.findViewById(R.id.btn_CJ4_FMC_DIR);
        Button cj4_FMC_TUN = v.findViewById(R.id.btn_CJ4_FMC_TUN);
        Button cj4_FMC_FPLN = v.findViewById(R.id.btn_CJ4_FMC_FPLN);
        Button cj4_FMC_LEGS = v.findViewById(R.id.btn_CJ4_FMC_LEGS);
        Button cj4_FMC_DEPARR = v.findViewById(R.id.btn_CJ4_FMC_DEPARR);
        Button cj4_FMC_PERF = v.findViewById(R.id.btn_CJ4_FMC_PERF);
        Button cj4_FMC_DSPL_MENU = v.findViewById(R.id.btn_CJ4_FMC_DSPL_MENU);
        Button cj4_FMC_MFD_ADV = v.findViewById(R.id.btn_CJ4_FMC_MFD_ADV);
        Button cj4_FMC_MFD_DATA = v.findViewById(R.id.btn_CJ4_FMC_MFD_DATA);
        Button cj4_FMC_PREVPAGE = v.findViewById(R.id.btn_CJ4_FMC_PREVPAGE);
        Button cj4_FMC_NEXTPAGE = v.findViewById(R.id.btn_CJ4_FMC_NEXTPAGE);
        Button cj4_FMC_EXEC = v.findViewById(R.id.btn_CJ4_FMC_EXEC);
        Button cj4_FMC_CLR = v.findViewById(R.id.btn_CJ4_FMC_CLR);

        // Button listeners
        cj4_FMC_A.setOnClickListener(this);
        cj4_FMC_B.setOnClickListener(this);
        cj4_FMC_C.setOnClickListener(this);
        cj4_FMC_D.setOnClickListener(this);
        cj4_FMC_E.setOnClickListener(this);
        cj4_FMC_F.setOnClickListener(this);
        cj4_FMC_G.setOnClickListener(this);
        cj4_FMC_H.setOnClickListener(this);
        cj4_FMC_I.setOnClickListener(this);
        cj4_FMC_J.setOnClickListener(this);
        cj4_FMC_K.setOnClickListener(this);
        cj4_FMC_L.setOnClickListener(this);
        cj4_FMC_M.setOnClickListener(this);
        cj4_FMC_N.setOnClickListener(this);
        cj4_FMC_O.setOnClickListener(this);
        cj4_FMC_P.setOnClickListener(this);
        cj4_FMC_Q.setOnClickListener(this);
        cj4_FMC_R.setOnClickListener(this);
        cj4_FMC_S.setOnClickListener(this);
        cj4_FMC_T.setOnClickListener(this);
        cj4_FMC_U.setOnClickListener(this);
        cj4_FMC_V.setOnClickListener(this);
        cj4_FMC_W.setOnClickListener(this);
        cj4_FMC_X.setOnClickListener(this);
        cj4_FMC_Y.setOnClickListener(this);
        cj4_FMC_Z.setOnClickListener(this);
        //cj4_FMC_space.setOnClickListener(this);
        cj4_FMC_DIV.setOnClickListener(this);
        cj4_FMC_LSK1.setOnClickListener(this);
        cj4_FMC_LSK2.setOnClickListener(this);
        cj4_FMC_LSK3.setOnClickListener(this);
        cj4_FMC_LSK4.setOnClickListener(this);
        cj4_FMC_LSK5.setOnClickListener(this);
        cj4_FMC_LSK6.setOnClickListener(this);
        cj4_FMC_RSK1.setOnClickListener(this);
        cj4_FMC_RSK2.setOnClickListener(this);
        cj4_FMC_RSK3.setOnClickListener(this);
        cj4_FMC_RSK4.setOnClickListener(this);
        cj4_FMC_RSK5.setOnClickListener(this);
        cj4_FMC_RSK6.setOnClickListener(this);
        cj4_FMC_1.setOnClickListener(this);
        cj4_FMC_2.setOnClickListener(this);
        cj4_FMC_3.setOnClickListener(this);
        cj4_FMC_4.setOnClickListener(this);
        cj4_FMC_5.setOnClickListener(this);
        cj4_FMC_6.setOnClickListener(this);
        cj4_FMC_7.setOnClickListener(this);
        cj4_FMC_8.setOnClickListener(this);
        cj4_FMC_9.setOnClickListener(this);
        cj4_FMC_0.setOnClickListener(this);
        cj4_FMC_DOT.setOnClickListener(this);
        cj4_FMC_PLUSMINUS.setOnClickListener(this);
        cj4_FMC_IDX.setOnClickListener(this);
        cj4_FMC_MSG.setOnClickListener(this);
        cj4_FMC_DIR.setOnClickListener(this);
        cj4_FMC_TUN.setOnClickListener(this);
        cj4_FMC_FPLN.setOnClickListener(this);
        cj4_FMC_LEGS.setOnClickListener(this);
        cj4_FMC_DEPARR.setOnClickListener(this);
        cj4_FMC_PERF.setOnClickListener(this);
        cj4_FMC_DSPL_MENU.setOnClickListener(this);
        cj4_FMC_MFD_ADV.setOnClickListener(this);
        cj4_FMC_MFD_DATA.setOnClickListener(this);
        cj4_FMC_PREVPAGE.setOnClickListener(this);
        cj4_FMC_NEXTPAGE.setOnClickListener(this);
        cj4_FMC_EXEC.setOnClickListener(this);
        cj4_FMC_CLR.setOnClickListener(this);
        cj4_FMC_CLR.setOnLongClickListener(this);       // Long click listener on CLR/DEL button that triggers delete immediately
        return v;
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();              // Can't use switch case anymore since R.ids are not final anymore
        if (id == R.id.btn_CJ4_FMC_A) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_A/trigger", null);
        } else if (id == R.id.btn_CJ4_FMC_B) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_B/trigger", null);
        } else if (id == R.id.btn_CJ4_FMC_C) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_C/trigger", null);
        } else if (id == R.id.btn_CJ4_FMC_D) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_D/trigger", null);
        } else if (id == R.id.btn_CJ4_FMC_E) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_E/trigger", null);
        } else if (id == R.id.btn_CJ4_FMC_F) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_F/trigger", null);
        } else if (id == R.id.btn_CJ4_FMC_G) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_G/trigger", null);
        } else if (id == R.id.btn_CJ4_FMC_H) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_H/trigger", null);
        } else if (id == R.id.btn_CJ4_FMC_I) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_I/trigger", null);
        } else if (id == R.id.btn_CJ4_FMC_J) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_J/trigger", null);
        } else if (id == R.id.btn_CJ4_FMC_K) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_K/trigger", null);
        } else if (id == R.id.btn_CJ4_FMC_L) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_L/trigger", null);
        } else if (id == R.id.btn_CJ4_FMC_M) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_M/trigger", null);
        } else if (id == R.id.btn_CJ4_FMC_N) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_N/trigger", null);
        } else if (id == R.id.btn_CJ4_FMC_O) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_O/trigger", null);
        } else if (id == R.id.btn_CJ4_FMC_P) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_P/trigger", null);
        } else if (id == R.id.btn_CJ4_FMC_Q) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_Q/trigger", null);
        } else if (id == R.id.btn_CJ4_FMC_R) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_R/trigger", null);
        } else if (id == R.id.btn_CJ4_FMC_S) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_S/trigger", null);
        } else if (id == R.id.btn_CJ4_FMC_T) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_T/trigger", null);
        } else if (id == R.id.btn_CJ4_FMC_U) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_U/trigger", null);
        } else if (id == R.id.btn_CJ4_FMC_V) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_V/trigger", null);
        } else if (id == R.id.btn_CJ4_FMC_W) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_W/trigger", null);
        } else if (id == R.id.btn_CJ4_FMC_X) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_X/trigger", null);
        } else if (id == R.id.btn_CJ4_FMC_Y) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_Y/trigger", null);
        } else if (id == R.id.btn_CJ4_FMC_Z) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_Z/trigger", null);
            //} else if (id == R.id.btn_CJ4_FMC_space) {// Couldn't find in list
        } else if (id == R.id.btn_CJ4_FMC_DIV) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_DIV/trigger", null);
        } else if ((id == R.id.btn_CJ4_FMC_LSK1)) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_L1/trigger", null);
        } else if ((id == R.id.btn_CJ4_FMC_LSK2)) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_L2/trigger", null);
        } else if ((id == R.id.btn_CJ4_FMC_LSK3)) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_L3/trigger", null);
        } else if ((id == R.id.btn_CJ4_FMC_LSK4)) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_L4/trigger", null);
        } else if ((id == R.id.btn_CJ4_FMC_LSK5)) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_L5/trigger", null);
        } else if ((id == R.id.btn_CJ4_FMC_LSK6)) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_L6/trigger", null);
        } else if ((id == R.id.btn_CJ4_FMC_RSK1)) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_R1/trigger", null);
        } else if ((id == R.id.btn_CJ4_FMC_RSK2)) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_R2/trigger", null);
        } else if ((id == R.id.btn_CJ4_FMC_RSK3)) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_R3/trigger", null);
        } else if ((id == R.id.btn_CJ4_FMC_RSK4)) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_R4/trigger", null);
        } else if ((id == R.id.btn_CJ4_FMC_RSK5)) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_R5/trigger", null);
        } else if ((id == R.id.btn_CJ4_FMC_RSK6)) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_R6/trigger", null);
        } else if ((id == R.id.btn_CJ4_FMC_1)) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_1/trigger", null);
        } else if ((id == R.id.btn_CJ4_FMC_2)) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_2/trigger", null);
        } else if ((id == R.id.btn_CJ4_FMC_3)) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_3/trigger", null);
        } else if ((id == R.id.btn_CJ4_FMC_4)) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_4/trigger", null);
        } else if ((id == R.id.btn_CJ4_FMC_5)) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_5/trigger", null);
        } else if ((id == R.id.btn_CJ4_FMC_6)) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_6/trigger", null);
        } else if ((id == R.id.btn_CJ4_FMC_7)) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_7/trigger", null);
        } else if ((id == R.id.btn_CJ4_FMC_8)) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_8/trigger", null);
        } else if ((id == R.id.btn_CJ4_FMC_9)) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_9/trigger", null);
        } else if ((id == R.id.btn_CJ4_FMC_0)) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_0/trigger", null);
        } else if ((id == R.id.btn_CJ4_FMC_DOT)) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_DOT/trigger", null);
        } else if ((id == R.id.btn_CJ4_FMC_PLUSMINUS)) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_PLUSMINUS/trigger", null);
        } else if ((id == R.id.btn_CJ4_FMC_IDX)) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_IDX/trigger", null);
        } else if ((id == R.id.btn_CJ4_FMC_MSG)) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_MSG/trigger", null);
        } else if ((id == R.id.btn_CJ4_FMC_DIR)) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_DIR/trigger", null);
        } else if ((id == R.id.btn_CJ4_FMC_TUN)) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_TUN/trigger", null);
        } else if ((id == R.id.btn_CJ4_FMC_FPLN)) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_FPLN/trigger", null);
        } else if ((id == R.id.btn_CJ4_FMC_LEGS)) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_LEGS/trigger", null);
        } else if ((id == R.id.btn_CJ4_FMC_DEPARR)) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_DEPARR/trigger", null);
        } else if ((id == R.id.btn_CJ4_FMC_PERF)) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_PERF/trigger", null);
        } else if ((id == R.id.btn_CJ4_FMC_DSPL_MENU)) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_DSPL_MENU/trigger", null);
        } else if ((id == R.id.btn_CJ4_FMC_MFD_ADV)) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_MFD_ADV/trigger", null);
        } else if ((id == R.id.btn_CJ4_FMC_MFD_DATA)) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_MFD_DATA/trigger", null);
        } else if ((id == R.id.btn_CJ4_FMC_PREVPAGE)) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_PREVPAGE/trigger", null);
        } else if ((id == R.id.btn_CJ4_FMC_NEXTPAGE)) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_NEXTPAGE/trigger", null);
        } else if ((id == R.id.btn_CJ4_FMC_EXEC)) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_EXEC/trigger", null);
        } else if ((id == R.id.btn_CJ4_FMC_CLR)) {
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_CLR/trigger", null);
        }
    }

    @Override
    public boolean onLongClick(View view) {
        int id=view.getId();
        if (id == R.id.btn_CJ4_FMC_CLR){        // A long click on the CLR button on FMC triggers a delete on FMC
            flask.postToFlaskServer("/wt_cj4_event/CJ4_FMC_1_BTN_CLR_Long/trigger", null);
            return true;
        }
        return false;
    }
}
