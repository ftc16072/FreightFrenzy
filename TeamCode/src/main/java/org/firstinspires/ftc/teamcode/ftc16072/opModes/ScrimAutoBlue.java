package org.firstinspires.ftc.teamcode.ftc16072.opModes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.ftc16072.actions.DelayTill;
import org.firstinspires.ftc.teamcode.ftc16072.actions.DrivePowerAction;
import org.firstinspires.ftc.teamcode.ftc16072.actions.DuckSpin;
@Disabled
@Autonomous(group = "01")
public class ScrimAutoBlue extends QQ_Opmode {

    @Override
    public void init() {
        super.init();
        redAlliance = false;
        /*
        curr = new DuckRelease(true)
                .setNext(new DuckSpin(true))
                .setNext(new DelayTill(8))
                .setNext(new DuckSpin(false))
                .setNext(new DrivePowerAction(1, -1))
                .setNext(new DelayTill(1))
                .setNext(new DrivePowerAction(0, 0))
        ;
         **/

    }
}
