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

    public Packs(DealsType dealsType, double sum) {
        this.dealsType = dealsType;
        this.sum = sum;
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
}
