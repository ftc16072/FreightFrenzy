package org.firstinspires.ftc.teamcode.FTC16072;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.FTC16072.mechanisms.Box;
import org.firstinspires.ftc.teamcode.FTC16072.mechanisms.DuckSpinner;
import org.firstinspires.ftc.teamcode.FTC16072.mechanisms.Intake;
import org.firstinspires.ftc.teamcode.FTC16072.mechanisms.Mechanism;

import java.util.Arrays;
import java.util.List;

public class Robot {
    public Intake frontIntake = new Intake("intake1", "frontIntake", false);
    public Intake backIntake = new Intake ("intake2", "backIntake", true);
    public DuckSpinner frontDuckSpinner = new DuckSpinner("duck_Right", "FrontDuck", false);
    public DuckSpinner backDuckSpinner = new DuckSpinner("duck_Left", "BackDuck", true);
    public Box box = new Box();

    List<Mechanism> mechanismList = Arrays.asList(
            frontIntake,
            backIntake,
            frontDuckSpinner,
            backDuckSpinner,
            box
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
