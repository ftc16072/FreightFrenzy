package org.firstinspires.ftc.teamcode.ftc16072.opModes;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

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
    AutoUI ui;
    HashMap<String, QQUI.Options> hashMap;
    OpenCvWebcam webcam;
    DuckLocation duckLocation;
    DuckStrat duckStrat;


    @Override

    public void init() {
        System.out.println("QQ -- ???");
        System.out.flush();

        System.out.println("QQ -- THINGIES 1");
        System.out.flush();
        duckLocation = new DuckLocation(telemetry);
        System.out.println("QQ -- THINGIES 2");
        System.out.flush();
        duckStrat = new DuckStrat();
        System.out.println("QQ -- THINGIES 3");
        System.out.flush();
        super.init();
        System.out.println("QQ -- super");
        System.out.flush();
        initLoopConfig = true;
        usesGamepad = true;
        System.out.println("QQ -- variables");
        System.out.flush();
        int cameraMonitorViewId = hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hardwareMap.appContext.getPackageName());
        webcam = OpenCvCameraFactory.getInstance().createWebcam(hardwareMap.get(WebcamName.class, "Webcam 1"), cameraMonitorViewId);
        System.out.println("QQ -- camera... sus");
        System.out.flush();
        webcam.setPipeline(duckLocation);
        System.out.println("QQ -- setpipeline");
        System.out.flush();

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
        System.out.println("QQ -- open camera");

    }

    @Override
    public void init_loop() {
        barcodeLocation = duckLocation.getSlotSelected();


    }

    @Override
    public void start() {
        super.start();
        usesGamepad = false;
        curr = duckStrat

    }
}
