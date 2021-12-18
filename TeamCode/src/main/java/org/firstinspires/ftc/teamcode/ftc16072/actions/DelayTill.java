package org.firstinspires.ftc.teamcode.ftc16072.actions;

import com.acmerobotics.roadrunner.geometry.Pose2d;

import org.firstinspires.ftc.teamcode.ftc16072.opModes.QQ_Opmode;

public class DelayTill extends QQ_Action {
    Object args;
    boolean flag = true;
    double time;


    public DelayTill(double seconds) {
        args = seconds;
    }


    @Override
    public QQ_Action run(QQ_Opmode opmode) {
        if (flag) {
            time = opmode.time;
            flag = false;
        }

        if (time + (double) args <= opmode.time) {
            return this.nextAction;
        } else {
            return this;
        }

    }
}
