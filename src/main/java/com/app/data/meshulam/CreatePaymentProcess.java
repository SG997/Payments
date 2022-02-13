package com.app.data.meshulam;

public class CreatePaymentProcess {

    int status;
    //Err err;
    Data data;

    public CreatePaymentProcess() {

    }

    public CreatePaymentProcess(int status, Err err, Data data) {
        this.status = status;
        //this.err = err;
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    /*public String getErr() {
        return err;
    }

    public void setErr(String string) {
        this.err = string;
    }*/

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
