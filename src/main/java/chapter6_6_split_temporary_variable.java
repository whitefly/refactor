public class chapter6_6_split_temporary_variable {
    double primaryForce;
    double secondaryForce;
    double mass;
    int delay;

    double getDistanceTravelled(int time) {
        double result;
        double acc = primaryForce / mass;
        int primaryTime = Math.min(time, delay);
        result = 0.5 * acc * Math.pow(primaryTime, 2);
        int secondaryTime = time - delay;
        if (secondaryTime > 0) {
            double primaryVel = acc * delay;
            acc = (primaryForce + secondaryForce) / mass;
            result += primaryVel * secondaryTime + 0.5 * acc * Math.pow(secondaryTime, 2);
        }
        return result;
    }


    //-------------------重构理由: acc变量既不是循环条件变量,也不是累积收集变量,所以用相同变量赋值不合适,拆分为2个临时变量----


    double newGetDistanceTravelled(int time) {
        double result; //计算路程
        final double firstAcc = primaryForce / mass;
        int primaryTime = Math.min(time, delay);
        result = 0.5 * firstAcc * Math.pow(primaryTime, 2);

        int secondaryTime = time - delay;
        if (secondaryTime > 0) {
            double primaryVel = firstAcc * delay;
            final double secondAcc = (primaryForce + secondaryForce) / mass;
            result += primaryVel * secondaryTime + 0.5 * secondAcc * Math.pow(secondaryTime, 2);
        }
        return result;
    }


    //--------------很多临时变量,则只赋值一次,所以用查询查询来代替临时变量,并提取函数----------

    double newGetDistanceTravelled2(int time) {
        int firstTime = Math.min(time, delay);
        return getDistance(getFirstAcc(), firstTime) + secondDistance(time);
    }

    private double secondDistance(int time) {
        double result = 0;
        int secondaryTime = time - delay;
        if (secondaryTime > 0) {
            double primaryVel = getFirstAcc() * delay;
            result = primaryVel * secondaryTime + getDistance(getSecondAcc(), secondaryTime);
        }
        return result;
    }

    private double getDistance(double acc, int time) {
        return 0.5 * acc * Math.pow(time, 2);
    }

    private double getSecondAcc() {
        return (primaryForce + secondaryForce) / mass;
    }

    private double getFirstAcc() {
        return primaryForce / mass;
    }
}
