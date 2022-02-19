package org.firstinspires.ftc.teamcode.ftc16072.mechanisms;

import android.util.Log;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.ftc16072.actions.LiftState;
import org.firstinspires.ftc.teamcode.ftc16072.opModes.QQ_Opmode;
import org.firstinspires.ftc.teamcode.ftc16072.pipelines.HubDetection;
import org.openftc.easyopencv.OpenCvCameraFactory;

import java.util.Arrays;
import java.util.List;

public class Robot {

    public enum ControlScheme {
        FRARCADE,
        TANK,
        ARCADE
    }

    HubDetection hubDetection = new HubDetection();
    public Nav nav = new Nav(this);
    public ControlScheme controlScheme = ControlScheme.FRARCADE;
    public DriveTrain driveTrain = new DriveTrain();
    public Intake intake = new Intake();
    public Duck duck = new Duck();
    public Lift lift = new Lift();
    public Box box = new Box();
    public LEDS led = new LEDS();
    int[] viewportContainerIds;
    public QQWebcam frontCamera = new QQWebcam("Webcam 1");
    public QQWebcam internalCamera = new QQWebcam("Webcam 2");
    List<QQ_Mechanism> mechanismList = Arrays.asList(
            lift,
            intake,
            driveTrain,
            box,
            duck,
            frontCamera,
            internalCamera,
            led
    );


    /**
     * Automatically initializes all its mechanisms
     *
     * @param hwmap the hardware map to init the mechanisms with
     */
    public void init(HardwareMap hwmap) {
        int cameraMonitorViewId = hwmap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", hwmap.appContext.getPackageName());
        viewportContainerIds = OpenCvCameraFactory.getInstance()
                .splitLayoutForMultipleViewports(
                        cameraMonitorViewId, //The container we're splitting
                        2, //The number of sub-containers to create
                        OpenCvCameraFactory.ViewportSplitMethod.HORIZONTALLY); //Whether to split the container vertically or horizontally
        frontCamera.cameraMonitorViewId = viewportContainerIds[0];
        internalCamera.cameraMonitorViewId = viewportContainerIds[1];
        for (QQ_Mechanism mechanism : mechanismList) {

            mechanism.init(hwmap);
        }
        lift.setState(Lift.State.INTAKE);
        box.open(false);
        //frontCamera.setPipeline();
    }

    /**
     * Get all the mechanisms that are in the robot
     *
     * @return a QQ_Mechanism for every mechanism on the robot
     */
    public List<QQ_Mechanism> getMechanismList() {
        return mechanismList;
    }


    public void update(double time) {
        for (QQ_Mechanism mechanism : mechanismList) {
            mechanism.update(time);
        }

    }

    // Intake Controler


}
