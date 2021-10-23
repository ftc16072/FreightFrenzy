package org.firstinspires.ftc.teamcode.ftc16072.utils;

public class QQ_Trigger extends QQ_GamepadInput{
    double value;
    double lastValue;

    public double getValue() {
        return value;
    }

    public double getChange() {
        return lastValue - value;
    }

    public boolean changed() {
        return lastValue != value;
    }

    public boolean pushedIn(double distance) {
        return value >= distance;
    }


    public void update(double value) {
        lastValue = this.value;
        this.value = value;
    }


    public boolean state() {
        if (condition == Condition.PAST) {
            return pushedIn(args[0]);
        }
        return false;
    }

    @Override
    double[] value() {
        double[] values = new double[0];
        values[0] = value;
        return values;
    }

}
