package org.firstinspires.ftc.teamcode.FTC16072.mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcontroller.external.samples.HardwarePushbot;
import org.firstinspires.ftc.teamcode.FTC16072.tests.QQTest;

import java.util.List;

abstract public class Mechanism {
    public abstract void init(HardwareMap hwMap);
    public abstract List<QQTest> getTests();

    public String toString() {
        return this.getClass().getName();
    }

}
