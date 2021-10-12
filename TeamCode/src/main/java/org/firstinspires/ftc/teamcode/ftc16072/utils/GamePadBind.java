package org.firstinspires.ftc.teamcode.ftc16072.utils;

import org.firstinspires.ftc.teamcode.ftc16072.actions.QQ_Action;
import org.firstinspires.ftc.teamcode.ftc16072.opModes.QQ_Opmode;

public class GamePadBind {
    QQ_GamepadInput input;
    QQ_Action action;
    public GamePadBind(QQ_GamepadInput input, QQ_Action action){
        this.input = input;
        this.action = action;
    }

    public void run(QQ_Opmode opmode){
        if(input.state()){
            action = action.run(opmode);
        }
    }
}
