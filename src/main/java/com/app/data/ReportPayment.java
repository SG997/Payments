package com.app.data;

public class ReportPayment {

    double amount;
    String payingFor;
    long timestamp;
    String processId;
    PaymentMethod paymentMethod;

    public ReportPayment(double amount, String payingFor, long timestamp, String processId, PaymentMethod paymentMethod) {
        this.amount = amount;
        this.payingFor = payingFor;
        this.timestamp = timestamp;
        this.processId = processId;
        this.paymentMethod = paymentMethod;
    }



    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
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
