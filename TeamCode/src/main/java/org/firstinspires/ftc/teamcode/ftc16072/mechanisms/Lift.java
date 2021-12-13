package org.firstinspires.ftc.teamcode.ftc16072.mechanisms;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.control.PIDCoefficients;
import com.acmerobotics.roadrunner.control.PIDFController;
import com.acmerobotics.roadrunner.profile.MotionProfile;
import com.acmerobotics.roadrunner.profile.MotionProfileGenerator;
import com.acmerobotics.roadrunner.profile.MotionState;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorController;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.tests.DualTest;
import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.tests.QQ_Test;
import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.tests.Test_Motor;
import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.tests.Test_Servo;

import java.util.Arrays;
import java.util.List;

@Config
class Lift extends QQ_Mechanism {
    private DcMotorEx liftMotor;
    private Servo liftServoLeft;
    private Servo liftServoRight;
    private DigitalChannel bottomSensor;
    public static PIDFCoefficients coeff = new PIDFCoefficients(1, 0, 0, 0);
    public static double MAX_VELO = 40;
    public static double MAX_ACCL = 20;
    public static double MAX_JERK = 0;
    private double start = 0;
    public static double OUT = 0;
    public static double IN = 0;
    State state = State.INTAKE;

    public enum State {
        INTAKE,
        LVL1,
        LVL2,
        LVL3
    }


    /**
     * Initalize the lift with the hardwareMap
     *
     * @param hwMap forces the init to take a hardware map
     */
    @Override
    public void init(HardwareMap hwMap) {
        liftMotor = hwMap.get(DcMotorEx.class, "Lift");
        liftServoLeft = hwMap.get(Servo.class, "leftServo");
        liftServoRight = hwMap.get(Servo.class, "rightServo");

        liftMotor.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }

    /**
     * @return returns the tests for the mechanism
     */
    @Override
    public List<QQ_Test> getTests() {
        return Arrays.asList(
                new Test_Motor("Lift-Up", liftMotor, 0.2),
                new Test_Motor("Lift-down", liftMotor, -0.2),
                new DualTest("v4b", new Test_Servo("Left", liftServoLeft, OUT, IN), new Test_Servo("Right", liftServoRight, OUT, IN))
        );
    }

    public void setState(State state, double time) {
        this.state = state;

    }

    public void update(double time) {
        liftMotor.setPIDFCoefficients(DcMotor.RunMode.RUN_TO_POSITION, coeff);
    }


}
