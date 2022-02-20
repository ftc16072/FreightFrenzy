package org.firstinspires.ftc.teamcode.ftc16072.opModes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.ftc16072.actions.DelayTill;
import org.firstinspires.ftc.teamcode.ftc16072.actions.DriveCM;
import org.firstinspires.ftc.teamcode.ftc16072.actions.DropCube;
import org.firstinspires.ftc.teamcode.ftc16072.actions.DualAction;
import org.firstinspires.ftc.teamcode.ftc16072.actions.DuckSpin;
import org.firstinspires.ftc.teamcode.ftc16072.actions.GoToSelectedLevel;
import org.firstinspires.ftc.teamcode.ftc16072.actions.LiftState;
import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.Lift;

@Autonomous
public class DuckAutoBlue extends QQWebcamAuto {
    @Override
    public void init() {
        super.init();
        redAlliance = false;
    }

    @Override
    public void start() {
        super.start();
        curr = //driving to and spinning duck
                new DriveCM(1.75, DistanceUnit.INCH)
                        .setNext(new DuckSpin(true))
                        .setNext(new DelayTill(4))
                        .setNext(new DuckSpin(false))
                        .setNext(new GoToSelectedLevel())
                        .setNext(new DriveCM(-21, DistanceUnit.INCH))
                        .setNext(new DelayTill(2))
                        .setNext(new DropCube(true))
                        .setNext(new DelayTill(1))
                        .setNext(new DriveCM(8, DistanceUnit.INCH))
                        .setNext(new LiftState(Lift.State.INTAKE))
                        .setNext(new DropCube(false))
                        .setNext(new DelayTill(.75))
                        .setNext(new DriveCM(22, DistanceUnit.INCH))
                        .setNext(new LiftState(Lift.State.LVL1))
                        .setNext(new DropCube(true))


        ;

    }
}
