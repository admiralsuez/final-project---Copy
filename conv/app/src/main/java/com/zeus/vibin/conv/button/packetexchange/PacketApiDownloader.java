package com.zeus.vibin.conv.button.packetexchange;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import java.io.BufferedReader;

/**
 * Created by cyber on 22-Feb-17.
 */
public class PacketApiDownloader extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... url) {
        return getPacketsJson(url[0]);
    }

    private String getPacketsJson(String address) {
        StringBuffer stringBuffer = new StringBuffer();
        BufferedReader reader = null;

        try {
            URL url = new URL(address);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());

            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";

            while ((line  = reader.readLine()) != null){
                stringBuffer.append(line);

            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return stringBuffer.toString();
    }
}
