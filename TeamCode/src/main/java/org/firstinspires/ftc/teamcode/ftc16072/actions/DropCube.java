package org.firstinspires.ftc.teamcode.ftc16072.actions;

import org.firstinspires.ftc.teamcode.ftc16072.opModes.QQ_Opmode;

public class DropCube extends QQ_Action{
    boolean open;

    public DropCube(boolean open) {
        this.open = open;
    }

    @Override
    public QQ_Action run(QQ_Opmode opmode) {
        opmode.robot.box.open(open);
        return this.nextAction;
    }
}
