package com.example.msfs2020_cockpit_extension_app;

import android.content.Intent;

import androidx.annotation.NonNull;

import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class FlaskCalls {
    private final OkHttpClient client = new OkHttpClient();
    private RequestBody requestBody;
    private MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private String baseUrl = "http://192.168.50.39:5000/";
    private HashMap<String, String> mHashMap;

    public FlaskCalls(HashMap hashMap){
        mHashMap = hashMap;
    }

    public FlaskCalls(){
        // Do nothing, hashmap won't be used
    }

    // Send a POST to the flask server
    // TODO: receive json req as parametr
    // TODO: return json response if applicable
    public void postToFlaskServer(String reqURL, String json) {
        String url = baseUrl + reqURL;
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
                System.out.println("FAILURE!");
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

    public void requestDatapoint(String datapoint) {
        httpGet(datapoint);
    }

    private void httpPost() {

    }

    private void httpGet(String datapoint) {
        String url = baseUrl + "/datapoint/" + datapoint + "/get";
        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NonNull Call call, @NonNull IOException e) {
                e.printStackTrace();
                System.out.println("Request failure to: " + url);
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

                    // CRASHING HERE
                    mHashMap.put(datapoint, responseBody.string());
                }
            }
        });
    }

}
