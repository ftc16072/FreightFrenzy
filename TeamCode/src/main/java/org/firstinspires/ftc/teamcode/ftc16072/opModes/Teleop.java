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
        bindings = Arrays.asList(

        );
    }


    @Override
    public void loop() {
        super.loop();
        checkBinds();
        robot.nav.driveArc(gp1.leftStick.location.getTheta(AngleUnit.RADIANS), gp1.leftStick.location.getR(DistanceUnit.CM));
        robot.nav.turnTo(gp1.rightStick.location.getTheta(AngleUnit.RADIANS), AngleUnit.RADIANS);


    }
}
