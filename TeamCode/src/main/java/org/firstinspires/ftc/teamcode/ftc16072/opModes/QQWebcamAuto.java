package org.firstinspires.ftc.teamcode.ftc16072.opModes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.ftc16072.pipelines.DuckLocationBase;
import org.firstinspires.ftc.teamcode.ftc16072.pipelines.DuckLocationRed;


@Autonomous
public class QQWebcamAuto extends QQ_Opmode {
    DuckLocationBase duckLocation = new DuckLocationRed(telemetry);

    @Override
    public void init() {
        super.init();
        robot.frontCamera.setPipeline(duckLocation);
    }

    @Override
    public void init_loop() {
        super.init_loop();
        barcodeLocation = duckLocation.getSlotSelected();
    }

    @Override
    public void start() {
        super.start();
        robot.frontCamera.stopStreaming();
        barcodeLocation = duckLocation.getSlotSelected();

    }
}
