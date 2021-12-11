package org.firstinspires.ftc.teamcode.ftc16072.actions;

import com.acmerobotics.roadrunner.trajectory.Trajectory;

import org.firstinspires.ftc.teamcode.ftc16072.opModes.QQ_Opmode;

public class AutoDrive extends QQ_Action {
    Trajectory trajectory;

    AutoDrive(Trajectory traj){
        this.trajectory = traj;
    }

    @Override
    public QQ_Action run(QQ_Opmode opmode) {
        boolean done = opmode.robot.driveTrain.followAsynch(trajectory);
        if(done){
            return this.nextAction;
        }

        return this;


    }
}
