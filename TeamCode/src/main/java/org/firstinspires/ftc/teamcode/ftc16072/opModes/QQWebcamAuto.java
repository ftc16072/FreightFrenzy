package org.firstinspires.ftc.teamcode.ftc16072.opModes;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;

import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.Lift;
import org.firstinspires.ftc.teamcode.ftc16072.pipelines.DuckLocation;

import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvWebcam;


@Autonomous
public class QQWebcamAuto extends QQ_Opmode {
    DuckLocation duckLocation = new DuckLocation(telemetry);

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
