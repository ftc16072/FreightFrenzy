package org.firstinspires.ftc.teamcode.ftc16072.mechanisms;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

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
        robot.driveTrain.drive(left, right);

    }

    public boolean driveCM(double distance) {
        double[] currentDistance = robot.driveTrain.getWheelPositions(DistanceUnit.CM);
        double leftDistance = (currentDistance[0] + currentDistance[1] / 2);
        double rightDistance = (currentDistance[2] + currentDistance[3] / 2);
        robot.driveTrain.drive(distance - leftDistance * .2, distance - rightDistance * .2);
        return currentDistance[4] >= distance - 2;
    }

}
