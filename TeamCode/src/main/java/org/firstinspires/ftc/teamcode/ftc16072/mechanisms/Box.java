package org.firstinspires.ftc.teamcode.ftc16072.mechanisms;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.tests.QQ_Test;
import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.tests.Test_Servo;

import java.util.Arrays;
import java.util.List;

@Config
public class Box extends QQ_Mechanism {
    Servo door;
    public static double close = .5;
    public static double open = 0;

    /**
     * forces the mechanism to have an init
     *
     * @param hwMap forces the init to take a hardware map
     */
    @Override
    public void init(HardwareMap hwMap) {
        door = hwMap.get(Servo.class, "door");
    }

    /**
     * forces the mechanism to have a getTests();
     *
     * @return returns the tests for the mechanism
     */
    @Override
    public List<QQ_Test> getTests() {
        return Arrays.asList(
                new Test_Servo("Door", door, open, close)
        );
    }

    public void open(boolean toOpen) {
        if (toOpen) {
            door.setPosition(open);
        } else {
            door.setPosition(close);
        }
    }

    @Override
    public void update(double time) {

    }
}
