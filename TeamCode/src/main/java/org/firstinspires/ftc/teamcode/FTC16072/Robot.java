package org.firstinspires.ftc.teamcode.FTC16072;

import com.qualcomm.robotcore.hardware.HardwareMap;

import java.util.Arrays;
import java.util.List;

public class Robot {
    public Intake frontIntake = new Intake("intake1", "frontIntake", false);
    public Intake backIntake = new Intake ("intake2", "backIntake", true);

    List<Mechanism> mechanismList = Arrays.asList(
            frontIntake,
            backIntake
    );
    public void init (HardwareMap hwMap){
        for(Mechanism mechanism : mechanismList){
            mechanism.init(hwMap);
        }
    }
    public List<Mechanism> getMechanismList(){
        return mechanismList;
    }

}
