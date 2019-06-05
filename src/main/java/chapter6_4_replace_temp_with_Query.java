public class chapter6_4_replace_temp_with_Query {
    private int quantity;
    private int itemPrice;

    public chapter6_4_replace_temp_with_Query(int quantity, int itemPrice) {
        this.quantity = quantity;
        this.itemPrice = itemPrice;
    }


    double getPrice() {
        int basePrice = quantity * itemPrice;
        double discountFactor;
        if (basePrice > 1000) discountFactor = 0.95;
        else discountFactor = 0.98;
        return basePrice * discountFactor;
    }


    //---------------------------------重构分割线---------------------------------


    double getPrice2() {
        return getBasePrice() * getDiscountFactor();
    }

    private double getDiscountFactor() {
        //由于临时变量函数化,所以这里也可以使用原来的临时变量
        return getBasePrice() > 1000 ? 0.95 : 0.98;
    }

    private int getBasePrice() {
        return quantity * itemPrice;
    }

}
