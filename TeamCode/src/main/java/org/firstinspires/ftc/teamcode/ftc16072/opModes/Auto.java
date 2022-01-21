package org.firstinspires.ftc.teamcode.ftc16072.opModes;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.ftc16072.actions.DelayTill;
import org.firstinspires.ftc.teamcode.ftc16072.actions.DriveCM;
import org.firstinspires.ftc.teamcode.ftc16072.actions.DropCube;
import org.firstinspires.ftc.teamcode.ftc16072.actions.DualAction;
import org.firstinspires.ftc.teamcode.ftc16072.actions.DuckSpin;
import org.firstinspires.ftc.teamcode.ftc16072.actions.DuckStrat;
import org.firstinspires.ftc.teamcode.ftc16072.actions.GoToSelectedLevel;
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
    QQ_Action duckStrat;


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
        curr = new DriveCM(-24, DistanceUnit.INCH)
                .setNext(new DuckSpin(true))
                .setNext(new DualAction("drive and move lift to the right height", new DriveCM(48, DistanceUnit.INCH), new GoToSelectedLevel()))
                .setNext(new DropCube(true))
                .setNext(new DelayTill(.25))
                .setNext(new DropCube(false));
    }

    @Override
    public void init_loop() {
        barcodeLocation = duckLocation.getSlotSelected();


    }

    @Override
    public void start() {
        System.out.println("QQ -- ??");
        System.out.flush();
        telemetry.addData("step", "1");
        usesGamepad = false;

        telemetry.addData("step", "2");

    }
}
