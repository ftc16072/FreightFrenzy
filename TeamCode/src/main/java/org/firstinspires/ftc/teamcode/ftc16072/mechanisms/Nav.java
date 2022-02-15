package org.firstinspires.ftc.teamcode.ftc16072.mechanisms;

import android.os.Debug;
import android.util.Log;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.ftc16072.actions.QQ_Action;
import org.firstinspires.ftc.teamcode.ftc16072.opModes.QQ_Opmode;

import java.util.Arrays;
import java.util.List;

public class Nav {
    Robot robot;
    double maxSpeed = .5;
    double minWindow = 100;
    double maxWindow = 200;

    Nav(Robot robot) {
        this.robot = robot;
    }

    public void arcadeDrive(double rotateSpeed, double throttle) {
        double left = -throttle + rotateSpeed;
        double right = -throttle - rotateSpeed;
        drivePower(left, right);

    }

    public void resetPosition() {
        robot.driveTrain.resetWheels();
    }

    public boolean driveCM(double distance) {
        double[] currentDistance = robot.driveTrain.getWheelPositions(DistanceUnit.CM);

        drivePower(calculateSpeed(distance, currentDistance[4]), calculateSpeed(distance, currentDistance[4]));

        boolean done = isDone(distance, currentDistance[4]);

        if (done) {
            drivePower(0, 0);
        }

        return done;
    }

    private boolean isDone(double goal, double current) {
        double toleranceLower = Math.signum(goal) * -2;
        double toleranceUpper = Math.signum(goal) * 2;

        boolean within = (Math.abs(current) >= Math.abs(goal + toleranceLower)) && (Math.abs(current) <= Math.abs(goal + toleranceUpper));

        boolean sameSign = (Math.signum(current) == Math.signum(goal));

        return within && sameSign;
    }

    private double calculateSpeed(double goal, double current) {
        double diff = goal - current;
        if (Math.signum(diff) == 1) {
            return Math.max(Math.abs(diff * .1), .3);
        } else {
            return Math.min(Math.abs(diff * .1), -.3);
        }


    }

    public void drivePower(double leftSpeed, double rightSpeed) {

        robot.driveTrain.drive(leftSpeed, rightSpeed);
    }
/*
    public boolean centerOnHub() {
        double x = 0;//robot.hubDetection.getHubLocation()[0];

        if (x <= maxWindow && x >= minWindow) {
            return true;
        } else if (x < minWindow) {
            if (QQ_Opmode.redAlliance) {
                drivePower(-.5, -.5);
            } else {
                drivePower(.5, .5);
            }
            return false;
        } else if (x > maxWindow) {
            if (QQ_Opmode.redAlliance) {
                drivePower(.5, .5);
            } else {
                drivePower(-.5, -.5);
            }
            return false;
        }

        return false;

    }

 */


}
