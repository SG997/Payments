package com.app.data;

import com.app.marketing.DealsType;

public class RequestUrlForPaymentData {

    double sum;
    PaymentMethod paymentMethod;
    DealsType dealType;

    public RequestUrlForPaymentData(double sum, PaymentMethod paymentMethod, DealsType dealType) {
        this.sum = sum;
        this.paymentMethod = paymentMethod;
        this.dealType = dealType;
    }


    public DealsType getDealType() {
        return dealType;
    }

    public void setDealType(DealsType dealType) {
        this.dealType = dealType;
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
