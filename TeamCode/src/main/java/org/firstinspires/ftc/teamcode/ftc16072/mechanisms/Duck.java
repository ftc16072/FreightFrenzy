package org.firstinspires.ftc.teamcode.ftc16072.mechanisms;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.tests.QQ_Test;
import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.tests.Test_Motor;
import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.tests.Test_Servo;

import java.util.Arrays;
import java.util.List;

@Config
public class Duck extends QQ_Mechanism {
    CRServo duckServoLeft;
    CRServo duckServoRight;


    /**
     * forces the mechanism to have an init
     *
     * @param hwMap forces the init to take a hardware map
     */
    @Override
    public void init(HardwareMap hwMap) {
        duckServoLeft = hwMap.get(CRServo.class,"duck_Left");
        duckServoRight = hwMap.get(CRServo.class,"duck_Right");
    }

    /**
     * forces the mechanism to have a getTests();
     *
     * @return returns the tests for the mechanism
     */
    @Override
    public List<QQ_Test> getTests() {
        return Arrays.asList(
                new Test_Servo("duck_Left", (Servo) duckServoLeft, 1,0),
                new Test_Servo("duck_Right", (Servo) duckServoRight, 1, 0)
        );
    }

    @Override
    public void update(double time) {

    }

    /*public void release(boolean position) {
        //true = open, false = closed
        if (position) {
            release.setPosition(this.OPEN);
        } else {
            release.setPosition(this.CLOSE);
        }
    }*/

    public void spin(boolean redAlliance) {

            duckServoLeft.setPower(-1);

            duckServoRight.setPower(1);

    }

    public void stopSpin() {
        duckServoLeft.setPower(0);
        duckServoRight.setPower(0);
    }


}
