package com.example.msfs2020_cockpit_extension_app;

import androidx.annotation.NonNull;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

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

    // Send a POST to the flask server
    // TODO: receive json req as parametr
    // TODO: return json resonse if applicable
    public void postToFlaskServer(String reqURL, String json) {
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
}
