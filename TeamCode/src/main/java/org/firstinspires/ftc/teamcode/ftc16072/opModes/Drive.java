package org.firstinspires.ftc.teamcode.ftc16072.opModes;

import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

public class Drive extends QQ_Opmode {
    @Override
    public void loop() {
        super.loop();
        robot.driveTrain.drive(gp1.leftStick.location.getY(DistanceUnit.CM),gp1.leftStick.location.getY(DistanceUnit.CM));
    }
}
