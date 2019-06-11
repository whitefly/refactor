public class chapter6_8_replace_method_with_method_object {

    int show(int inputVal, int quantity, int yearToDate) {
        int value1 = (inputVal * quantity) + delta();
        int value2 = (inputVal * yearToDate) + 100;
        if ((yearToDate - value1) > 100) {
            value2 -= 20;
        }
        int value3 = value2 * 7;
        return value3 - 2 * value1;
    }

    static int delta() {
        return 10;
    }


    //------------重构难点,局部变量太多,抽取函数时需要传入很多参数--
    //----------重构思入: 将这个局部变量都保存在内部类中,在内部类中提取出函数

    class Show {
        private final chapter6_8_replace_method_with_method_object source;
        private int inputVal;
        private int quantity;
        private int yearToDate;

        private int value1;
        private int value2;
        private int value3;

        //构造委托类,将原函数的参数传递进来


        public Show(chapter6_8_replace_method_with_method_object source, int inputVal, int quantity, int yearToDate) {
            this.source = source;
            this.inputVal = inputVal;
            this.quantity = quantity;
            this.yearToDate = yearToDate;
        }

        int compute() {
            value1 = (inputVal * quantity) + chapter6_8_replace_method_with_method_object.delta();
            value2 = (inputVal * yearToDate) + 100;
            someStep();
            value3 = value2 * 7;
            return value3 - 2 * value1;
        }

        private void someStep() {
            if ((yearToDate - value1) > 100) {
                value2 -= 20;
            }
        }
    }

    //重构为委托函数
    int newShow(int inputVal, int quantity, int yearToDate) {
        return new Show(this, inputVal, quantity, yearToDate).compute();
    }


}
