package com.trongdeptrai.demohttpurlconnection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    public static   String URL_GET = "http://172.16.37.7/DemoHttp/GET_NAME.php?name=";
    public static   String URL_POST = "http://172.16.37.7/DemoHttp/POST_NAME.php";
    private EditText edtName;
    private TextView tvResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_GET:
                String name = edtName.getText().toString();
                String link = URL_GET + name;
                GetHttpUrlConnection getResult = new GetHttpUrlConnection(tvResult, name);
                getResult.execute(link);
                break;
            case R.id.btn_Post:
                String names = edtName.getText().toString();
                PostHttpUrlConnection postResult = new PostHttpUrlConnection(tvResult, names);
                postResult.execute(URL_POST);
                break;
            case R.id.btn_GetJson:
                startActivity(new Intent(getApplicationContext(), JsonActivity.class));
                break;
        }
    }
    private void initView() {
        edtName = findViewById(R.id.edt_name);
        tvResult = findViewById(R.id.tv_Result);
    }
}
