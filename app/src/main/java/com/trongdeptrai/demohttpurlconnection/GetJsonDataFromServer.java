package com.trongdeptrai.demohttpurlconnection;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.trongdeptrai.demohttpurlconnection.adapter.SinhVienAdapter;
import com.trongdeptrai.demohttpurlconnection.model.SinhVien;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GetJsonDataFromServer extends AsyncTask<Void, Void, ArrayList<SinhVien>> {
    private static final String LINK = "http://172.16.37.7/DemoHttp/ConvertJSON.php";
    private Context mContext;
    private ListView mLv;
    private ArrayList<SinhVien> sinhVienArr;
    private ProgressDialog pdLoad;
    public GetJsonDataFromServer(Context context, ListView lv) {
        mContext = context;
        mLv = lv;
        sinhVienArr = new ArrayList<>();
    }

    @Override
    protected ArrayList<SinhVien> doInBackground(Void... voids) {
        HttpHandler httpHandler = new HttpHandler();
        String jsonStr = httpHandler.makeServiceCall(LINK);
        if (!jsonStr.isEmpty()) {
            try {
                JSONArray svArr = new JSONArray(jsonStr);
                for (int i = 0; i < svArr.length(); i++) {
                    JSONObject obs = svArr.getJSONObject(i);
                    String name = obs.getString("Name");
                    String phone = obs.getString("Phone");
                    String address = obs.getString("Address");
                    sinhVienArr.add(new SinhVien(name, phone, address));
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return sinhVienArr;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pdLoad = new ProgressDialog(mContext);
        pdLoad.setMessage("Please wait...");
        pdLoad.setCancelable(false);
        pdLoad.show();

    }



    @Override
    protected void onPostExecute(ArrayList<SinhVien> sinhViens) {
        super.onPostExecute(sinhViens);
        if(pdLoad.isShowing()){
            pdLoad.dismiss();
        }
            SinhVienAdapter sinhVienAdapter = new SinhVienAdapter(mContext, sinhViens);
            mLv.setAdapter(sinhVienAdapter);
    }
}
