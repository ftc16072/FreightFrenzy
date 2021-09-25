package org.firstinspires.ftc.teamcode.ftc16072.mechanisms.tests;

import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Test_Motor extends QQ_Test {
    DcMotor motor;
    double speed;

    /**
     * @param description A string to describe the test
     */
    public Test_Motor(String description, DcMotor motor, double speed) {
        super(description);
        this.motor = motor;
        this.speed = speed;
    }

    @Override
    public void run(boolean on, Telemetry telemetry) {
        if (on) {
            motor.setPower(speed);
            telemetry.addData("Speed", speed);
        } else {
            motor.setPower(0.0);
            telemetry.addData("Speed", 0.0);
        }
    }
}
