package org.firstinspires.ftc.teamcode.ftc16072.opModes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.ftc16072.actions.DriveAction;
import org.firstinspires.ftc.teamcode.ftc16072.actions.SetLeftPower;
import org.firstinspires.ftc.teamcode.ftc16072.actions.SetRightPower;
import org.firstinspires.ftc.teamcode.ftc16072.actions.TurnTo;
import org.firstinspires.ftc.teamcode.ftc16072.utils.GamePadBind;
import org.firstinspires.ftc.teamcode.ftc16072.utils.PassingBind;
import org.firstinspires.ftc.teamcode.ftc16072.utils.QQ_Gamepad;

import java.util.Arrays;
import java.util.List;

@TeleOp
public class Teleop extends QQ_Opmode {
    @Override
    public void init() {
        super.init();
    }


    @Override
    public void loop() {
        super.loop();
        //checkBinds();
        robot.nav.arcadeDrive(gp1.rightStick.location.getX(DistanceUnit.CM), gp1.leftStick.location.getY(DistanceUnit.CM));
        if(gp1.cross.isPressed()){
            robot.intake.intake();
        } else {
            robot.intake.off();
        }



    }
}
