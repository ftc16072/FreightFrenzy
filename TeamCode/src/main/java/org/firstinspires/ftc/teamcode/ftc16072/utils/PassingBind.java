package org.firstinspires.ftc.teamcode.ftc16072.utils;

import org.firstinspires.ftc.teamcode.ftc16072.actions.PassedValueAction;
import org.firstinspires.ftc.teamcode.ftc16072.actions.QQ_Action;
import org.firstinspires.ftc.teamcode.ftc16072.opModes.QQ_Opmode;

public class PassingBind extends GamePadBind {
    PassedValueAction action;
    public PassingBind(QQ_GamepadInput input, PassedValueAction action) {
        super(input, action);
        this.action = action;
    }


    @Override
    public void run(QQ_Opmode opmode) {
        double[] values;
        values = input.value();
        action.run(opmode, values);
    }
}
