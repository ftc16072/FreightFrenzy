package org.firstinspires.ftc.teamcode.ftc16072.mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.tests.QQ_Test;

import java.util.List;

public abstract class QQ_Mechanism {

    /**
     * forces the mechanism to have an init
     *
     * @param hwMap forces the init to take a hardware map
     */
    public abstract void init(HardwareMap hwMap);

    /**
     * forces the mechanism to have a getTests();
     *
     * @return returns the tests for the mechanism
     */
    public abstract List<QQ_Test> getTests();

    /**
     * allows us to do things like println(mechanism);
     *
     * @return returns the name of the class
     */
    public String toString() {
        return this.getClass().getName();
    }
}
