package com.example.msfs2020_cockpit_extension_app;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.HashMap;

import com.example.msfs2020_cockpit_extension_app.SimVarEnums.*;


public class SimVarViewModel extends ViewModel {
    private String TAG = "SIM_VAR_VIEWMODEL";
    private MutableLiveData<HashMap<String, String>> mldSimFuelVars = new MutableLiveData<>();
    private MutableLiveData<HashMap<String, String>> mldSimTrimVars = new MutableLiveData<>();

    private HashMap<String, String> simFuelVars = new HashMap<>();
    private HashMap<String, String> simTrimVars = new HashMap<>();

    public String getValue(String key, VarCategories category) {
        switch (category) {
            case FUEL:
                return simFuelVars.get(key);
            case TRIM:
                return simTrimVars.get(key);
            default:
                return null;
        }
    }

    public void putValue(String key, String value, VarCategories category) {
        String preValue;

        switch (category) {
            case FUEL:
                preValue = simFuelVars.put(key, value);
                if (preValue == null) {
                    Log.d(TAG, key + " -> pair was null, new put");
                    mldSimFuelVars.postValue(simFuelVars);
                } else if (preValue.equals(value)) {
                    //Log.d(TAG, key + " -> same pair, not a new value");
                } else {
                    Log.d(TAG, key + " -> pair was newly updated");
                    mldSimFuelVars.postValue(simFuelVars);
                }
                break;
            case TRIM:
                preValue = simTrimVars.put(key, value);
                if (preValue == null) {
                    Log.d(TAG, key + " -> pair was null, new put");
                    mldSimTrimVars.postValue(simTrimVars);
                } else if (preValue.equals(value)) {
                    //Log.d(TAG, key + " -> same pair, not a new value");
                } else {
                    Log.d(TAG, key + " -> pair was newly updated");
                    mldSimTrimVars.postValue(simTrimVars);
                }
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + category);
        }
    }

    public MutableLiveData<HashMap<String, String>> getFuelVars() {
        if (mldSimFuelVars == null) {
            mldSimFuelVars = new MutableLiveData<>();
        }
        return mldSimFuelVars;
    }

    public MutableLiveData<HashMap<String, String>> getTrimVars() {
        if (mldSimTrimVars == null) {
            mldSimTrimVars = new MutableLiveData<>();
        }
        return mldSimTrimVars;
    }

    public SimVarViewModel() {
        super();

        // Initialize the hashmaps
        for (Enum f : FuelVars.values()) {
            simFuelVars.put(f.name(), "0");
        }
        for (Enum f : TrimVars.values()) {
            simFuelVars.put(f.name(), "0");
        }
    }
}
