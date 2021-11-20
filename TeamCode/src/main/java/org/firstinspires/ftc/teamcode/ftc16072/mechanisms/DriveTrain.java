package org.firstinspires.ftc.teamcode.ftc16072.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.tests.QQ_Test;
import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.tests.Test_Motor;
import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.QQ_TankDrive;

import com.acmerobotics.roadrunner.drive.TankDrive;

import java.util.Arrays;
import java.util.List;

public class DriveTrain extends QQ_Mechanism {
    QQ_TankDrive tankDrive;

    @Override
    public void init(HardwareMap hwMap) {
        tankDrive = new QQ_TankDrive(hwMap);
        tankDrive.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
    }

    @Override
    public List<QQ_Test> getTests() {
        return Arrays.asList(
                new Test_Motor("left front", tankDrive.getMotors().get(0), 0.2),
                new Test_Motor("left rear", tankDrive.getMotors().get(1), 0.2),
                new Test_Motor("right rear", tankDrive.getMotors().get(2), 0.2),
                new Test_Motor("right front", tankDrive.getMotors().get(3), 0.2)
        );
    }

    @Override
    public void update(double time) {

    }

    public void drive(double leftSpeed, double rightSpeed) {
        tankDrive.setMotorPowers(leftSpeed, rightSpeed);
    }

    public double getLeftSpeed() {
        return tankDrive.getWheelVelocities().get(0);
    }

    public double getRightSpeed() {
        return tankDrive.getWheelVelocities().get(1);
    }

    public double getHeading(AngleUnit au) {
        return au.fromRadians(tankDrive.getExternalHeading());

    }
}
