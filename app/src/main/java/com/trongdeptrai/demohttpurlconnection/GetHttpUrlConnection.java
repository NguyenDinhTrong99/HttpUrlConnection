package com.trongdeptrai.demohttpurlconnection;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Debug;
import android.util.Log;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetHttpUrlConnection extends AsyncTask<String, Void, String> {
    private String link = MainActivity.URL_GET;
    private String result = null;
    private String mName;
    private TextView tvResult;

    public GetHttpUrlConnection(TextView tvResult, String name) {
        this.tvResult = tvResult;
        this.mName = name;
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            URL url = new URL(strings[0]);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line = "";
            StringBuffer sb = new StringBuffer();

            while ((line = br.readLine()) != null){
                sb.append(line);
            }
            result = sb.toString();
            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        tvResult.setText(s);
    }
}
