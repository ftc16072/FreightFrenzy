package org.firstinspires.ftc.teamcode.ftc16072.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.tests.QQ_Test;
import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.tests.Test_Motor;

import java.util.Arrays;
import java.util.List;

public class DriveTrain extends QQ_Mechanism {
    DcMotorEx frontLeft;
    DcMotorEx backLeft;
    DcMotorEx frontRight;
    DcMotorEx backRight;

    @Override
    public void init(HardwareMap hwMap) {
        frontLeft = hwMap.get(DcMotorEx.class, "left_motor_front");
        backLeft = hwMap.get(DcMotorEx.class, "left_motor_back");
        frontRight = hwMap.get(DcMotorEx.class, "right_motor_front");
        backRight = hwMap.get(DcMotorEx.class, "right_motor_back");
    }

    @Override
    public List<QQ_Test> getTests() {
        return Arrays.asList(
                new Test_Motor("frontleft", frontLeft, 0.2),
                new Test_Motor("backleft", backLeft, 0.2),
                new Test_Motor("frontright", frontRight, 0.2),
                new Test_Motor("backright", backRight, 0.2)
        );
    }

    @Override
    public void update(double time) {

    }
    public void drive(double leftSpeed, double rightSpeed){
        frontLeft.setPower(leftSpeed);
        backLeft.setPower(leftSpeed);
        frontRight.setPower(rightSpeed);
        backRight.setPower(rightSpeed);
    }
}
