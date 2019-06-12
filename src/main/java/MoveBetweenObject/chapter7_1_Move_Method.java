package MoveBetweenObject;

public class chapter7_1_Move_Method {
    class AccountType {
        int level;

        public boolean isPremium() {
            return level > 2;
        }
    }

    class Account {
        AccountType type;
        int dayOverDrawn;

        double overDraftCharge() {
            if (type.isPremium()) {
                double result = 10;
                if (dayOverDrawn > 7) result += (dayOverDrawn - 7) * 0.85;
                return result;
            } else {
                return dayOverDrawn * 1.75;
            }
        }

        double bankCharge() {
            double result = 4.5;
            if (dayOverDrawn > 0) result += overDraftCharge();
            return result;
        }
    }
}

class other {
    //-------------重构理由: overDraftCharge函数与AccountType类调用较密,考虑将overDraftCharge函数之间移动到AccountType类中
    class AccountType {
        int level;

        public boolean isPremium() {
            return level > 2;
        }

        double overDraftCharge(double dayOverDrawn) {
            if (isPremium()) {
                double result = 10;
                if (dayOverDrawn > 7) result += (dayOverDrawn - 7) * 0.85;
                return result;
            } else {
                return dayOverDrawn * 1.75;
            }
        }
    }


    class Account {
        AccountType type;
        int dayOverDrawn;

        double bankCharge() {
            double result = 4.5;
            if (dayOverDrawn > 0) result += type.overDraftCharge(dayOverDrawn);
            return result;
        }
    }
}
