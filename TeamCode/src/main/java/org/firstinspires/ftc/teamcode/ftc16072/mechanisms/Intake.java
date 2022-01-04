package org.firstinspires.ftc.teamcode.ftc16072.mechanisms;


import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.tests.QQ_Test;
import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.tests.Test_Motor;

import java.util.Arrays;
import java.util.List;

public class Intake extends QQ_Mechanism {
    DcMotorEx intake1;

    DcMotorEx intake2;

    public Intake() {

    }

    /**
     * forces the mechanism to have an init
     *
     * @param hwMap forces the init to take a hardware map
     */
    @Override
    public void init(HardwareMap hwMap) {
        intake1 = hwMap.get(DcMotorEx.class, "intake1");
        intake1.setDirection(DcMotorSimple.Direction.REVERSE);
        intake2 = hwMap.get(DcMotorEx.class, "intake2");
    }

    /**
     * forces the mechanism to have a getTests();
     *
     * @return returns the tests for the mechanism
     */
    @Override
    public List<QQ_Test> getTests() {
        return Arrays.asList(
                new Test_Motor("intake1", intake1, .2),
                new Test_Motor("intake2", intake2, .2)
        );
    }

    @Override
    public void update(double time) {

    }

    public void intake() {
        intake1.setPower(0.8);
        intake2.setPower(0.8);
    }
    public void outtake() {
        intake1.setPower(-0.4);
        intake2.setPower(-0.4);
    }
    public void off() {
        intake1.setPower(0);
        intake2.setPower(0);
    }
}
