package org.firstinspires.ftc.teamcode.ftc16072.pipelines;
import com.acmerobotics.dashboard.config.Config;

import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.core.Rect;
import org.opencv.core.Core;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;
import org.firstinspires.ftc.robotcore.external.Telemetry;

/**
 * This class finds the location of ducks -- useful for testing auto before we have a TSE
 *
 * uses a quick and dirty method that works becausea we know where they are every time
 */
@Config
public class DuckLocation extends OpenCvPipeline{
    Telemetry telemetry;
    public static Rect space1 = new Rect(8, 110, 50, 50);
    Mat slot1;
    public static Rect space2 = new Rect(126, 120, 50, 50);
    Mat slot2;
    public static Rect space3 = new Rect(250, 120, 50, 50);
    Mat slot3;
    int slotSelected = -1;

    /**
     * constructer to give us acces to telemetry
     * @param telemetry so that we can return values to the telelmetry for debugging
     */
    public DuckLocation(Telemetry telemetry) {
        this.telemetry = telemetry;
    }

    /**
     * allows the robot to poll the pipeline and discover whet the best slot is
     * @return an integer representing 1, 2, or 3 for the slots (-1 if not run yet or no slot best)
     */
    public int getSlotSelected(){
        return slotSelected;
    }

    /**
     * The bulk of the pipeline:
     * Color scheme -> blur
     * then we take the blurred mat and submat it into 3 rectangles where we know the spots are
     * We average the color of the submat, and compare the yellow
     * The slot with the most yellow has the duck in it
     * @param inputMat the mat to analyse from the camera
     * @return returns the modified mat to display for debugging
     */
    @Override
    public Mat processFrame(Mat inputMat) {
        Imgproc.cvtColor(inputMat, inputMat, Imgproc.COLOR_RGB2HSV);
        Imgproc.GaussianBlur(inputMat, inputMat, new Size(3, 3), 0);
        Imgproc.rectangle(inputMat, space1, new Scalar(0, 0, 255), 3);
        Imgproc.rectangle(inputMat, space2, new Scalar(0, 0, 255), 3);
        Imgproc.rectangle(inputMat, space3, new Scalar(0, 0, 255), 3);
        slot1 = inputMat.submat(space1);
        slot2 = inputMat.submat(space2);
        slot3 = inputMat.submat(space3);
        double space1Color = Core.mean(slot1).val[1];
        //telemetry.addData("Space 1", space1Color);
        double space2Color = Core.mean(slot2).val[1];
        //telemetry.addData("Space 2", space2Color);
        double space3Color = Core.mean(slot3).val[1];

        if(space1Color >= space2Color && space1Color >= space3Color){
            slotSelected = 1;
            Imgproc.rectangle(inputMat, space1, new Scalar(0, 255, 0), 3);
        } else if (space2Color >= space3Color && space2Color >= space1Color ){
            slotSelected = 2;
            Imgproc.rectangle(inputMat, space2, new Scalar(0, 255, 0), 3);
        } else if (space3Color >= space2Color){
            slotSelected = 3;
            Imgproc.rectangle(inputMat, space3, new Scalar(0, 255, 0), 3);
        }

        telemetry.addData("Selected", slotSelected);

        telemetry.update();
        return inputMat;
    }

}

