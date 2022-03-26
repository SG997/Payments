package com.app.services;

import com.app.dao.Packs;
import com.app.marketing.DealsType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DealsService {

    public List<Packs> getAllDeals() {
        List<Packs> packs = new ArrayList<>();
        packs.add(new Packs(DealsType.MONTHLY, DealsType.MONTHLY.value, "חודשי"));
        packs.add(new Packs(DealsType.HALF_YEARLY, DealsType.HALF_YEARLY.value, "חצי שנתי"));
        packs.add(new Packs(DealsType.YEARLY, DealsType.YEARLY.value, "שנתי"));

        return packs;
    }


}
