package org.firstinspires.ftc.teamcode.ftc16072.actions;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.ftc16072.opModes.QQ_Opmode;

public class TurnTo extends PassedValueAction{
    AngleUnit au;

    public TurnTo(AngleUnit au) {
        this.au = au;
    }

    @Override
    public QQ_Action run(QQ_Opmode opmode, double[] value) {

        boolean done = opmode.robot.nav.turnTo(value[0], au);
        if(done){
            return this.nextAction;
        } else {
            return this;
        }

    }
}
