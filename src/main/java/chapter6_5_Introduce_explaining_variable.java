public class chapter6_5_Introduce_explaining_variable {
    int quantity;
    double itemPrice;

    double price() {
        //长串计算式的含义: 总价=基础价格-折扣+运费
        return quantity * itemPrice - Math.max(0, quantity - 500) * itemPrice * 0.05 + Math.min(quantity * itemPrice * 0.1, 100.0);
    }


    //-----------重构1理由: 长串式子不方便看,直接写注释才知道运算关系,所以引入解释性变量-------
    double refactorPrice() {
        final double basePrice = quantity * itemPrice;
        final double discount = Math.max(0, quantity - 500) * itemPrice * 0.05;
        final double shipping = Math.min(basePrice * 0.1, 100.0);
        return basePrice - discount + shipping;
    }

    //-----------重构2理由:可以用查询函数来代替上面的引入临时变量---------
    double refactorPrice2() {
        return getbasePrice() - getDiscount() + getShipping();
    }

    private double getShipping() {
        return Math.min(getbasePrice() * 0.1, 100.0);
    }

    private double getDiscount() {
        return Math.max(0, quantity - 500) * itemPrice * 0.05;
    }

    private double getbasePrice() {
        return quantity * itemPrice;
    }


}
