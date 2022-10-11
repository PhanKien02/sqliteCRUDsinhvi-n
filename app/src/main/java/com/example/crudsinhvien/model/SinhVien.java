package com.example.crudsinhvien.model;


public class SinhVien {
    String id, name;
    String lop;

    public SinhVien() {
    }

    public SinhVien(String id, String name, String lop) {
        this.id = id;
        this.name = name;
        this.lop = lop;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }
}
