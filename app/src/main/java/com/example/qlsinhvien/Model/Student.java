package com.example.qlsinhvien.Model;

public class Student {
    int id;
    String fullname;
    String mssv;
    String email;
    String birthday;

    public Student(int id, String fullname, String mssv, String email, String birthday) {
        this.id = id;
        this.fullname = fullname;
        this.mssv = mssv;
        this.email = email;
        this.birthday = birthday;
    }
    public Student() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
