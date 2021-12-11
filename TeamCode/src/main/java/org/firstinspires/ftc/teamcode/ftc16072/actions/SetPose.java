package org.firstinspires.ftc.teamcode.ftc16072.actions;

import com.acmerobotics.roadrunner.geometry.Pose2d;

import org.firstinspires.ftc.teamcode.ftc16072.opModes.QQ_Opmode;

public class SetPose extends QQ_Action {
    Pose2d pose2d;
    public SetPose(Pose2d pose2d){
        this.pose2d = pose2d;
    }

    @Override
    public QQ_Action run(QQ_Opmode opmode) {
        opmode.robot.nav.setStartPose(pose2d);
        return this.nextAction;
    }
}
