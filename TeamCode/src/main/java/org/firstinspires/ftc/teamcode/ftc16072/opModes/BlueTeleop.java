package org.firstinspires.ftc.teamcode.ftc16072.opModes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.ftc16072.actions.DriveAction;
import org.firstinspires.ftc.teamcode.ftc16072.actions.SetLeftPower;
import org.firstinspires.ftc.teamcode.ftc16072.actions.SetRightPower;
import org.firstinspires.ftc.teamcode.ftc16072.actions.TurnTo;
import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.Intake;
import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.Lift;
import org.firstinspires.ftc.teamcode.ftc16072.utils.AutoUI;
import org.firstinspires.ftc.teamcode.ftc16072.utils.GamePadBind;
import org.firstinspires.ftc.teamcode.ftc16072.utils.PassingBind;
import org.firstinspires.ftc.teamcode.ftc16072.utils.QQ_Gamepad;

import java.util.Arrays;
import java.util.List;

@TeleOp
public class BlueTeleop extends QQ_Opmode {


    @Override
    public void init() {
        super.init();
    }


    @Override
    public void loop() {
        super.loop();
        //checkBinds();
/*
        if (gp1.leftTrigger.pushedIn(.2)){
            robot.nav.drivePower(gp1.leftTrigger.getValue(), gp1.leftTrigger.getValue());
        } else if (gp1.rightTrigger.pushedIn(.2)){
            robot.nav.drivePower(-gp1.rightTrigger.getValue(), -gp1.rightTrigger.getValue());
        } else {
            robot.nav.arcadeDrive(gp1.leftStick.location.getX(DistanceUnit.CM), gp1.leftStick.location.getY(DistanceUnit.CM));
        }

        if(gp1.lBumper.isPressed()){
            robot.intake.intake(Intake.Which.LEFT);
        } else {
            robot.intake.off(Intake.Which.LEFT);
        }

        if(gp1.rBumper.isPressed()){
            robot.intake.intake(Intake.Which.RIGHT);
        } else {
            robot.intake.off(Intake.Which.RIGHT);
        }


        if (gp1.cross.isPressed()) {
            robot.lift.setState(Lift.State.INTAKE);
        }  else if (gp1.triangle.isNewlyPressed()) {
            robot.lift.setState(Lift.State.LVL3);
        } else if (gp1.square.isNewlyPressed()){
            robot.lift.extendV4b();
        }  else {
            if (gp1.dpad.up.isPressed()){
                robot.lift.extend(.5);
            } else if (gp1.dpad.down.isPressed()){
                robot.lift.retract(-.5);
            }
            if(gp1.dpad.left.isNewlyPressed()){
                robot.lift.up(.1);
            } else if (gp1.dpad.right.isNewlyPressed()){
                robot.lift.down(.1);
            }
        }

        robot.box.open(gp1.circle.isPressed());

        //code for ducks
        if(gp2.cross.isPressed()){
            robot.duck.spin(true); //both spin for either alliance
        } else {
            robot.duck.stopSpin();
        }

        /*
        if (gp1.square.isPressed()) {
            robot.duck.release(true);
            robot.duck.spin(alliance == AutoUI.Alliance.RED);
        } else {
            robot.duck.stopSpin();
            robot.duck.release(false);
        } * /   // THIS SHOULD BE COMMENTED OUT!!!
*/


    }
}
