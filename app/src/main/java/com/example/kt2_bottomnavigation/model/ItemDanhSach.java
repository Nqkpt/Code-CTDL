package com.example.kt2_bottomnavigation.model;

import java.io.Serializable;

public class ItemDanhSach implements Serializable {
    private int id;
    private String lichTrinh;
    private String thoiGian;
    private boolean phuongTienXeMay;
    private boolean phuongTienOTo;
    private boolean phuongTienMayBay;
    private String ngayKhoiHanh;
    private double tongTien;

       public ItemDanhSach() {
    }

    public ItemDanhSach(int id, String lichTrinh, String thoiGian, boolean phuongTienXeMay, boolean phuongTienOTo, boolean phuongTienMayBay, String ngayKhoiHanh, double tongTien) {
        this.id = id;
        this.lichTrinh = lichTrinh;
        this.thoiGian = thoiGian;
        this.phuongTienXeMay = phuongTienXeMay;
        this.phuongTienOTo = phuongTienOTo;
        this.phuongTienMayBay = phuongTienMayBay;
        this.ngayKhoiHanh = ngayKhoiHanh;
        this.tongTien = tongTien;
    }

    public ItemDanhSach(String lichTrinh, String thoiGian, boolean phuongTienXeMay, boolean phuongTienOTo, boolean phuongTienMayBay, String ngayKhoiHanh, double tongTien) {
        this.lichTrinh = lichTrinh;
        this.thoiGian = thoiGian;
        this.phuongTienXeMay = phuongTienXeMay;
        this.phuongTienOTo = phuongTienOTo;
        this.phuongTienMayBay = phuongTienMayBay;
        this.ngayKhoiHanh = ngayKhoiHanh;
        this.tongTien = tongTien;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLichTrinh() {
        return lichTrinh;
    }

    public void setLichTrinh(String lichTrinh) {
        this.lichTrinh = lichTrinh;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public boolean isPhuongTienXeMay() {
        return phuongTienXeMay;
    }

    public void setPhuongTienXeMay(boolean phuongTienXeMay) {
        this.phuongTienXeMay = phuongTienXeMay;
    }

    public boolean isPhuongTienOTo() {
        return phuongTienOTo;
    }

    public void setPhuongTienOTo(boolean phuongTienOTo) {
        this.phuongTienOTo = phuongTienOTo;
    }

    public boolean isPhuongTienMayBay() {
        return phuongTienMayBay;
    }

    public void setPhuongTienMayBay(boolean phuongTienMayBay) {
        this.phuongTienMayBay = phuongTienMayBay;
    }




    public String getNgayKhoiHanh() {
        return ngayKhoiHanh;
    }

    public void setNgayKhoiHanh(String ngayKhoiHanh) {
        this.ngayKhoiHanh = ngayKhoiHanh;
    }

    public double getTongTien() {
        return tongTien;
    }

    public void setTongTien(double tongTien) {
        this.tongTien = tongTien;
    }
}
