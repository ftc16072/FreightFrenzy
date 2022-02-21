package org.firstinspires.ftc.teamcode.ftc16072.opModes;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;

import org.firstinspires.ftc.teamcode.ftc16072.pipelines.CubeDetectionPipeline;
import org.firstinspires.ftc.teamcode.ftc16072.pipelines.DuckLocationRed;
import org.firstinspires.ftc.teamcode.ftc16072.pipelines.GreenRectangle;
import org.firstinspires.ftc.teamcode.ftc16072.pipelines.LineDetection;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvPipeline;
import org.openftc.easyopencv.OpenCvWebcam;

import java.util.Arrays;
import java.util.List;

/**
 * This class is used to run our pipelines
 */
@TeleOp()
@Disabled
public class PipelineRunner extends QQ_Opmode {
    GreenRectangle greenRectangle = new GreenRectangle();
    LineDetection lineDetection = new LineDetection();
    CubeDetectionPipeline cubeDetectionPipeline = new CubeDetectionPipeline(telemetry);
    DuckLocationRed duckLocationRed = new DuckLocationRed(telemetry);
    List<OpenCvPipeline> pipelines = Arrays.asList(
            lineDetection,
            greenRectangle,
            cubeDetectionPipeline,
            duckLocationRed
    );
    private int currentPipeline;
    OpenCvWebcam webcam;

    @Override
    public void init() {
        super.init();
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        webcam = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "Webcam 1"), cameraMonitorViewId);

        webcam.setPipeline(pipelines.get(currentPipeline));

        webcam.setMillisecondsPermissionTimeout(2500); // Timeout for obtaining permission is configurable. Set before opening.
        webcam.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener() {
            @Override
            public void onOpened() {
                webcam.startStreaming(320, 240, OpenCvCameraRotation.UPRIGHT);
            }

            @Override
            public void onError(int errorCode) {
                /*
                 * This will be called if the camera could not be opened
                 */
            }
        });
    }

    @Override
    public void loop() {
        super.loop();
        if (gp1.dpad.up.isNewlyPressed() || gp2.dpad.up.isNewlyPressed()) {
            currentPipeline = updatePosition(currentPipeline + 1, pipelines.size());
        } else if (gp1.dpad.down.isNewlyPressed() || gp2.dpad.down.isNewlyPressed()) {
            currentPipeline = updatePosition(currentPipeline - 1, pipelines.size());
        }
        telemetry.addData("Pipeline", pipelines.get(currentPipeline).getClass().getSimpleName());
        webcam.setPipeline(pipelines.get(currentPipeline));
    }
}
