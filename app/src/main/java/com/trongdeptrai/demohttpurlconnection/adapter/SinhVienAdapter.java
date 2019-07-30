package com.trongdeptrai.demohttpurlconnection.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.trongdeptrai.demohttpurlconnection.R;
import com.trongdeptrai.demohttpurlconnection.model.SinhVien;
import java.util.ArrayList;

public class SinhVienAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<SinhVien> mSinhVienList;
    private LayoutInflater inflater;

    public SinhVienAdapter(Context context, ArrayList<SinhVien> sinhVienList) {
        mContext = context;
        mSinhVienList = sinhVienList;
        inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mSinhVienList.size();
    }

    @Override
    public Object getItem(int position) {
        return mSinhVienList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView == null){
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_sinh_vien, null);
            holder.tvName = convertView.findViewById(R.id.tv_Name);
            holder.tvPhone = convertView.findViewById(R.id.tv_Phone);
            holder.tvAddress = convertView.findViewById(R.id.tv_Address);
            convertView.setTag(holder);
        }else
            holder = (ViewHolder)convertView.getTag();
            SinhVien sv = mSinhVienList.get(position);
            holder.tvName.setText(sv.getName());
            holder.tvPhone.setText(sv.getPhone());
            holder.tvAddress.setText(sv.getAddress());
        return convertView;
    }
    public static class ViewHolder{
        private TextView tvName, tvPhone, tvAddress;
    }
}
