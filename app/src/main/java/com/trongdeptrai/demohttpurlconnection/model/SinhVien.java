package com.trongdeptrai.demohttpurlconnection.model;

public class SinhVien {
    private String mId, mName, mPhone, mAddress;

    public SinhVien(String name, String phone, String address) {
        mName = name;
        mPhone = phone;
        mAddress = address;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

    public String getAddress() {
        return mAddress;
    }

    public void setAddress(String address) {
        mAddress = address;
    }
}
