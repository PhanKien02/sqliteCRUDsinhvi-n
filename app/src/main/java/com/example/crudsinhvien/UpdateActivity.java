package com.example.crudsinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.crudsinhvien.DAO.SinhVienDao;
import com.example.crudsinhvien.model.SinhVien;

public class UpdateActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText etmsv,etname,etlop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        etmsv = findViewById(R.id.add_update_msv);
        etname = findViewById(R.id.add_update_tsv);
        etlop = findViewById(R.id.add_update_lop);
        findViewById(R.id.save).setOnClickListener(this);
        findViewById(R.id.viewlist).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.save:
                SinhVienDao sinhVienDao = new SinhVienDao(this);
                SinhVien sinhVien = new SinhVien();
                sinhVien.setId(etmsv.getText().toString());
                sinhVien.setName(etname.getText().toString());
                sinhVien.setLop(etlop.getText().toString());
                sinhVienDao.insert(sinhVien);
                Toast.makeText(this,"Sinh vien đã lưu",Toast.LENGTH_SHORT).show();
                break;
            case R.id.viewlist:
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
                break;
        }

    }
}