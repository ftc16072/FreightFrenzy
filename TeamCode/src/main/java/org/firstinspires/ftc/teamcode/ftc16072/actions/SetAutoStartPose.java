package org.firstinspires.ftc.teamcode.ftc16072.actions;

import com.acmerobotics.roadrunner.geometry.Pose2d;

import org.firstinspires.ftc.teamcode.ftc16072.opModes.QQ_Opmode;
import org.firstinspires.ftc.teamcode.ftc16072.utils.AutoUI;

public class SetAutoStartPose extends QQ_Action{
    double xPos = 0;
    double yPos = 0;
    double heading = 0;


    public SetAutoStartPose(AutoUI.Alliance alliance, AutoUI.Strategy strategy){
        switch (alliance){
            case BLUE:
                yPos = 64;
                heading = -Math.PI/2;
                break;
                case RED:
            default:
                yPos = -64;
                heading = Math.PI/2;
        }
        switch (strategy){
            case DUCK:
                xPos = -34;
            case OTHER:
            default:
                xPos = 12;
        }
    }

    @Override
    public QQ_Action run(QQ_Opmode opmode) {
        SetPose pose = new SetPose(new Pose2d(xPos, yPos, heading));
        pose.run(opmode);
        return this.nextAction;
    }
}
