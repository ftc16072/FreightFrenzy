package org.firstinspires.ftc.teamcode.ftc16072.actions;


import org.firstinspires.ftc.teamcode.ftc16072.opModes.QQ_Opmode;

public class SetLeftPower extends PassedValueAction {
    @Override
    public QQ_Action run(QQ_Opmode opmode, double speed) {
        opmode.robot.driveTrain.drive(speed, opmode.robot.driveTrain.getRightSpeed());
        return this;
    }
}
