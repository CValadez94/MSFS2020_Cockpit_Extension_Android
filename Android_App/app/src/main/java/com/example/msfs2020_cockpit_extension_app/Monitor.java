package com.example.msfs2020_cockpit_extension_app;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
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

import com.example.msfs2020_cockpit_extension_app.SimVarEnums.FuelVars;
import com.example.msfs2020_cockpit_extension_app.SimVarEnums.VarCategories;

public class Monitor extends Fragment {
    private String TAG = "MONITOR";
    public HashMap<String, String> dataSet = new HashMap<>();
    private final OkHttpClient client = new OkHttpClient();
    private RequestBody requestBody;
    private MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private String baseUrl = "http://192.168.50.39:5000/";
    TextView leftFuelPercent, leftFuel, rightFuelPercent, rightFuel;
    ProgressBar leftFuelPB, rightFuelPB;
    private SimVarViewModel mViewModel;
    Timer timer;
    TimerTask timerTask;
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
                Log.d(TAG, "sim variables have changed");
                update(simFuelVars);
            }
        };
        mViewModel.getFuelVars().observe(getViewLifecycleOwner(), simFuelVarsObserver);

        ImageButton sync = v.findViewById(R.id.btnSync);
        Button pull = v.findViewById(R.id.btnPull);
        leftFuelPercent = v.findViewById(R.id.leftFuelPercent);
        leftFuel = v.findViewById(R.id.leftFuel);
        rightFuelPercent = v.findViewById(R.id.rightFuelPercent);
        rightFuel = v.findViewById(R.id.rightFuel);
        leftFuelPB = v.findViewById(R.id.leftFuelPB);
        rightFuelPB = v.findViewById(R.id.rightFuelPB);

        sync.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                //update();
            }
        });
        pull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (FuelVars var : FuelVars.values()) {
                    pull(var.name(), VarCategories.FUEL);
                }
            }
        });


        //timer.schedule(timerTask, 0, 2000);

        return v;
    }

    // When fragment in view, start timers
    @Override
    public void onResume() {
        super.onResume();

        // Setup timer
        timerTask = new TimerTask() {
            @Override
            public void run() {
                for (FuelVars var : FuelVars.values()) {
                    pull(var.name(), VarCategories.FUEL);
                }
            }
        };
        timer = new Timer();
        timer.schedule(timerTask, 0, fuelVarTimerPeriod);
        Log.d(TAG, "Timers started");
    }

    // When Monitor fragment not in view, stop timers and cancel any client calls
    @Override
    public void onPause() {
        super.onPause();
        timer.cancel();
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

                    // Update the model
                    mViewModel.putValue(dataPoint, res, category);
                }
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void update(HashMap<String, String> map) {
        if (map.isEmpty()) {
            Log.d(TAG, "Map is emtpy");
        } else {
            Log.d(TAG, String.valueOf(map.size()));
            Log.d(TAG, String.valueOf(map.values()));

            float leftQuant = Float.parseFloat(Objects.requireNonNull(map.get("FUEL_LEFT_QUANTITY")));
            float leftCap = Float.parseFloat(Objects.requireNonNull(map.get("FUEL_LEFT_CAPACITY")));
            float rightQuant = Float.parseFloat(Objects.requireNonNull(map.get("FUEL_RIGHT_QUANTITY")));
            float rightCap = Float.parseFloat(Objects.requireNonNull(map.get("FUEL_RIGHT_CAPACITY")));

            // Compute percentage and truncate by casting to integer. Don't allow division by 0
            int iLeftFuelPercent = leftCap == 0 ? 0 : (int) (100 * leftQuant / leftCap);
            int iRightFuelPercent = rightCap == 0 ? 0 : (int) (100 * rightQuant / rightCap);


            leftFuel.setText(String.format(Locale.US, "%.2f / %.2f", leftQuant, rightCap));
            leftFuelPercent.setText(String.format(Locale.US, "%d", iLeftFuelPercent));
            leftFuelPB.setProgress(iLeftFuelPercent, true);

            rightFuel.setText(String.format(Locale.US, "%.2f / %.2f", rightQuant, rightCap));
            rightFuelPercent.setText(String.format(Locale.US, "%d", iRightFuelPercent));
            rightFuelPB.setProgress(iRightFuelPercent, true);
        }
    }

}
