import java.util.ArrayList;
import java.util.List;


public class chapter6_1_Extract_Method {
    class order {
        private double Amount;

        public order(double amount) {
            Amount = amount;
        }

        public double getAmount() {
            return Amount;
        }
    }

    private List<order> orders = new ArrayList<order>();
    private String name;

    void printOwing() {
        double outstand = 0.0;

        //打印分割线
        System.out.println("***********************");
        System.out.println("****Customer Owes******");
        System.out.println("***********************");

        //计算总价格
        for (order item : orders) {
            outstand += item.getAmount();
        }

        //打印detail
        System.out.println("name:" + name);
        System.out.println("totol:" + outstand);
    }

    //-----------------------------------重构分割线-----------------------------------------

    void new_printOwing() {
        double outstand = 0.0;
        printBanner();
        outstand = computeTotalValue(outstand);
        printDetail(outstand);

    }

    private double computeTotalValue(double outstand) {
        //计算总价格(重构理由:修改了局部变量,需要将局部变量参入,然后作为返回值传出)
        for (order item : orders) {
            outstand += item.getAmount();
        }
        return outstand;
    }

    private void printDetail(double outstand) {
        //打印detail(重构理由:使用了局部变量,但没有修改局部变量,所以将局部变量作为参数即可)
        System.out.println("name:" + name);
        System.out.println("totol:" + outstand);
    }

    private void printBanner() {
        //打印分割线(重构理由:不使用局部变量,直接拆分出来)
        System.out.println("***********************");
        System.out.println("****Customer Owes******");
        System.out.println("***********************");
    }

}
