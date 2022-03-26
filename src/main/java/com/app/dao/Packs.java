package com.app.dao;

import com.app.marketing.DealsType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Document(collection = "Packs")
public class Packs {

    @Id
    String id;

    DealsType dealsType;
    double sum;
    String details;

    public Packs(DealsType dealsType, double sum, String details) {
        this.dealsType = dealsType;
        this.sum = sum;
        this.details = details;
    }



    public DealsType getDealsType() {
        return dealsType;
    }

    public void setDealsType(DealsType dealsType) {
        this.dealsType = dealsType;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
