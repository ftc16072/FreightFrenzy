package org.firstinspires.ftc.teamcode.ftc16072.actions;


import org.firstinspires.ftc.teamcode.ftc16072.opModes.QQ_Opmode;

public class DuckSpin extends QQ_Action {
    boolean spin;

    public DuckSpin(boolean spin) {
        this.spin = spin;
    }

    @Override
    public QQ_Action run(QQ_Opmode opmode) {
        if (spin) {
            opmode.robot.duck.spin(QQ_Opmode.redAlliance);
        } else {
            opmode.robot.duck.stopSpin();
        }
        return this.nextAction;
    }

}
