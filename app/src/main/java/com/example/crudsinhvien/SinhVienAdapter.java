package com.example.crudsinhvien;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.crudsinhvien.model.SinhVien;

import java.util.List;

public class SinhVienAdapter extends BaseAdapter {
    private Context context;
    private List<SinhVien> sinhViens;

    public SinhVienAdapter(Context context, List<SinhVien> sinhViens) {
        this.context = context;
        this.sinhViens = sinhViens;
    }

    @Override
    public int getCount() {
        return sinhViens.size();
    }

    @Override
    public Object getItem(int position) {
        return sinhViens.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView== null){
            convertView = LayoutInflater.from(context).inflate(R.layout.activity_item,null);
        }
        TextView tvmsv = convertView.findViewById(R.id.tv_item_msv);
        TextView tvten = convertView.findViewById(R.id.tv_item_ten);
        TextView tvlop = convertView.findViewById(R.id.tv_item_lop);
        SinhVien sinhVien = sinhViens.get(position);
        tvmsv.setText(""+sinhVien.getId());
        tvten.setText(""+sinhVien.getName());
        tvlop.setText(""+sinhVien.getLop());
        return convertView;
    }
}
