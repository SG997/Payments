package com.app.dao;

import com.app.data.PaymentMethod;
import com.app.marketing.DealsType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Payment")
public class Payments {

    @Id
    String id;

    String from;

    String to;

    double amount;

    String time;

    PaymentMethod paymentMethod;

    DealsType dealType;

    boolean isFoundInCache;


    public Payments(String from, String to, double amount, String time, PaymentMethod paymentMethod, DealsType dealType, boolean isFoundInCache) {
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.time = time;
        this.paymentMethod = paymentMethod;
        this.dealType = dealType;
        this.isFoundInCache = isFoundInCache;
    }


    public boolean isFoundInCache() {
        return isFoundInCache;
    }

    public void setFoundInCache(boolean foundInCache) {
        isFoundInCache = foundInCache;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }


    public DealsType getDealType() {
        return dealType;
    }

    public void setDealType(DealsType dealType) {
        this.dealType = dealType;
    }
}
