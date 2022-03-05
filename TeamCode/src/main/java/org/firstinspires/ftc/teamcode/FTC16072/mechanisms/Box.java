package org.firstinspires.ftc.teamcode.FTC16072.mechanisms;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.FTC16072.tests.QQTest;
import org.firstinspires.ftc.teamcode.FTC16072.tests.TestServo;

import java.util.Arrays;
import java.util.List;

//@Config
public class Box extends Mechanism{
    Servo door;
    final static double OPEN = 0.3;
    final static double CLOSED = 0.5;

    @Override
    public void init(HardwareMap hwMap) {
        door = hwMap.get(Servo.class, "door");
    }

    public void open(){
        door.setPosition(OPEN);
    }

    public void close(){
        door.setPosition(CLOSED);
    }

    @Override
    public List<QQTest> getTests() {
        return Arrays.asList(
                new TestServo(door, "door", OPEN, CLOSED)
        );
    }
}
