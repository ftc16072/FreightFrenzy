package org.firstinspires.ftc.teamcode.ftc16072.mechanisms;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.tests.QQ_Test;
import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.tests.Test_Motor;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class DriveTrain extends QQ_Mechanism {
    DcMotorEx leftFront;
    DcMotorEx rightFront;
    DcMotorEx leftRear;
    DcMotorEx rightRear;
    double ticksPerRotation = 6000;
    double gearRatio = 1;
    double wheelCirc = 96;
    double ticksPerMM = ticksPerRotation * gearRatio * wheelCirc;


    @Override
    public void init(HardwareMap hwMap) {
        leftFront = hwMap.get(DcMotorEx.class, "left_motor_front");
        leftRear = hwMap.get(DcMotorEx.class, "left_motor_back");
        rightRear = hwMap.get(DcMotorEx.class, "right_motor_back");
        rightFront = hwMap.get(DcMotorEx.class, "right_motor_front");
        leftFront.setDirection(DcMotorSimple.Direction.REVERSE);
        leftRear.setDirection(DcMotorSimple.Direction.REVERSE);
    }

    @Override
    public List<QQ_Test> getTests() {
        return Arrays.asList(
                new Test_Motor("left front", leftFront, 0.2),
                new Test_Motor("left rear", leftRear, 0.2),
                new Test_Motor("right rear", rightRear, 0.2),
                new Test_Motor("right front", rightFront, 0.2)
        );
    }

    @Override
    public void update(double time) {
    }

    public void drive(double leftSpeed, double rightSpeed) {
        leftFront.setPower(leftSpeed);
        leftRear.setPower(leftSpeed);
        rightFront.setPower(rightSpeed);
        rightRear.setPower(rightSpeed);
    }

    double[] getWheelPositions(DistanceUnit du){
        double[] positions = new double[5];
        positions[0] = leftFront.getCurrentPosition() * (1 / ticksPerMM);
        positions[1] = leftRear.getCurrentPosition() * (1 / ticksPerMM);
        positions[2] = rightFront.getCurrentPosition() * (1 / ticksPerMM);
        positions[3] = rightRear.getCurrentPosition() * (1 / ticksPerMM);
        positions[4] = (positions[0] + positions[1] + positions[2] + positions[3])/4;
        return positions;
    }

    public boolean isBusy(){
        return leftFront.isBusy() || leftRear.isBusy() || rightRear.isBusy() || rightFront.isBusy();
    }
}
