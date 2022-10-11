package com.example.crudsinhvien;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Switch;

import com.example.crudsinhvien.DAO.SinhVienDao;
import com.example.crudsinhvien.SQLite.DBHepper;
import com.example.crudsinhvien.model.SinhVien;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private SinhVienAdapter sinhVienAdapter;
    private List<SinhVien> sinhViens;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHepper dbHepper = new DBHepper(this);
        dbHepper.getReadableDatabase();

        findViewById(R.id.edit).setOnClickListener(this);
        findViewById(R.id.delete).setOnClickListener(this);
        ListView listSV = findViewById(R.id.listSV);
        SinhVienDao sinhVienDao = new SinhVienDao(this);
        List<SinhVien> sinhViens = sinhVienDao.getAll();
        sinhVienAdapter = new SinhVienAdapter(this,sinhViens);
        listSV.setAdapter(sinhVienAdapter);
    }

    @Override
    public void  onClick( View view){
        switch (view.getId()){
            case R.id.edit:
                Intent intent = new Intent(this,UpdateActivity.class);
                startActivity(intent);
                break;
        }
    }
}