package org.firstinspires.ftc.teamcode.ftc16072.mechanisms;


import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.tests.QQ_Test;
import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.tests.Test_Motor;

import java.util.Arrays;
import java.util.List;

public class Intake extends QQ_Mechanism {
    DcMotorEx intake;

    public Intake(){

    }
    /**
     * forces the mechanism to have an init
     *
     * @param hwMap forces the init to take a hardware map
     */
    @Override
    public void init(HardwareMap hwMap) {
        intake = hwMap.get(DcMotorEx.class, "intake");
    }

    /**
     * forces the mechanism to have a getTests();
     *
     * @return returns the tests for the mechanism
     */
    @Override
    public List<QQ_Test> getTests() {
        return Arrays.asList(
                new Test_Motor("intake", intake, .2)
        );
    }

    @Override
    public void update(double time) {

    }

    public void intake(){
        intake.setPower(0.8);
    }
    public void outtake(){
        intake.setPower(-0.4);
    }
    public void off(){
        intake.setPower(0);
    }
}
