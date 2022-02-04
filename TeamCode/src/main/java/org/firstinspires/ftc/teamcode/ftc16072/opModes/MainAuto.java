package org.firstinspires.ftc.teamcode.ftc16072.opModes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.ftc16072.actions.DelayTill;
import org.firstinspires.ftc.teamcode.ftc16072.actions.DriveCM;
import org.firstinspires.ftc.teamcode.ftc16072.actions.DrivePowerAction;
import org.firstinspires.ftc.teamcode.ftc16072.actions.DropCube;
import org.firstinspires.ftc.teamcode.ftc16072.actions.DuckSpin;
import org.firstinspires.ftc.teamcode.ftc16072.actions.GoToSelectedLevel;
import org.firstinspires.ftc.teamcode.ftc16072.actions.LiftState;
import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.Lift;

@Autonomous
public class MainAuto extends QQWebcamAuto {
    @Override
    public void start() {
        curr = new DropCube(false)
                .setNext(new LiftState(Lift.State.INTAKE))
                .setNext(new DriveCM(-15, DistanceUnit.CM))
                .setNext(new DuckSpin(true))
                .setNext(new DelayTill(7))
                .setNext(new DuckSpin(false))
                .setNext(new DriveCM(25, DistanceUnit.INCH))
                .setNext(new GoToSelectedLevel())
                .setNext(new DelayTill(5))
                .setNext(new DriveCM(-6, DistanceUnit.INCH))
                .setNext(new DropCube(true))
                .setNext(new DelayTill(1))
                .setNext(new DriveCM(6, DistanceUnit.INCH))
                .setNext(new DropCube(false))
                .setNext(new LiftState(Lift.State.INTAKE))
                .setNext(new DelayTill(1.5))
                .setNext(new DriveCM(40, DistanceUnit.INCH))

                /*

                        .setNext(new DrivePowerAction(0.75, 0.75))
                        .setNext(new DelayTill(1.25))
                        .setNext(new DrivePowerAction(0, 0))
                        .setNext(new LiftState(Lift.State.LVL3))
                        .setNext(new DelayTill(5))
                        .setNext(new DrivePowerAction(-.25, -.25))
                        .setNext(new DelayTill(2.5))
                        .setNext(new DrivePowerAction(0, 0))
                        .setNext(new DropCube(true))
                        .setNext(new DelayTill(1))
                        .setNext(new DrivePowerAction(.5, .5))
                        .setNext(new DelayTill(.5))
                        .setNext(new DropCube(false))
                        .setNext(new LiftState(Lift.State.INTAKE))
                        .setNext(new DelayTill(1.5))
                        .setNext(new DrivePowerAction(0, 0))

                 */
        ;
    }
}
