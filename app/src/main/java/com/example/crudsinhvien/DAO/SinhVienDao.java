package com.example.crudsinhvien.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.crudsinhvien.SQLite.DBHepper;
import com.example.crudsinhvien.model.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienDao {
    private SQLiteDatabase db;

    public SinhVienDao(Context context) {
        DBHepper dbHepper = new DBHepper(context);
        db = dbHepper.getWritableDatabase();
    }

    @SuppressLint("Range")
    public List<SinhVien> getSinhvien(String sql, String ... selectArgs) {
        List<SinhVien> sinhViens = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, selectArgs );
        while (cursor.moveToNext()) {
            SinhVien sinhVien = new SinhVien();
            sinhVien.setId(cursor.getString(cursor.getColumnIndex("id")));
            sinhVien.setName(cursor.getString(cursor.getColumnIndex("name")));
            sinhVien.setLop(cursor.getString(cursor.getColumnIndex("lop")));
            sinhViens.add(sinhVien);
        }
        return  sinhViens;
    }
    public  List<SinhVien> getAll(){
        String sql ="select * from SinhVien";
        List<SinhVien> sinhViens = getSinhvien(sql);
        return  sinhViens;

    }
    public SinhVien getSinhVienByid(String id){
        String sql =" Select * from SinhVien where id=?";
        List<SinhVien> list = getSinhvien(sql,id);
        return  list.get(0);
    }
    public  long insert(SinhVien sv){
        ContentValues   values = new ContentValues();
        values.put("id",sv.getId() );
        values.put("name",sv.getName());
        values.put("lop",sv.getLop());
        return db.insert("SinhVien",null,values);
    }
    public  long update(SinhVien sv){
        ContentValues   values = new ContentValues();
        values.put("id",sv.getId() );
        values.put("name",sv.getName());
        values.put("lop",sv.getLop());
        return  db.update("SinhVien",  values, "id=?", new String[]{sv.getId()});

    }
    public  int delete(String id){
        return  db.delete("SinhVien","id=?",new String[]{id});
    }
}
