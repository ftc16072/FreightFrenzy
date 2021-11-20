package org.firstinspires.ftc.teamcode.ftc16072.opModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.ftc16072.actions.QQ_Action;
import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.Robot;
import org.firstinspires.ftc.teamcode.ftc16072.utils.GamePadBind;
import org.firstinspires.ftc.teamcode.ftc16072.utils.QQ_Gamepad;

import java.util.List;

public abstract class QQ_Opmode extends OpMode {
    public Robot robot = new Robot();
    protected QQ_Action curr;
    public QQ_Gamepad gp1;
    public QQ_Gamepad gp2;
    boolean usesGamepad = true;
    protected boolean initLoopConfig = false;
    List<GamePadBind> bindings;


    @Override
    public void init() {
        gp1 = new QQ_Gamepad(gamepad1);
        gp2 = new QQ_Gamepad(gamepad2);
        robot.init(hardwareMap);
        updateGamepads();
    }

    @Override
    public void init_loop() {
        super.init_loop();
        if(initLoopConfig){
            updateGamepads();
            checkBinds();
        }
    }

    @Override
    public void loop() {
        updateGamepads();
        robot.update(time);
        if (curr != null) {
            telemetry.addData("State", curr);
            curr.run(this);
        } else {
            telemetry.addData("State", "No Action");
        }

    }

    private void updateGamepads(){
        if (usesGamepad) {
            gp1.update(gamepad1);
            gp2.update(gamepad2);
        }
    }

    protected void checkBinds(){
        for (GamePadBind bind : bindings) {
            bind.run(this);
        }
    }
}
