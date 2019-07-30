package com.trongdeptrai.demohttpurlconnection;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpHandler {
    public String makeServiceCall(String reqUrl) {
        String reponse = null;
        try {
            // connect tới link
            URL url = new URL(reqUrl);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            // tạo một inputstream đọc stream từ url
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            //chuyển stream về string
            reponse = converStreamToString(in);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return reponse;
    }

    private String converStreamToString(InputStream in) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();
        String line;
        //khi mà line = read.line != null
        while ((line = reader.readLine()) != null) {
            sb.append(line); // nối stream đọc được
        }
        try {
            // close để giải phóng tài nguyên
            in.close();
        } catch (Exception e) {
            e.getMessage();
        }
        // convert về string
        return sb.toString();
    }
}
