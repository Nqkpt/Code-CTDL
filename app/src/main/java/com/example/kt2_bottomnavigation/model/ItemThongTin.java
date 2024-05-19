package com.example.kt2_bottomnavigation.model;
import java.io.Serializable;

public class ItemThongTin implements Serializable {
    private String ten;
    private String thongTin;
    private int imageResource;

    public ItemThongTin() {
    }

    public ItemThongTin(String ten, String thongTin, int imageResource) {
        this.ten = ten;
        this.thongTin = thongTin;
        this.imageResource = imageResource;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getThongTin() {
        return thongTin;
    }

    public void setThongTin(String thongTin) {
        this.thongTin = thongTin;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }
}