package com.example.msfs2020_cockpit_extension_app;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.msfs2020_cockpit_extension_app.databinding.ActivityMainBinding;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.BufferedReader;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.net.ssl.HttpsURLConnection;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity {

    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    TabLayout tabLayout;
    ViewPager2 viewPager2;
    FragmentAdapter fragmentAdapter;
    private final OkHttpClient client = new OkHttpClient();
    RequestBody requestBody;
    MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager2 = findViewById(R.id.view_pager2);

        FragmentManager fm = getSupportFragmentManager();
        fragmentAdapter = new FragmentAdapter(fm, getLifecycle());
        viewPager2.setAdapter(fragmentAdapter);

        // Add the tabs
        tabLayout.addTab(tabLayout.newTab().setText(TAB_TITLES[0]));
        tabLayout.addTab(tabLayout.newTab().setText(TAB_TITLES[1]));

        // Tab selected listener
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(@NonNull TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        // Swipe page callback
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });

        viewPager2.setUserInputEnabled(false);          // Disable the swiping feature
    }

    // Send a POST to the flask server
    // TODO: receive json req as parametr
    // TODO: return json resonse if applicable
    private void postToFlaskServer(String reqURL, String json) throws Exception {
        String url = "http://192.168.50.39:5000/" + reqURL;
        byte[] postData = json.getBytes(StandardCharsets.UTF_8);

        requestBody = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
                System.out.print("FAILURE!");
            }

            @Override
            public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException {
                try (ResponseBody responseBody = response.body()) {
                    if (!response.isSuccessful()) throw new IOException(("Unexpected code " + response));

                    Headers responseHeaders = response.headers();
                    for (int i = 0, size = responseHeaders.size(); i < size; i++) {
                        System.out.println(responseHeaders.name(i) + " : " + responseHeaders.value(i));
                    }

                    System.out.println(responseBody.string());
                }
            }
        });
    }

    public void toggleLandingLights(View view) {
        try {
            postToFlaskServer("/event/LANDING_LIGHTS_TOGGLE/trigger", "{\"value_to_use\":\"1\"}");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception caught.");
        }
    }

    public void toggleMasterAlternator(View view) {
        try {
            postToFlaskServer("/event/TOGGLE_MASTER_ALTERNATOR/trigger", "{\"value_to_use\":\"0\"}");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception caught.");
        }
    }

    public void toggleMasterBattery(View view) {
        try {
            postToFlaskServer("/event/TOGGLE_MASTER_BATTERY/trigger", "{\"value_to_use\":\"1\"}");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception caught.");
        }
    }

    public void toggleAvionicsBus1(View view) {
        try {
            postToFlaskServer("/event/AVIONICS_MASTER_1_ON/trigger", "{\"value_to_use\":\"1\"}");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception caught.");
        }
    }

    public void toggleAvionicsBus2(View view) {

        try {
            postToFlaskServer("/event/AVIONICS_MASTER_2_ON/trigger", "{\"value_to_use\":\"1\"}");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception caught.");
        }
    }
}
