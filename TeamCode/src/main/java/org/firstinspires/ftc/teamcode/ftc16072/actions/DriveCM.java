package org.firstinspires.ftc.teamcode.ftc16072.actions;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.ftc16072.opModes.Drive;
import org.firstinspires.ftc.teamcode.ftc16072.opModes.QQ_Opmode;

public class DriveCM extends QQ_Action {
    double distanceCM;

    public DriveCM(double distance, DistanceUnit du) {
        distanceCM = du.toCm(distance);
    }


    @Override
    public QQ_Action run(QQ_Opmode opmode) {
        if (opmode.robot.nav.driveCM(distanceCM)) {
            return this.nextAction;
        }
        return this;
    }
}
