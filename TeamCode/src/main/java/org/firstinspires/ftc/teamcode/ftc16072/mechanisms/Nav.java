package org.firstinspires.ftc.teamcode.ftc16072.mechanisms;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.ftc16072.opModes.QQ_Opmode;
import org.firstinspires.ftc.teamcode.ftc16072.utils.AutoUI;

import java.util.List;

public class Nav {
    Robot robot;
    double maxSpeed = .5;

    Nav(Robot robot) {
        this.robot = robot;
    }

    public void arcadeDrive(double rotateSpeed, double throttle) {
        double left = -throttle + rotateSpeed;
        double right = -throttle - rotateSpeed;
        drivePower(left, right);

    }

    public void driveArc(double theta, double r) {
        System.out.println("QQ************");
        theta = AngleUnit.normalizeRadians(theta + Math.PI / 2);
        System.out.println("QQ theta , r" + theta + ", " + r);
        double diff = theta - robot.driveTrain.getHeading(AngleUnit.RADIANS);
        diff = AngleUnit.normalizeRadians(diff);
        double factor = Range.scale(Math.abs(diff), 0, Math.PI, -1, 1);
        System.out.println("QQ fact:" + factor +" : "+ r * factor);


        if (diff >= 0) {
            drivePower(r/2, (r * factor)/2);
        } else {
            drivePower((r * factor)/2, r/2);
        }

    }

    public boolean turnTo(double angle, AngleUnit au){

        if (!robot.driveTrain.tankDrive.isBusy()) {
            robot.driveTrain.tankDrive.turnAsync(au.toRadians(angle));
        }
        return !robot.driveTrain.tankDrive.isBusy();
    }

    public void setStartPose(Pose2d pose2d) {
        robot.driveTrain.tankDrive.setPoseEstimate(pose2d);
    }

    public boolean driveCM(double distance) {
        List<Double> currentDistance = robot.driveTrain.tankDrive.getWheelPositions();
        double leftDistance = DistanceUnit.INCH.toCm(currentDistance.get(0));
        double rightDistance = DistanceUnit.INCH.toCm(currentDistance.get(1));
        drivePower(distance - leftDistance * .2, distance - rightDistance * .2);
        double avgDistance = leftDistance + rightDistance / 2;
        System.out.println("QQ -- " + avgDistance);
        return Math.abs(avgDistance) >= Math.abs(distance) - 2 && (Math.signum(avgDistance) == Math.signum(distance));
    }

    public void drivePower(double leftSpeed, double rightSpeed){
        robot.driveTrain.drive(leftSpeed, rightSpeed);
    }





}
