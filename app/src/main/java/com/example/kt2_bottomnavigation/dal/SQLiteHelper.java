package com.example.kt2_bottomnavigation.dal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.kt2_bottomnavigation.model.ItemDanhSach;

import java.util.ArrayList;
import java.util.List;

public class SQLiteHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "TourManager.db";
    private static final int DATABASE_VERSION = 1;

    // Tour table name
    private static final String TABLE_TOUR = "tour";

    // Tour Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_LICH_TRINH = "lich_trinh";
    private static final String KEY_THOI_GIAN = "thoi_gian";
    private static final String KEY_PHUONG_TIEN_XE_MAY = "phuong_tien_xe_may";
    private static final String KEY_PHUONG_TIEN_O_TO = "phuong_tien_o_to";
    private static final String KEY_PHUONG_TIEN_MAY_BAY = "phuong_tien_may_bay";
    private static final String KEY_NGAY_KHOI_HANH = "ngay_khoi_hanh";
    private static final String KEY_TONG_TIEN = "tong_tien";

    // Constructor
    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TOUR_TABLE = "CREATE TABLE " + TABLE_TOUR + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + KEY_LICH_TRINH + " TEXT,"
                + KEY_THOI_GIAN + " TEXT,"
                + KEY_PHUONG_TIEN_XE_MAY + " INTEGER,"
                + KEY_PHUONG_TIEN_O_TO + " INTEGER,"
                + KEY_PHUONG_TIEN_MAY_BAY + " INTEGER,"
                + KEY_NGAY_KHOI_HANH + " TEXT,"
                + KEY_TONG_TIEN + " REAL"
                + ")";
        db.execSQL(CREATE_TOUR_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TOUR);

        // Create tables again
        onCreate(db);
    }

    // Adding new Tour
    public void addTour(ItemDanhSach tour) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_LICH_TRINH, tour.getLichTrinh());
        values.put(KEY_THOI_GIAN, tour.getThoiGian());
        values.put(KEY_PHUONG_TIEN_XE_MAY, tour.isPhuongTienXeMay() ? 1 : 0);
        values.put(KEY_PHUONG_TIEN_O_TO, tour.isPhuongTienOTo() ? 1 : 0);
        values.put(KEY_PHUONG_TIEN_MAY_BAY, tour.isPhuongTienMayBay() ? 1 : 0);
        values.put(KEY_NGAY_KHOI_HANH, tour.getNgayKhoiHanh());
        values.put(KEY_TONG_TIEN, tour.getTongTien());

        // Inserting Row
        db.insert(TABLE_TOUR, null, values);
        // Closing database connection
        db.close();
    }

    // Getting All Tours
    public List<ItemDanhSach> getAllTours() {
        List<ItemDanhSach> tourList = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_TOUR;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            int idIndex = cursor.getColumnIndex(KEY_ID);
            int lichTrinhIndex = cursor.getColumnIndex(KEY_LICH_TRINH);
            int thoiGianIndex = cursor.getColumnIndex(KEY_THOI_GIAN);
            int phuongTienXeMayIndex = cursor.getColumnIndex(KEY_PHUONG_TIEN_XE_MAY);
            int phuongTienOToIndex = cursor.getColumnIndex(KEY_PHUONG_TIEN_O_TO);
            int phuongTienMayBayIndex = cursor.getColumnIndex(KEY_PHUONG_TIEN_MAY_BAY);
            int ngayKhoiHanhIndex = cursor.getColumnIndex(KEY_NGAY_KHOI_HANH);
            int tongTienIndex = cursor.getColumnIndex(KEY_TONG_TIEN);

            do {
                ItemDanhSach tour = new ItemDanhSach();

                // Kiểm tra xem cột có tồn tại không trước khi lấy giá trị
                if (idIndex != -1) {
                    tour.setId(cursor.getInt(idIndex));
                }

                if (lichTrinhIndex != -1) {
                    tour.setLichTrinh(cursor.getString(lichTrinhIndex));
                }

                if (thoiGianIndex != -1) {
                    tour.setThoiGian(cursor.getString(thoiGianIndex));
                }

                if (phuongTienXeMayIndex != -1) {
                    tour.setPhuongTienXeMay(cursor.getInt(phuongTienXeMayIndex) == 1);
                }

                if (phuongTienOToIndex != -1) {
                    tour.setPhuongTienOTo(cursor.getInt(phuongTienOToIndex) == 1);
                }

                if (phuongTienMayBayIndex != -1) {
                    tour.setPhuongTienMayBay(cursor.getInt(phuongTienMayBayIndex) == 1);
                }

                if (ngayKhoiHanhIndex != -1) {
                    tour.setNgayKhoiHanh(cursor.getString(ngayKhoiHanhIndex));
                }

                if (tongTienIndex != -1) {
                    tour.setTongTien(cursor.getDouble(tongTienIndex));
                }

                // Adding tour to list
                tourList.add(tour);
            } while (cursor.moveToNext());
        }


        // return tour list
        return tourList;
    }

    // Delete a Tour
    public void deleteTour(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_TOUR, KEY_ID + " = ?",
                new String[]{String.valueOf(id)});
        db.close();
    }
}
