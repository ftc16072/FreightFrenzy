package org.firstinspires.ftc.teamcode.ftc16072.utils;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class QQ_Joystick extends QQ_GamepadInput{
    public Polar location;
    public QQ_Button push;

    QQ_Joystick() {
        push = new QQ_Button();
    }


    public void update(double x, double y, boolean pressed) {
        location = new Polar(x, y, DistanceUnit.CM);
        push.update(pressed);
    }

    public boolean pushedOut(double distance) {
        return location.r >= distance;
    }

    public boolean within(double angle1, double angle2){
        double loc;
        if((int) angle1 == angle1 || ( (int) angle2) == angle2){
            loc = location.getTheta(AngleUnit.DEGREES);
            angle1 = AngleUnit.normalizeDegrees(angle1);
            angle2 = AngleUnit.normalizeDegrees(angle2);
        } else {
            loc = location.getTheta(AngleUnit.RADIANS);
            angle1 = AngleUnit.normalizeRadians(angle1);
            angle2 = AngleUnit.normalizeRadians(angle2);
        }

        if(angle1 < angle2){
            return angle1 <= loc && angle2 >= loc;
        } else if(angle1 > angle2){
            return angle1 <= loc || angle2 >= loc;
        } else {
            return false;
        }

    }

    @Override
    boolean state() {
        switch (condition){
            case PUSHED:
                return push.isPressed();
            case NEWPUSHED:
                return push.isNewlyPressed();
            case RELEASED:
                return push.isReleased();
            case NEWRELEASED:
                return push.isNewlyReleased();
            case PAST:
                return pushedOut(args[0]);
            case ANGLE:
                return within(args[0], args[1]);
            default:
                return false;
        }
    }

    double[] value() {
        double[] values = new double[4];
        values[0] = location.getTheta(AngleUnit.RADIANS);
        values[1] = location.getR(DistanceUnit.CM);
        values[2] = location.getX(DistanceUnit.CM);
        values[3] = location.getY(DistanceUnit.CM);
        return values;
    }
}
