package com.app.data;

public class ReportPayment {

    double amount;
    String payingFor;
    long timestamp;

    public ReportPayment(double amount, String payingFor, long timestamp) {
        this.amount = amount;
        this.payingFor = payingFor;
        this.timestamp = timestamp;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPayingFor() {
        return payingFor;
    }

    public void setPayingFor(String payingFor) {
        this.payingFor = payingFor;
    }
}
