package org.firstinspires.ftc.teamcode.ftc16072.actions;

import org.firstinspires.ftc.teamcode.ftc16072.opModes.QQ_Opmode;

public class Intake extends QQ_Action {

    boolean on;
    boolean left;

    public Intake(boolean on, boolean left){
       this.on = on;
       this.left = left;
    }

    @Override
    public QQ_Action run(QQ_Opmode opmode) {
        if(left) {
            if (on) {
                opmode.robot.intake.intake(org.firstinspires.ftc.teamcode.ftc16072.mechanisms.Intake.Which.LEFT);
            } else {
                opmode.robot.intake.off(org.firstinspires.ftc.teamcode.ftc16072.mechanisms.Intake.Which.LEFT);
            }
        }else {
            if (on) {
                opmode.robot.intake.intake(org.firstinspires.ftc.teamcode.ftc16072.mechanisms.Intake.Which.RIGHT);
            } else {
                opmode.robot.intake.off(org.firstinspires.ftc.teamcode.ftc16072.mechanisms.Intake.Which.RIGHT);
            }
        }
        return this.nextAction;
    }
}


