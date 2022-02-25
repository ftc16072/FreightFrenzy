package org.firstinspires.ftc.teamcode.FTC16072.mechanisms;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.teamcode.FTC16072.tests.QQTest;
import org.firstinspires.ftc.teamcode.FTC16072.tests.TestCRServo;

import java.util.Arrays;
import java.util.List;

public class DuckSpinner extends Mechanism{
    CRServo servo;
    String servoName;
    String description;

    //TODO:needs a reverse 
    public DuckSpinner(String servoName, String description){
        this.servoName = servoName;
        this.description = description;
    }
    @Override
    public void init(HardwareMap hwMap) {
        servo = hwMap.get(CRServo.class, servoName);
    }

    @Override
    public List<QQTest> getTests() {
        return Arrays.asList(
                new TestCRServo(servo, description, 0.3)
        );
    }
}
