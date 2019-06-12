package MoveBetweenObject;

public class chapter7_2_Move_Field {
    class AccountType {
    }

    class Account {
        AccountType type;
        private double interestRate;

        public double getInterestRate() {
            return interestRate;
        }

        public void setInterestRate(double interestRate) {
            this.interestRate = interestRate;
        }

        double interestOfDays(int days) {
            return interestRate * days;
        }
    }
}


//-----------重构中所面临的问题: field的初始赋值get和set,  field在原类中的使用
class Two {
    class AccountType {
        private double interestRate;

        public double getInterestRate() {
            return interestRate;
        }

        public void setInterestRate(double interestRate) {
            this.interestRate = interestRate;
        }
    }

    class Account {
        AccountType type;

        // get和set直接变为委托函数
        public double getInterestRate() {
            return type.getInterestRate();
        }

        public void setInterestRate(double interestRate) {
            type.setInterestRate(interestRate);
        }


        double interestOfDays(int days) {
            //直接调用改为实例的get方法调用
            return getInterestRate() * days;
        }
    }
}
