package org.firstinspires.ftc.teamcode.ftc16072.opModes;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.ftc16072.actions.LiftState;
import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.Lift;

@Config
@TeleOp
public class LiftTuning extends QQ_Opmode {
    public static Lift.State spot = Lift.State.INTAKE;

    @Override
    public void loop() {
        robot.lift.setState(spot);
    }
}
