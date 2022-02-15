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
public class AutoRed extends QQWebcamAuto{
    @Override
    public void start() {
        super.start();
        curr = new DriveCM(5, DistanceUnit.INCH)
                .setNext(new DuckSpin(true))
                .setNext(new DelayTill(4))
                .setNext(new DuckSpin(false))
                .setNext(new DriveCM(-30, DistanceUnit.INCH))
                .setNext(new GoToSelectedLevel())
                .setNext(new DelayTill(2.5))
                .setNext(new DropCube(true))
                .setNext(new DelayTill(.25))
                .setNext(new DriveCM(-40, DistanceUnit.INCH))
                .setNext(new LiftState(Lift.State.INTAKE))
                .setNext(new DropCube(false))
                .setNext(new DriveCM(-40, DistanceUnit.INCH))
        ;


    }
}
