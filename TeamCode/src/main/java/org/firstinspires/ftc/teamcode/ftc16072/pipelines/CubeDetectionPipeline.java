package org.firstinspires.ftc.teamcode.ftc16072.pipelines;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.core.Rect;
import org.opencv.core.Core;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.MatOfPoint;
import org.opencv.imgproc.Imgproc;
import org.opencv.imgproc.LineSegmentDetector;
import org.openftc.easyopencv.OpenCvPipeline;
import org.firstinspires.ftc.robotcore.external.Telemetry;


import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.*;

/**
 * This pipeline finds solo cubes and bundles of cubes
 */
public class CubeDetectionPipeline extends OpenCvPipeline {
    public Scalar lower = new Scalar(0, 109, 100);
    public Scalar upper = new Scalar(19.8, 255, 255);

    Telemetry telemetry;

    public ColorSpace colorSpace = ColorSpace.HSV;

    private Mat colorSchemeMat = new Mat();
    private Mat binaryMat = new Mat();
    private Mat maskedInputMat = new Mat();

    private double directionToCube = 0.0;
    private double distanceToCube = 0.0;

    private double directionToClump = 0.0;
    private double distanceToClump=0.0;


    private List<Point> midpoints = new ArrayList<Point>();

    Mat edges = new Mat();
    Mat hierarchy = new Mat();

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

    /**
     * This constructor gives the pipeline access to the telemetry
     */
    public CubeDetectionPipeline(Telemetry telemetry) {
        this.telemetry = telemetry;
    }

    @Override
    public Mat processFrame(Mat input) {


        Imgproc.cvtColor(input, colorSchemeMat, colorSpace.cvtCode);
        Core.inRange(colorSchemeMat, lower, upper, binaryMat);
        maskedInputMat.release();
        Core.bitwise_and(input, input, maskedInputMat, binaryMat);
        Imgproc.cvtColor(maskedInputMat, maskedInputMat, Imgproc.COLOR_BGR2GRAY);
        Imgproc.GaussianBlur(maskedInputMat, maskedInputMat, new Size(3, 3), 0);

        int threshold = 100;

        Imgproc.Canny(maskedInputMat, edges, threshold, threshold*3);

        List<MatOfPoint> contours = new ArrayList<>();

        Imgproc.findContours(edges, contours, hierarchy, Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);

        MatOfPoint2f matOfPoint2f = new MatOfPoint2f();
        MatOfPoint2f approxCurve = new MatOfPoint2f();
        Rect singleCube = null;
        Rect cubeBundle = null;

        for (int idx = 0; idx >= 0; idx = (int) hierarchy.get(0, idx)[0]) {
            MatOfPoint contour = contours.get(idx);
            Rect rect = Imgproc.boundingRect(contour);
            Imgproc.rectangle(maskedInputMat, rect, new Scalar(255, 255, 255), 1);
            double contourArea = Imgproc.contourArea(contour);
            matOfPoint2f.fromList(contour.toList());
            Imgproc.approxPolyDP(matOfPoint2f, approxCurve, Imgproc.arcLength(matOfPoint2f, true) * 0.02, true);
            long total = approxCurve.total();
            if (total == 3) { // is triangle
                // do things for triangle
            }
            if (total >= 4 && total <= 7) {
                List<Double> cos = new ArrayList<>();
                Point[] points = approxCurve.toArray();
                if(singleCube == null){
                    singleCube = rect;
                } else if(rect.area() >= singleCube.area()){
                    singleCube = rect;
                }

            }else {
                if(cubeBundle==null){
                    cubeBundle = rect;
                } else if(rect.area() >= cubeBundle.area()){
                    cubeBundle = rect;
                }
            }
        }
        if(singleCube!= null){
            drawText(singleCube.tl(), "Closest Cube");
            directionToCube = singleCube.tl().x  + (singleCube.width/2) - (input.rows()/2);
            distanceToCube = input.cols() - (singleCube.tl().y + (singleCube.height/2));
            telemetry.addData("Cube", directionToCube()[0] + ", " + directionToCube()[1]);
        }
        if(cubeBundle != null){
            drawText(cubeBundle.tl(), "Cube Bundle");
            directionToClump = cubeBundle.tl().x + (cubeBundle.width/2) - (input.rows()/2);
            distanceToClump = input.cols() - (cubeBundle.tl().y + (cubeBundle.height/2));
            telemetry.addData("bundle", directionToClump()[0] + ", " + directionToClump()[1]);
        }


        telemetry.update();

        return maskedInputMat;
    }

    /**
     * this method makes it easier to add text to the image for debugging
     * @param ofs point where the text should be placed
     * @param text what text should be placed
     */
    private void drawText(Point ofs, String text) {
        Imgproc.putText(maskedInputMat, text, ofs, Imgproc.FONT_HERSHEY_COMPLEX_SMALL, 0.5, new Scalar(255,255,25));
    }

    /**
     * allows the robot to poll the pipeline where the closest solo cube is
     * @return returns an array with the x and y location of the solo cube in the frame
     */
    public double[] directionToCube(){
        return new double[]{directionToCube, distanceToCube};
    }

    /**
     * allows the robot to poll the pipeline for where to find the cube clump
     * @return  returns an array with the x and y location of the cube clump in the frame
     */
    public double[] directionToClump(){
        return new double[]{directionToClump, distanceToClump};
    }
}