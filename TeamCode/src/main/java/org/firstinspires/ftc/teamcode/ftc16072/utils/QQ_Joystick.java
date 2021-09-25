package org.firstinspires.ftc.teamcode.ftc16072.utils;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class QQ_Joystick {
    public Polar location;
    public QQ_Button push;


    public void update(double x, double y, boolean pressed) {
        location = new Polar(x, y, DistanceUnit.CM);
        push.update(pressed);
    }

    public boolean pushedOut(double distance) {
        return location.r >= distance;
    }

}
