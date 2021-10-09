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

import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.tests.QQ_Test;
import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.tests.Test_Motor;

import java.util.Arrays;
import java.util.List;

@Config
class Lift extends QQ_Mechanism {
    private DcMotorEx liftMotor;
    private DigitalChannel bottomSensor;
    public static PIDCoefficients coeff = new PIDCoefficients(1, 0, 0);
    PIDFController controller = new PIDFController(coeff, 0, 0, 0);
    public static MotionState intake = new MotionState(0, 0, 0);
    public static MotionState lvl1 = new MotionState(0, 0, 0);
    public static MotionState lvl2 = new MotionState(0, 0, 0);
    public static MotionState lvl3 = new MotionState(0, 0, 0);
    public static double MAX_VELO = 40;
    public static double MAX_ACCL = 20;
    public static double MAX_JERK = 0;
    private double start = 0;


    State state = State.INTAKE;

    MotionProfile liftProfile;

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
        /*bottomSensor = hwMap.get(DigitalChannel.class, "bottom");
        bottomSensor.setMode(DigitalChannel.Mode.INPUT);*/

        liftProfile = makeProfile();

    }

    private MotionProfile makeProfile() {
        return MotionProfileGenerator.generateSimpleMotionProfile(
                new MotionState(liftMotor.getCurrentPosition(), liftMotor.getVelocity(), 0),
                getMotionState(),
                MAX_VELO,
                MAX_ACCL,
                MAX_JERK
        );
    }

    private MotionState getMotionState() {
        switch (state) {
            case LVL1:
                return lvl1;
            case LVL2:
                return lvl2;
            case LVL3:
                return lvl3;
            case INTAKE:
            default:
                return intake;
        }
    }

    /**
     * @return returns the tests for the mechanism
     */
    @Override
    public List<QQ_Test> getTests() {
        return Arrays.asList(
                new Test_Motor("Lift-Up", liftMotor, 0.2),
                new Test_Motor("Lift-down", liftMotor, -0.2)
        );
    }

    public void setState(State state, double time) {
        this.state = state;
        liftProfile = makeProfile();
        start = time;

    }

    public void update(double time) {
        double elapsed = time - start;
        MotionState desiredState = liftProfile.get(elapsed);

        controller.setTargetPosition(desiredState.getX());
        controller.setTargetVelocity(desiredState.getV());
        controller.setTargetAcceleration(desiredState.getA());

        double correction = controller.update(liftMotor.getCurrentPosition(), liftMotor.getVelocity());

        liftMotor.setPower(correction);
    }


}
