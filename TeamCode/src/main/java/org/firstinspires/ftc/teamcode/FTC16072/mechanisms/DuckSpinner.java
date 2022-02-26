package org.firstinspires.ftc.teamcode.FTC16072.mechanisms;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.FTC16072.tests.QQTest;
import org.firstinspires.ftc.teamcode.FTC16072.tests.TestCRServo;

import java.util.Arrays;
import java.util.List;

public class DuckSpinner extends Mechanism {
    CRServo servo;
    String servoName;
    String description;
    boolean reverse;
    
    public DuckSpinner(String servoName, String description, boolean reverse) {
        this.servoName = servoName;
        this.description = description;
        this.reverse = reverse;
    }

    private void setSpeed(double speed) {
        if (reverse) {
            servo.setPower(-speed);
        } else {
            servo.setPower(speed);
        }
    }

    public void start() {
        setSpeed(0.7);
    }

    public void stop() {
        setSpeed(0.0);
    }

    @Override
    public void init(HardwareMap hwMap) {
        servo = hwMap.get(CRServo.class, servoName);
    }

    @Override
    public List<QQTest> getTests() {
        double testSpeed = 0.3;
        if (reverse) {
            testSpeed = -testSpeed;
        }
        return Arrays.asList(
                new TestCRServo(servo, description, testSpeed)
        );
    }
}
