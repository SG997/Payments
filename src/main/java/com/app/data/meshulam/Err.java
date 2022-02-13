package com.app.data.meshulam;

public class Err {

    int id;
    java.lang.String message;
    java.lang.String data;

    public Err() {
    }

    public Err(int id, java.lang.String message, java.lang.String data) {
        this.id = id;
        this.message = message;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public java.lang.String getMessage() {
        return message;
    }

    public void setMessage(java.lang.String message) {
        this.message = message;
    }

    public java.lang.String getData() {
        return data;
    }

    public void setData(java.lang.String data) {
        this.data = data;
    }
}
