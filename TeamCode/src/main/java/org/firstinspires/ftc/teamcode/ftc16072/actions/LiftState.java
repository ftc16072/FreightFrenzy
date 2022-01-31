package org.firstinspires.ftc.teamcode.ftc16072.actions;

import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.Lift;
import org.firstinspires.ftc.teamcode.ftc16072.opModes.QQ_Opmode;

public class LiftState extends QQ_Action {
    Lift.State state;

    public LiftState(Lift.State state) {
        this.state = state;
    }

    @Override
    public QQ_Action run(QQ_Opmode opmode) {
        opmode.robot.lift.setState(state);
        return this.nextAction;
    }
}
