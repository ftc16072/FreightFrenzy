package org.firstinspires.ftc.teamcode.ftc16072.opModes;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.ftc16072.actions.DelayTill;
import org.firstinspires.ftc.teamcode.ftc16072.actions.DriveCM;
import org.firstinspires.ftc.teamcode.ftc16072.actions.DropCube;
import org.firstinspires.ftc.teamcode.ftc16072.actions.DualAction;
import org.firstinspires.ftc.teamcode.ftc16072.actions.DuckSpin;
import org.firstinspires.ftc.teamcode.ftc16072.actions.GoToSelectedLevel;

public class DuckAutoBlue extends QQWebcamAuto{
    @Override
    public void start() {
        super.start();
        curr = //driving to and spinning duck
                new DriveCM(-27, DistanceUnit.INCH)
                .setNext(new DuckSpin(true))
                .setNext(new DelayTill(4))
                .setNext(new DuckSpin(false))
                        //preloaded element
        .setNext(new DualAction("drive and move lift to the right height", new DriveCM(48, DistanceUnit.INCH), new GoToSelectedLevel()))
                .setNext(new DropCube(true))
                .setNext(new DelayTill(.25))
                .setNext(new DropCube(false))
        //parking in shipping hub
                .setNext(new DriveCM(-48,DistanceUnit.INCH))

        ;

    }
}
