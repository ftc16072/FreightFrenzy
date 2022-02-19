package org.firstinspires.ftc.teamcode.ftc16072.opModes;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.ftc16072.actions.DelayTill;
import org.firstinspires.ftc.teamcode.ftc16072.actions.DriveCM;
import org.firstinspires.ftc.teamcode.ftc16072.actions.DropCube;
import org.firstinspires.ftc.teamcode.ftc16072.actions.DualAction;
import org.firstinspires.ftc.teamcode.ftc16072.actions.DuckSpin;
import org.firstinspires.ftc.teamcode.ftc16072.actions.GoToSelectedLevel;
import org.firstinspires.ftc.teamcode.ftc16072.actions.Intake;
import org.firstinspires.ftc.teamcode.ftc16072.actions.LiftState;
import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.Lift;

public class CycleAutoBlue extends QQWebcamAuto{
    @Override
    public void start() {
        super.start();
        curr = //preloaded freight
                new DualAction("drive and move lift to the right height", new DriveCM(-24, DistanceUnit.INCH), new GoToSelectedLevel())
                .setNext(new DropCube(true))
                .setNext(new DelayTill(.25))
                .setNext(new DropCube(false))

                //cycle 1
                .setNext(new DualAction("drive back to warehouse to pick up freight", new DriveCM(48, DistanceUnit.INCH), new LiftState(Lift.State.INTAKE)))
                .setNext(new Intake(true, false))
                //vision code
                .setNext(new DualAction("drive back and deposit freight", new DriveCM(-48,DistanceUnit.INCH),new LiftState(Lift.State.LVL3)))
                .setNext(new DropCube(true))
                .setNext(new DelayTill(.25))
                .setNext(new DropCube(false))

                //cycle2
                .setNext(new DualAction("drive back to warehouse to pick up freight", new DriveCM(48, DistanceUnit.INCH), new LiftState(Lift.State.INTAKE)))
                .setNext(new Intake(true, false))
                //vision code
                .setNext(new DualAction("drive back and deposit freight", new DriveCM(-48,DistanceUnit.INCH),new LiftState(Lift.State.LVL3)))
                .setNext(new DropCube(true))
                .setNext(new DelayTill(.25))
                .setNext(new DropCube(false))

                //park
                .setNext(new DualAction("drive back to warehouse to park", new DriveCM(48, DistanceUnit.INCH), new LiftState(Lift.State.INTAKE)))

        ;

    }
}
