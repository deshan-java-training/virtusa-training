package com.smsui.smsui.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Telephone {

    private Integer tid;
    private String tel_no;

    private Student student;

    public Telephone() {
    }

    public Telephone(Integer tid, String tel_no) {
        this.tid = tid;
        this.tel_no = tel_no;
    }

    public Telephone(String tel_no) {
        this.tel_no = tel_no;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Integer  getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTel_no() {
        return tel_no;
    }

    public void setTel_no(String tel_no) {
        this.tel_no = tel_no;
    }
}
