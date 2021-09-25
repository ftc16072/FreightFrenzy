package org.firstinspires.ftc.teamcode.ftc16072.mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.List;

public class Robot {
    List<QQ_Mechanism> mechanismList;


    /**
     * Automatically initializes all its mechanisms
     *
     * @param hwmap the hardware map to init the mechanisms with
     */
    public void init(HardwareMap hwmap) {
        for (QQ_Mechanism mechanism : mechanismList) {
            mechanism.init(hwmap);
        }
    }

    public List<QQ_Mechanism> getMechanismList() {
        return mechanismList;
    }
}
