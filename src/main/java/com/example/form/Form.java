package com.example.form;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.io.Serializable;


public class Form implements Serializable {
    String name, surname, site, address;
    int phone;

    public Form(String name, String surname,int phone, String site, String address){
        this.name = name;
        this.surname = surname;
        this.site = site;
        this.address = address;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

//    public static final Creator<Form> CREATOR = new Creator<Form>() { //получени данных из parcel
//        @Override
//        public Form createFromParcel(Parcel source) {
//            String name = source.readString();
//            String surname = source.readString();
//            int phone = source.readInt();
//            String site = source.readString();
//            String address = source.readString();
//            return new Form(name, surname,phone,site,address)   ;
//        }
//        @Override
//        public Form[] newArray(int size) {
//            return new Form[size];
//        }
//    };
//
//    @Override
//    public int describeContents() {
//        return 0;
//    }
//
//    @Override
//    public void writeToParcel(@NonNull Parcel parcel, int i) { //пишет в объект parcel содержимое user
//        parcel.writeString(name);
//        parcel.writeString(surname);
//        parcel.writeInt(phone);
//        parcel.writeString(site);
//        parcel.writeString(address);
//    }
}
