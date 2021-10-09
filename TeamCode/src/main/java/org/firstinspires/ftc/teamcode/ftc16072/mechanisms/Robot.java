package org.firstinspires.ftc.teamcode.ftc16072.mechanisms;

import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.Arrays;
import java.util.List;

public class Robot {
    public DriveTrain driveTrain = new DriveTrain();
    List<QQ_Mechanism> mechanismList = Arrays.asList(
            //lift,
            driveTrain
    );


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

    /**
     * Get all the mechanisms that are in the robot
     *
     * @return a QQ_Mechanism for every mechanism on the robot
     */
    public List<QQ_Mechanism> getMechanismList() {
        return mechanismList;
    }


    public void update(double time) {
        for (QQ_Mechanism mechanism : mechanismList) {
            mechanism.update(time);
        }
    }
}
