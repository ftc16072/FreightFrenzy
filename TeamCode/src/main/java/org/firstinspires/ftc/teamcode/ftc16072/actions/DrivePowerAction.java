package org.firstinspires.ftc.teamcode.ftc16072.actions;

import org.firstinspires.ftc.teamcode.ftc16072.opModes.QQ_Opmode;

public class DrivePowerAction extends QQ_Action {
    double left;
    double right;

    public DrivePowerAction(double left, double right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public QQ_Action run(QQ_Opmode opmode) {
        opmode.robot.driveTrain.drive(left, right);
        return this.nextAction;
    }
}
