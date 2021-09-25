package org.firstinspires.ftc.teamcode.ftc16072.mechanisms.tests;

import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class Test_Servo extends QQ_Test {
    Servo servo;
    double onLocation;
    double offLocation;

    /**
     * @param description A string to describe the test
     */
    public Test_Servo(String description, Servo servo, double onLocation, double offLocation) {
        super(description);
        this.servo = servo;
        this.onLocation = onLocation;
        this.offLocation = offLocation;
    }

    @Override
    public void run(boolean on, Telemetry telemetry) {
        if (on) {
            servo.setPosition(onLocation);
        } else {
            servo.setPosition(offLocation);
        }
    }
}
