package org.firstinspires.ftc.teamcode.ftc16072.opModes;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

@TeleOp()
@Disabled
public class Drive extends QQ_Opmode {
    @Override
    public void loop() {
        super.loop();
        robot.driveTrain.drive(gp1.leftStick.location.getY(DistanceUnit.CM),gp1.rightStick.location.getY(DistanceUnit.CM));
    }
}
