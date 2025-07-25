package com.training.demo.dto;

public class RequestDto {
    private String fieldA;     // Ad
    private int fieldB;        // Yaş
    private boolean fieldC;    // Aktiflik

    public String getFieldA() {
        return fieldA;
    }

    public void setFieldA(String fieldA) {
        this.fieldA = fieldA;
    }

    public int getFieldB() {
        return fieldB;
    }

    public void setFieldB(int fieldB) {
        this.fieldB = fieldB;
    }

    public boolean isFieldC() {
        return fieldC;
    }

    public void setFieldC(boolean fieldC) {
        this.fieldC = fieldC;
    }
}