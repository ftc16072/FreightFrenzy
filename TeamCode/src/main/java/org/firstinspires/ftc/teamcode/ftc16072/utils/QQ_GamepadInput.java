package org.firstinspires.ftc.teamcode.ftc16072.utils;

abstract public class QQ_GamepadInput {
    Condition condition;
    double[] args;

    public void setCondition(Condition condition, double[] args) {
        this.condition = condition;
        this.args = args;
    }

    public enum Condition{
        PUSHED,
        NEWPUSHED,
        RELEASED,
        NEWRELEASED,
        PAST,
        ANGLE
    }
    abstract boolean state();

    abstract double value();
}
