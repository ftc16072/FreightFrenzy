package org.firstinspires.ftc.teamcode.ftc16072.opModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.teamcode.ftc16072.actions.QQ_Action;
import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.Robot;

public abstract class QQ_Opmode extends OpMode {
    public Robot robot = new Robot();
    protected QQ_Action curr;


    @Override
    public void init() {
        robot.init(hardwareMap);
    }

    @Override
    public void loop() {
        if (curr != null) {
            telemetry.addData("State", curr);
            curr.run(this);
        } else {
            telemetry.addData("State", "Done");
        }
    }
}
