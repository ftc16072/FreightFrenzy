package org.firstinspires.ftc.teamcode.ftc16072.actions;

import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.Lift;
import org.firstinspires.ftc.teamcode.ftc16072.opModes.QQ_Opmode;

public class GoToSelectedLevel extends QQ_Action {

    @Override
    public QQ_Action run(QQ_Opmode opmode) {
        Lift.State state;

        switch (opmode.barcodeLocation){
            case 1:
                state = Lift.State.LVL1;
                break;
            case 2:
                state = Lift.State.LVL2;
                break;
            case 3:
            default:
                state = Lift.State.LVL3;
                break;
        }

        opmode.robot.lift.setState(state);

        return this.nextAction;
    }
}
