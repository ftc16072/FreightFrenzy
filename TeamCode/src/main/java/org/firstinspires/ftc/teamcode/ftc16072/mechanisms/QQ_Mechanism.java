package org.firstinspires.ftc.teamcode.ftc16072.mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.tests.QQ_Test;

import java.util.List;

public abstract class QQ_Mechanism {


    public abstract void init(HardwareMap hwMap);

    public abstract List<QQ_Test> getTests();


    public String toString() {
        return this.getClass().getName();
    }
}
