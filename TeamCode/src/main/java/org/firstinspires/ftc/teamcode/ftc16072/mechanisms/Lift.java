package org.firstinspires.ftc.teamcode.ftc16072.mechanisms;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
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
public class Lift extends QQ_Mechanism {
    private DcMotorEx liftMotor;
    private Servo liftServoLeft;
    private Servo liftServoRight;
    private DigitalChannel bottomSensor;
    public static PIDFCoefficients coeff = new PIDFCoefficients(5, 0, 0, 0);
    public static double vlv1 = 0.27;
    public static double vlv2 = 0.25;
    public static double vlv3 = 0.2;
    public static double vintake = .75;
    public static double vPass = .725;
    public static int intake = 200;
    public static int pass = 1200;
    public static int lv1 = 100; //3+ inches from ground
    public static int lv2 = 900; //8.5+ inches from ground
    public static int lv3 = 1750; //14.75+ inches from ground, 1750 is highest value
    public static State state = State.INTAKE;
    private State waitingState = State.LVL3;
    private double waitingTime = 0;

    public enum State {
        INTAKE,
        PASS,
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
        liftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        liftServoLeft = hwMap.get(Servo.class, "leftServo");
        liftServoRight = hwMap.get(Servo.class, "rightServo");
        //liftMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
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
                new DualTest("v4b", new Test_Servo("Left", liftServoLeft, vintake, vlv3), new Test_Servo("Right", liftServoRight, vlv1, vlv2))
        );
    }

    public void setState(State state, double time) {
        if (state == State.LVL3 || state == State.LVL2 || state == State.LVL1) {
            if (this.state == State.INTAKE) {
                System.out.println("QQ -- intake to HI");
                this.state = State.PASS;
                this.waitingState = state;
                this.waitingTime = time;
            } else {
                this.state = state;
            }
        } else if (state == State.INTAKE) {
            if (this.state == State.LVL3 || this.state == State.LVL2 || this.state == State.LVL1) {
                System.out.println("QQ -- Hi to Intake");
                this.state = State.PASS;
                this.waitingState = state;
                this.waitingTime = time;
            } else {
                this.state = state;
            }
        } else {
            this.state = state;
        }
        liftMotor.setPIDFCoefficients(DcMotor.RunMode.RUN_TO_POSITION, coeff);
        liftMotor.setTargetPosition(liftPosition());
        liftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        liftMotor.setPower(1);

        //v4b servos
        liftServoLeft.setPosition(servoPosition());
        liftServoRight.setPosition(servoPosition());

    }


    public void update(double time) {
        //motor stuff

        System.out.println("QQ -- " + state);

        if ((state == State.PASS) && (time >= this.waitingTime + 1)) {
            System.out.println("QQ -- Set state to new state");
            state = waitingState;
        }

    }

    public int liftPosition() {
        switch (state) {
            case INTAKE:
                return intake;
            case LVL1:
                return lv1;
            case LVL2:
                return lv2;
            case LVL3:
                return lv3;
            case PASS:
                return pass;

        }
        return lv3;
    }

    public double servoPosition() {
        switch (state) {
            case INTAKE:
                return vintake;
            case LVL1:
                return vlv1;
            case LVL2:
                return vlv2;
            case LVL3:
                return vlv3;
            case PASS:
                return vPass;

        }
        return vlv3;
    }


}
