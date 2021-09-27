package org.firstinspires.ftc.teamcode.ftc16072.opModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.ftc16072.actions.QQ_Action;
import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.Robot;
import org.firstinspires.ftc.teamcode.ftc16072.utils.QQ_Gamepad;

public abstract class QQ_Opmode extends OpMode {
    public Robot robot = new Robot();
    protected QQ_Action curr;
    public QQ_Gamepad gp1 = new QQ_Gamepad(gamepad1);
    public QQ_Gamepad gp2 = new QQ_Gamepad(gamepad2);


    @Override
    public void init() {
        robot.init(hardwareMap);
        gp1.update(gamepad1);
        gp2.update(gamepad2);
    }

    @Override
    public void loop() {
        gp1.update(gamepad1);
        gp2.update(gamepad2);


        if (curr != null) {
            telemetry.addData("State", curr);
            curr.run(this);
        } else {
            telemetry.addData("State", "Done");
        }

    }
}
