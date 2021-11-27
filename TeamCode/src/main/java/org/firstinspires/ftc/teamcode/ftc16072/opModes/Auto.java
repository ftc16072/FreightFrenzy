package org.firstinspires.ftc.teamcode.ftc16072.opModes;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.ftc16072.actions.DuckStrat;
import org.firstinspires.ftc.teamcode.ftc16072.actions.QQ_Action;
import org.firstinspires.ftc.teamcode.ftc16072.actions.SetAutoStartPose;
import org.firstinspires.ftc.teamcode.ftc16072.pipelines.DuckLocation;
import org.firstinspires.ftc.teamcode.ftc16072.utils.AutoUI;
import org.firstinspires.ftc.teamcode.ftc16072.utils.QQUI;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvWebcam;

import java.util.HashMap;
import java.util.Objects;

@Autonomous
public class Auto extends QQ_Opmode {
    AutoUI ui = new AutoUI(this);
    HashMap<String, QQUI.Options> hashMap;
    OpenCvWebcam webcam;
    DuckLocation duckLocation = new DuckLocation(telemetry);
    DuckStrat duckStrat = new DuckStrat();
    QQ_Action otherStrat;


    @Override

    public void init() {
        super.init();
        initLoopConfig = true;
        usesGamepad = true;
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        webcam = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "Webcam 1"), cameraMonitorViewId);

        webcam.setPipeline(duckLocation);

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
    public void init_loop() {
        super.init_loop();
        ui.update();
        hashMap = ui.getOptionsHashMap();
        alliance = (AutoUI.Alliance) hashMap.get("Alliance");
        barcodeLocation = duckLocation.getSlotSelected();
        QQ_Action storage;
        curr.setNext(new SetAutoStartPose(alliance, (AutoUI.Strategy) hashMap.get("Strategy")));
        switch ((AutoUI.Strategy) Objects.requireNonNull(hashMap.get("Strategy"))){
            case DUCK:
                curr.setNext(duckStrat);
            case OTHER:
            default:
                curr.setNext(otherStrat);
        }



    }

    @Override
    public void start() {
        super.start();
        usesGamepad = false;

    }
}
