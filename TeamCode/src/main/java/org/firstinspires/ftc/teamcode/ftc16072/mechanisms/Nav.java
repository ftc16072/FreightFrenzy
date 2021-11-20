package org.firstinspires.ftc.teamcode.ftc16072.mechanisms;

import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;

public class Nav {
    Robot robot;

    Nav(Robot robot) {
        this.robot = robot;
    }

    public void driveArc(double theta, double r) {
        double diff = theta - robot.driveTrain.getHeading(AngleUnit.RADIANS);
        diff = AngleUnit.normalizeRadians(diff);
        double factor = Range.scale(Math.abs(diff), 0, Math.PI, 1, -1);

        if (diff >= 0) {
            robot.driveTrain.drive(r, r * factor);
        } else {
            robot.driveTrain.drive(r * factor, r);
        }
    }

    public boolean turnTo(double angle, AngleUnit au){

        if(!robot.driveTrain.tankDrive.isBusy()){
            robot.driveTrain.tankDrive.turnAsync(au.toRadians(angle));
        }
        return !robot.driveTrain.tankDrive.isBusy();
    }

}
