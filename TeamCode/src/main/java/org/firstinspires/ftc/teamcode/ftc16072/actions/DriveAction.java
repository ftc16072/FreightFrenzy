package org.firstinspires.ftc.teamcode.ftc16072.actions;

import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.Robot;
import org.firstinspires.ftc.teamcode.ftc16072.opModes.QQ_Opmode;

public class DriveAction extends PassedValueAction {
    @Override
    public QQ_Action run(QQ_Opmode opmode, double[] value) {
        if (opmode.robot.controlScheme == Robot.ControlScheme.FRARCADE) {
            opmode.robot.nav.driveArc(value[0], value[1]);
        }

        return this;
    }
}
