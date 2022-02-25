package org.firstinspires.ftc.teamcode.FTC16072.mechanisms;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.FTC16072.tests.QQTest;
import org.firstinspires.ftc.teamcode.FTC16072.tests.TestMotor;

import java.util.Arrays;
import java.util.List;

public class Intake extends Mechanism{
    DcMotor motor;
    String motorName;
    String description;
    boolean reverse;

    public Intake(String motorName, String description, boolean reverse){
        this.motorName = motorName;
        this.description = description;
        this.reverse = reverse;
    }

    public void init(HardwareMap hwMap){
        motor = hwMap.dcMotor.get(motorName);
    }

    @Override
    public List<QQTest> getTests() {
        double testSpeed = 0.4;
        if(reverse){
            testSpeed = -testSpeed;
        }
        return Arrays.asList(
                new TestMotor(motor, motorName, testSpeed)
        );
    }
    private void setSpeed(double speed){
        if(reverse){
            motor.setPower(-speed);
        }
        else{
            motor.setPower(speed);
        }
    }
    public void start(){
        setSpeed(0.7);
    }
    public void stop(){
        setSpeed(0.0);
    }

    public String toString() {
        return this.description;
    }
}
