package org.firstinspires.ftc.teamcode.ftc16072.opModes;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.ftc16072.actions.DelayTill;
import org.firstinspires.ftc.teamcode.ftc16072.actions.DriveCM;
import org.firstinspires.ftc.teamcode.ftc16072.actions.DuckSpin;

public class AutoRed extends QQWebcamAuto{
    @Override
    public void start() {
        super.start();
        curr = new DriveCM(27, DistanceUnit.INCH)
        .setNext(new DuckSpin(true))
        .setNext(new DelayTill(4))
        .setNext(new DuckSpin(false))

        ;
    }
}
