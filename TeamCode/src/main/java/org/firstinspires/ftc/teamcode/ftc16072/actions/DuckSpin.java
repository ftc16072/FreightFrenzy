package org.firstinspires.ftc.teamcode.ftc16072.actions;


import org.firstinspires.ftc.teamcode.ftc16072.opModes.QQ_Opmode;
import org.firstinspires.ftc.teamcode.ftc16072.utils.AutoUI;

public class DuckSpin extends QQ_Action {
    boolean spin;

    public DuckSpin(boolean spin) {
        this.spin = spin;
    }

    @Override
    public QQ_Action run(QQ_Opmode opmode) {
        if (spin) {
            opmode.robot.duck.spin(QQ_Opmode.alliance == AutoUI.Alliance.RED);
        } else {
            opmode.robot.duck.stopSpin();
        }
        return this.nextAction;
    }

}
