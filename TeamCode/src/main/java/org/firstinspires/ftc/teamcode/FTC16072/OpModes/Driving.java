package org.firstinspires.ftc.teamcode.FTC16072.OpModes;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.FTC16072.Robot;

@TeleOp()
public class Driving extends OpMode {
    Robot robot = new Robot();

    @Override
    public void init() {
        robot.init(hardwareMap);
    }

    @Override
    public void loop() {
        if(gamepad1.right_bumper){
            robot.frontIntake.start();
        }else{
            robot.frontIntake.stop();
        }
        if(gamepad1.left_bumper){
            robot.backIntake.start();
        }else{
            robot.backIntake.stop();
        }
        if(gamepad1.a){
            robot.frontDuckSpinner.start();
            robot.backDuckSpinner.start();
        }else{
            robot.frontDuckSpinner.stop();
            robot.backDuckSpinner.stop();
        }
        if(gamepad1.b){
            robot.box.open();
        }else{
            robot.box.close();
        }


    }
}
