package org.firstinspires.ftc.teamcode.ftc16072.actions;

import com.acmerobotics.roadrunner.geometry.Pose2d;

import org.firstinspires.ftc.teamcode.ftc16072.opModes.QQ_Opmode;

public class DelayTill extends QQ_Action{
    Reason reason;
    Object args;
    boolean flag = true;
    double time;

    enum Reason{
        TIME,
        POSE
    }

    DelayTill(){
        reason = Reason.TIME;
        args = 10;
    }
    DelayTill(double milliseconds){
        reason = Reason.TIME;
        args = milliseconds;
    }
    DelayTill(Pose2d pose2d){
        this.reason = Reason.POSE;
        this.args = pose2d;
    }

    @Override
    public QQ_Action run(QQ_Opmode opmode) {
        if(flag){
            time = opmode.time;
            flag = false;
        }

        switch (reason){
            case TIME:
                if(time + (double)args >= opmode.time){
                    return this.nextAction;
                }
                break;
            case POSE:
                if(true){
                    //todo: make this check pose agains robot pose
                    return this.nextAction;
                }
                break;
            default:
                return this.nextAction;

        }
        return this;
    }
}
