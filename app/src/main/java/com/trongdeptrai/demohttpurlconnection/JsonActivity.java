package com.trongdeptrai.demohttpurlconnection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import com.trongdeptrai.demohttpurlconnection.model.SinhVien;
import java.util.ArrayList;

public class JsonActivity extends AppCompatActivity {
    private ListView lvSinhVien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);
        initView();
    }

    private void initView() {
        lvSinhVien = findViewById(R.id.listview_SinhVien);
        GetJsonDataFromServer data = new GetJsonDataFromServer(this, lvSinhVien);
        data.execute();
    }
}
