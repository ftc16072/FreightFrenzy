package org.firstinspires.ftc.teamcode.ftc16072.mechanisms;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.tests.QQ_Test;
import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.tests.Test_Motor;
import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.tests.Test_Servo;

import java.util.Arrays;
import java.util.List;

@Config
public class Duck extends QQ_Mechanism{
    DcMotorEx duck;
    Servo release;
    public static final double open = 0;
    public static final double close = 0;

    /**
     * forces the mechanism to have an init
     *
     * @param hwMap forces the init to take a hardware map
     */
    @Override
    public void init(HardwareMap hwMap) {
        duck = hwMap.get(DcMotorEx.class, "duck");
        release = hwMap.get(Servo.class, "release");
    }

    /**
     * forces the mechanism to have a getTests();
     *
     * @return returns the tests for the mechanism
     */
    @Override
    public List<QQ_Test> getTests() {
        return Arrays.asList(
                new Test_Motor("duck", duck, 0.2),
                new Test_Servo("release", release, open, close)
        );
    }

    @Override
    public void update(double time) {

    }
}
