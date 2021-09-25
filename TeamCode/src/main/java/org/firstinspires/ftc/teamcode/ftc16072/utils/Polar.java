package org.firstinspires.ftc.teamcode.ftc16072.utils;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class Polar {
    double x;
    double y;
    double theta;
    double r;

    public Polar(double angle, AngleUnit au, double r, DistanceUnit du) {
        this.theta = au.toRadians(angle);
        this.r = du.toCm(r);
        x = r * Math.cos(theta);
        y = r * Math.sin(theta);
    }

    public Polar(double x, double y, DistanceUnit du) {
        this.x = du.toCm(x);
        this.y = du.toCm(y);
        theta = Math.atan2(y, x);
        r = Math.hypot(x, y);
    }

    public Polar getDistance(Polar otherPoint) {
        double newR = otherPoint.r - r;
        double newT = otherPoint.theta - theta;
        return new Polar(newT, AngleUnit.RADIANS, newR, DistanceUnit.CM);
    }

    public double getX(DistanceUnit du) {
        return du.fromCm(x);
    }

    public double getY(DistanceUnit du) {
        return du.fromCm(y);
    }

    public double getR(DistanceUnit du) {
        return du.fromCm(r);
    }

    public double getTheta(AngleUnit au) {
        return au.fromRadians(theta);
    }
}
