package com.example.msfs2020_cockpit_extension_app;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

import com.example.msfs2020_cockpit_extension_app.SimVarEnums.*;

public class MonitorFragment extends Fragment {
    private String TAG = "MONITOR";
    public HashMap<String, String> dataSet = new HashMap<>();
    private final OkHttpClient client = new OkHttpClient();
    private RequestBody requestBody;
    private MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private String baseUrl = "http://192.168.50.39:5000/";
    TextView leftFuelPercent, leftFuel, rightFuelPercent, rightFuel;
    TextView elevatorTrim, aileronTrim, rudderTrim;
    ProgressBar leftFuelPB, rightFuelPB;
    private SimVarViewModel mViewModel;
    Timer fuelTimer, trimTimer;
    TimerTask fuelTimerTask, trimTimerTask;
    private int fuelVarTimerPeriod = 5000;
    private int trimVarTimerPeriod = 1000;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.monitor_layout, container, false);

        // View model
        mViewModel = new ViewModelProvider(this).get(SimVarViewModel.class);

        // Model observers
        final Observer<HashMap<String, String>> simFuelVarsObserver = new Observer<HashMap<String, String>>() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onChanged(HashMap<String, String> simFuelVars) {
                Log.d(TAG, "sim fuel variables have changed");
                updateFuelVars(simFuelVars);
            }
        };
        final Observer<HashMap<String, String>> simTrimVarsObserver = new Observer<HashMap<String, String>>() {
            @Override
            public void onChanged(HashMap<String, String> simTrimVars) {
                Log.d(TAG, "sim trim varialbes have changed");
                updateTrimVars(simTrimVars);
            }
        };

        mViewModel.getFuelVars().observe(getViewLifecycleOwner(), simFuelVarsObserver);
        mViewModel.getTrimVars().observe(getViewLifecycleOwner(), simTrimVarsObserver);

        // Get the UI objects
        leftFuelPercent = v.findViewById(R.id.leftFuelPercent);
        leftFuel = v.findViewById(R.id.leftFuel);
        rightFuelPercent = v.findViewById(R.id.rightFuelPercent);
        rightFuel = v.findViewById(R.id.rightFuel);
        leftFuelPB = v.findViewById(R.id.leftFuelPB);
        rightFuelPB = v.findViewById(R.id.rightFuelPB);

        elevatorTrim = v.findViewById(R.id.elevatorTrim);
        aileronTrim = v.findViewById(R.id.aileronTrim);
        rudderTrim = v.findViewById(R.id.rudderTrim);

        return v;
    }

    // When fragment in view, start timers
    @Override
    public void onResume() {
        super.onResume();

        // Setup timers
        fuelTimerTask = new TimerTask() {
            @Override
            public void run() {
                for (FuelVars var : FuelVars.values()) {
                    pull(var.name(), VarCategories.FUEL);
                }
            }
        };
        trimTimerTask = new TimerTask() {
            @Override
            public void run() {
                for (TrimVars var : TrimVars.values()) {
                    pull(var.name(), VarCategories.TRIM);
                }
            }
        };
        fuelTimer = new Timer();
        trimTimer = new Timer();
        fuelTimer.schedule(fuelTimerTask, 0, fuelVarTimerPeriod);
        trimTimer.schedule(trimTimerTask, 0, trimVarTimerPeriod);
        Log.d(TAG, "Timers started");
    }

    // When Monitor fragment not in view, stop timers and cancel any client calls
    @Override
    public void onPause() {
        super.onPause();

        fuelTimer.cancel();
        trimTimer.cancel();
        Log.d(TAG, "Timers cancelled");

        Log.d(TAG, "Cancelling " + client.dispatcher().queuedCallsCount() + " queued calls");
        for (Call call : client.dispatcher().queuedCalls()) {
            call.cancel();
        }
        Log.d(TAG, "Cancelling " + client.dispatcher().runningCallsCount() + " running calls");
        for (Call call : client.dispatcher().runningCalls()) {
            call.cancel();
        }
    }

    private void pull(String dataPoint, VarCategories category) {
        String url = baseUrl + "/datapoint/" + dataPoint + "/get";
        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
                Log.d(TAG, "Request failure to: " + url);
            }

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (!response.isSuccessful()) throw new IOException(("Unexpected code " + response));
                    String res = responseBody.string();

                    // Update the model, ignore if response is "null"
                    if (!res.equalsIgnoreCase("null")) mViewModel.putValue(dataPoint, res, category);
                }
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void updateFuelVars(HashMap<String, String> map) {
        String sLeftQuant = map.get(FuelVars.FUEL_LEFT_QUANTITY.name());
        String sLeftCap = map.get(FuelVars.FUEL_LEFT_CAPACITY.name());
        String sRightQuant = map.get(FuelVars.FUEL_RIGHT_QUANTITY.name());
        String sRightCap = map.get(FuelVars.FUEL_RIGHT_CAPACITY.name());

        try {
            float leftQuant = (sLeftQuant == null) || (sLeftQuant.equalsIgnoreCase("null"))
                    ? 0 : Float.parseFloat(sLeftQuant);
            float leftCap = (sLeftCap == null) || (sLeftCap.equalsIgnoreCase("null"))
                    ? 0 : Float.parseFloat(sLeftCap);
            float rightQuant = (sRightQuant == null) || (sRightQuant.equalsIgnoreCase("null"))
                    ? 0 : Float.parseFloat(sRightQuant);
            float rightCap = (sRightCap == null) || (sRightCap.equalsIgnoreCase("null"))
                    ? 0 : Float.parseFloat(sRightCap);

            // Compute percentage and truncate by casting to integer. Don't allow division by 0
            int iLeftFuelPercent = (leftCap == 0) ? 0 : (int) (100 * leftQuant / leftCap);
            int iRightFuelPercent = (rightCap == 0) ? 0 : (int) (100 * rightQuant / rightCap);

            // Update the UI
            leftFuel.setText(String.format(Locale.US, "%.2f / %.2f", leftQuant, rightCap));
            leftFuelPercent.setText(String.format(Locale.US, "%d%%", iLeftFuelPercent));
            leftFuelPB.setProgress(iLeftFuelPercent, true);

            rightFuel.setText(String.format(Locale.US, "%.2f / %.2f", rightQuant, rightCap));
            rightFuelPercent.setText(String.format(Locale.US, "%d%%", iRightFuelPercent));
            rightFuelPB.setProgress(iRightFuelPercent, true);
        } catch (NumberFormatException e) {
            Log.d(TAG, "Number format exception:");
            Log.d(TAG, "  LeftQuant: " + sLeftQuant);
            Log.d(TAG, "  LeftCap: " + sLeftCap);
            Log.d(TAG, "  RightQuant: " + sRightQuant);
            Log.d(TAG, "  RightCap: " + sRightCap);
        }
    }

    public void updateTrimVars(HashMap<String, String> map) {
        String sElevatorTrim = map.get(TrimVars.ELEVATOR_TRIM_PCT.name());
        String sAileronTrim = map.get(TrimVars.AILERON_TRIM_PCT.name());
        String sRudderTrim = map.get(TrimVars.RUDDER_TRIM_PCT.name());

        try {
            float flElevatorTrim = (sElevatorTrim == null) ? 0 : 100 * Float.parseFloat(sElevatorTrim);
            float flAileronTrim = (sAileronTrim == null) ? 0 : 100 * Float.parseFloat(sAileronTrim);
            float flRudderTrim = (sRudderTrim == null) ? 0 : 100 * Float.parseFloat(sRudderTrim);

            // Update the UI
            elevatorTrim.setText(String.format(Locale.US, "%.1f%%", flElevatorTrim));
            aileronTrim.setText(String.format(Locale.US, "%.1f%%", flAileronTrim));
            rudderTrim.setText(String.format(Locale.US, "%.1f%%", flRudderTrim));
        } catch(NumberFormatException e){
            Log.d(TAG, "Number format exception:");
            Log.d(TAG, "  Elevator Trim: "+sElevatorTrim);
            Log.d(TAG, "  Aileron Trim: "+sAileronTrim);
            Log.d(TAG, "  Rudder Trim: "+sRudderTrim);
        }
    }
}
