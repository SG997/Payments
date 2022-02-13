package com.app.data;

public class RequestUrlForPaymentData {

    double sum;
    PaymentMethod paymentMethod;
    PaymentType paymentType;

    public RequestUrlForPaymentData(double sum, PaymentMethod paymentMethod, PaymentType paymentType) {
        this.sum = sum;
        this.paymentMethod = paymentMethod;
        this.paymentType = paymentType;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
