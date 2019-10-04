package com.smsui.smsui.model;

public class Address {


    private Integer aid;
    private String description;

    public Address() {
    }

    public Address(String description) {
        this.description = description;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}