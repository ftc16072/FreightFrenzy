package org.firstinspires.ftc.teamcode.ftc16072.mechanisms;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.tests.QQ_Test;
import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.tests.Test_Motor;
import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.tests.Test_Servo;

import java.util.Arrays;
import java.util.List;

@Config
public class Lift extends QQ_Mechanism {
    private DcMotorEx liftMotor;
    private Servo v4b;
    private DigitalChannel bottomSensor;
    public static PIDFCoefficients coeff = new PIDFCoefficients(5, 0, 0, 0);
    public static double vlv1 = 0.27;
    public static double vlv2 = 0.25;
    public static double vlv3 = 0.2;
    public static double vmax = 0.5;
    public static double vintake = .75;
    public static int intake = 200;
    public static int out = 1750;
    public static int max = 2000;
    public State state = State.INTAKE;

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
        liftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        v4b = hwMap.get(Servo.class, "v4b");
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
                new Test_Servo("v4b", v4b, vintake, vlv3)
        );
    }

    public void setState(State state) {
        this.state = state;
        liftMotor.setPIDFCoefficients(DcMotor.RunMode.RUN_TO_POSITION, coeff);
        liftMotor.setTargetPosition(liftPosition());
        liftMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        liftMotor.setPower(1);

        //v4b servo
        v4b.setPosition(servoPosition());

    }


    public void update(double time) {
        //motor stuff
        if(liftMotor.getPower() > 0 && !extendable()){
            liftMotor.setPower(0);
        }
        if(liftMotor.getPower() <0 && !retractable()){
            liftMotor.setPower(0);
        }

        System.out.println("QQ -- " + state);

    }

    public int liftPosition() {
        switch (state) {
            case INTAKE:
                return intake;
            case LVL1:
            case LVL2:
            case LVL3:
            default:
                return out;
        }

    }
    public void extend(double speed){
        if(speed < 0){
            retract(speed);
        } else {
            liftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            if (extendable()) {
                liftMotor.setPower(speed);
            }
        }
    }

    public void retract(double speed){
        if(speed > 0){
            extend(speed);
        } else {
            liftMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            if(retractable()){
                liftMotor.setPower(speed);
            }
        }
    }

    public void extendV4b(){
        v4b.setPosition(vlv1);
    }

    public void up(double amountBy){
        v4b.setPosition(Math.min(v4b.getPosition() + amountBy,vmax));
    }

    public void down(double amountBy){
        v4b.setPosition(Math.max(v4b.getPosition() - amountBy, vintake));
    }

    public void stop(){
        liftMotor.setPower(0);
    }

    private boolean extendable(){
        return liftMotor.getCurrentPosition() < max;
    }
    private boolean retractable(){
        return liftMotor.getCurrentPosition() > 0;
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
            default:
                return vlv3;
        }
    }


}
