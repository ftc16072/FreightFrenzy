package org.firstinspires.ftc.teamcode.ftc16072.opModes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.ftc16072.actions.DriveAction;
import org.firstinspires.ftc.teamcode.ftc16072.actions.SetLeftPower;
import org.firstinspires.ftc.teamcode.ftc16072.actions.SetRightPower;
import org.firstinspires.ftc.teamcode.ftc16072.utils.GamePadBind;
import org.firstinspires.ftc.teamcode.ftc16072.utils.PassingBind;
import org.firstinspires.ftc.teamcode.ftc16072.utils.QQ_Gamepad;

import java.util.Arrays;
import java.util.List;

@TeleOp
public class Teleop extends QQ_Opmode {
    List<GamePadBind> bindings;

    @Override
    public void init() {
        super.init();
        bindings = Arrays.asList(
                new PassingBind(gp1.leftStick, new DriveAction())
        );
    }


    @Override
    public void loop() {
        super.loop();
        for (GamePadBind bind : bindings) {
            bind.run(this);
        }

    }
}
