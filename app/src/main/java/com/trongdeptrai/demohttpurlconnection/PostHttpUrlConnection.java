package com.trongdeptrai.demohttpurlconnection;

import android.os.AsyncTask;
import android.util.JsonReader;
import android.util.Log;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class PostHttpUrlConnection extends AsyncTask<String, Void, String> {
    private TextView tvResult;
    private String mResult;
    private String mName;
    public PostHttpUrlConnection(TextView tvResult, String name) {
        this.tvResult = tvResult;
        this.mName = name;
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            URL url = new URL(strings[0]);
            String param = "name=" + URLEncoder.encode(this.mName, "utf-8");
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();
            // cho phép viết
            connection.setDoOutput(true);
            // xác định phương thức gửi
            connection.setRequestMethod("POST");
            // không sử dụng bộ nhớ đệm khi biết được độ dài
            connection.setFixedLengthStreamingMode(param.getBytes().length);
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            PrintWriter printWriter = new PrintWriter(connection.getOutputStream());
            printWriter.print(param);
            printWriter.close();

            String line = "";
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuffer sb = new StringBuffer();
            while ((line = br.readLine()) != null){
                sb.append(line);
            }
            mResult = sb.toString();
            connection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return mResult;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if(!s.isEmpty()){
            tvResult.setText(s);
        }
    }
}
