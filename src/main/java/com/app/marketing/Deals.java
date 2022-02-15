package com.app.marketing;


import com.app.marketing.data.DealsPack;

import static com.app.marketing.DealsType.MONTHLY;
import static com.app.marketing.DealsType.YEARLY;

public class Deals {

    /**
     * Alert !!
     * Super important, think carefully before even consider changing it
     * There are other component which might been effected by any change
     * Never change it without Sean the greatest permission
     *
     * @see MONTHLY_PACK
     * @see YEARLY_PACK
     *
     * @since There will be no mercy in this field
    */

    private static final DealsPack MONTHLY_PACK = new DealsPack(0, 1, 0);
    private static final DealsPack YEARLY_PACK = new DealsPack(0,0,1);

    final int MONTHLY_DAYS = 0;

    static public DealsPack getDays(int price){
        DealsPack dealsPack = null;
        switch (MONTHLY/*DealsType.findByValue(price)*/){
            case YEARLY:
                dealsPack = YEARLY_PACK;
                break;

            case MONTHLY:
                dealsPack = MONTHLY_PACK;
                break;

            default:
                // No match Throw exception ??

                break;
        }

        return dealsPack;
    }
}