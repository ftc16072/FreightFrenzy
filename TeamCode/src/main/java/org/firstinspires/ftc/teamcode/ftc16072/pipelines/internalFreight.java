package org.firstinspires.ftc.teamcode.ftc16072.pipelines;

import com.acmerobotics.dashboard.config.Config;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;

@Config
public class internalFreight extends OpenCvPipeline {
    public static int low1 = 0;
    public static int low2 = 0;
    public static int low3 = 0;
    public static int high1 = 255;
    public static int high2 = 255;
    public static int high3 = 255;
    public static Scalar lower = new Scalar(low1, low2, low3);
    public static Scalar upper = new Scalar(high1, high2, high3);

    public static Rect ROI = new Rect(20, 80, 300, 80);

    public static ColorSpace colorSpace = ColorSpace.YCrCb;


    private Mat colorSchemeMat = new Mat();
    private Mat binaryMat = new Mat();
    private Mat maskedInputMat = new Mat();


    @Override
    public Mat processFrame(Mat input) {
        lower = new Scalar(low1, low2, low3);
        upper = new Scalar(high1, high2, high3);
        Imgproc.cvtColor(input, colorSchemeMat, colorSpace.cvtCode);
        Mat intrest = colorSchemeMat.submat(ROI);
        Core.inRange(colorSchemeMat, lower, upper, binaryMat);
        maskedInputMat.release();
        Core.bitwise_and(colorSchemeMat, colorSchemeMat, maskedInputMat, binaryMat);
        Imgproc.rectangle(maskedInputMat, ROI, new Scalar(255, 255, 255), 3);
        return maskedInputMat;
    }

    /**
     * This enum allows us to not use a ugly switch statement
     */
    enum ColorSpace {
        /*
         * Define our "conversion codes" in the enum so that we don't have to do a
         * switch statement in the processFrame method.
         */
        RGB(Imgproc.COLOR_RGBA2RGB), HSV(Imgproc.COLOR_RGB2HSV), YCrCb(Imgproc.COLOR_RGB2YCrCb),
        Lab(Imgproc.COLOR_RGB2Lab);

        // store cvtCode in a public var
        public int cvtCode = 0;

        // constructor to be used by enum declarations above
        ColorSpace(int cvtCode) {
            this.cvtCode = cvtCode;
        }
    }


}
