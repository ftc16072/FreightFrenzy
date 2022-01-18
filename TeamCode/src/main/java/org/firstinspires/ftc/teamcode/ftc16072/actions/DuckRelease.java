package org.firstinspires.ftc.teamcode.ftc16072.actions;


import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.Duck;
import org.firstinspires.ftc.teamcode.ftc16072.opModes.QQ_Opmode;

public class DuckRelease extends QQ_Action {
    boolean position;

    public DuckRelease(boolean position) {
        this.position = position;

    }

    @Override
    public QQ_Action run(QQ_Opmode opmode) {
       // opmode.robot.duck.release(position);
        return this.nextAction;
    }

}
