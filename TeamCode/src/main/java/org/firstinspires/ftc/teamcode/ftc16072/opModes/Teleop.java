package org.firstinspires.ftc.teamcode.ftc16072.opModes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.Intake;
import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.Lift;
import org.firstinspires.ftc.teamcode.ftc16072.pipelines.HubDetection;
import org.firstinspires.ftc.teamcode.ftc16072.pipelines.internalFreight;

@TeleOp
public class Teleop extends QQ_Opmode {
    org.firstinspires.ftc.teamcode.ftc16072.pipelines.internalFreight internalFreight = new internalFreight();
    HubDetection hubDetection = new HubDetection();

    @Override
    public void init() {
        super.init();

        robot.frontCamera.stopStreaming();
        //robot.internalCamera.setPipeline(internalFreight);
        //robot.frontCamera.setPipeline(hubDetection);
    }


    @Override
    public void loop() {
        //super.loop();
        //checkBinds();
        updateGamepads();

        if (gp1.leftTrigger.pushedIn(.2)){
            robot.nav.drivePower(-gp1.leftTrigger.getValue(), -gp1.leftTrigger.getValue());
        } else if (gp1.rightTrigger.pushedIn(.2)){
            robot.nav.drivePower(gp1.rightTrigger.getValue(), gp1.rightTrigger.getValue());
        } else {
            robot.nav.arcadeDrive(gp1.leftStick.location.getX(DistanceUnit.CM), gp1.leftStick.location.getY(DistanceUnit.CM));
        }



        if (gp2.lBumper.isPressed() || gp2.rBumper.isPressed()) {
            robot.intake.outtake(Intake.Which.BOTH);
        } else {
            if (gp1.lBumper.isPressed() || gp1.rBumper.isPressed()) {
                robot.intake.intake(Intake.Which.BOTH);
            } else {
                robot.intake.off(Intake.Which.BOTH);
            }
        }

        if (gp1.cross.isPressed()) {
            robot.lift.setState(Lift.State.INTAKE);
        } else if (gp1.triangle.isNewlyPressed()) {
            robot.lift.setState(Lift.State.LVL3);
        } else if (gp1.square.isNewlyPressed()) {
            robot.lift.extendV4b();
        } else {
            if (gp1.dpad.up.isPressed()) {
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
        telemetry.addData("lift position", robot.lift.getLiftPosition());


    }
}
