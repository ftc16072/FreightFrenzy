package org.firstinspires.ftc.teamcode.ftc16072.pipelines;


import org.firstinspires.ftc.teamcode.ftc16072.utils.QQDeque;
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
import java.util.concurrent.locks.AbstractQueuedLongSynchronizer.ConditionObject;
import java.util.*;

public class HubDetection extends OpenCvPipeline {
    public Scalar lower = new Scalar(0, 100, 96);
    public Scalar upper = new Scalar(45.3, 255, 186);
    double[] point = new double[2];
    public static double dp = 1.0;
    public static double minDist = 32;
    public static double param1 = 100.0;
    public static double param2 = 20.0;
    public static int minRad = 1;
    public static int maxRad = 100;
    public static QQDeque valuesX = new QQDeque(20);
    public static QQDeque valuesY = new QQDeque(20);


    /**
     * This will allow us to choose the color
     * space we want to use on the live field
     * tuner instead of hardcoding it
     */
    public ColorSpace colorSpace = ColorSpace.Lab;

    private Mat colorSchemeMat = new Mat();
    private Mat binaryMat = new Mat();
    private Mat maskedInputMat = new Mat();




    private List<Point> midpoints = new ArrayList<Point>();

    Mat edges = new Mat();
    Mat hierarchy = new Mat();

    enum ColorSpace {
        /*
         * Define our "conversion codes" in the enum
         * so that we don't have to do a switch
         * statement in the processFrame method.
         */
        RGB(Imgproc.COLOR_RGBA2RGB),
        HSV(Imgproc.COLOR_RGB2HSV),
        YCrCb(Imgproc.COLOR_RGB2YCrCb),
        Lab(Imgproc.COLOR_RGB2Lab);

        //store cvtCode in a public var
        public int cvtCode;

        //constructor to be used by enum declarations above
        ColorSpace(int cvtCode) {
            this.cvtCode = cvtCode;
        }
    }



    @Override
    public Mat processFrame(Mat input) {
        //Imgproc.cvtColor(inputMat, inputMat, Imgproc.COLOR_RGB2HSV);
        Imgproc.cvtColor(input, colorSchemeMat, colorSpace.cvtCode);
        Core.inRange(colorSchemeMat, lower, upper, binaryMat);
        maskedInputMat.release();
        Core.bitwise_and(input, input, maskedInputMat, binaryMat);

        Imgproc.cvtColor(maskedInputMat, maskedInputMat, Imgproc.COLOR_BGR2GRAY);
        Imgproc.GaussianBlur(maskedInputMat, maskedInputMat, new Size(3,3), 0);

        int threshold = 100;

        Imgproc.Canny(maskedInputMat, edges, threshold, threshold * 3);

        Mat circles = new Mat();
        Rect boundingbox = new Rect(0, 0, 0, 0);

        double totalCenterX = 0;
        double totalCenterY = 0;
        Imgproc.HoughCircles(maskedInputMat, circles, Imgproc.HOUGH_GRADIENT, dp,
                (double) maskedInputMat.rows() / minDist, // change this value to detect circles with different distances to each other
                param1, param2, minRad, maxRad); // change the last two parameters
        // (min_radius & max_radius) to detect larger circle
        for (int x = 0; x < circles.cols(); x++) {
            double[] c = circles.get(0, x);
            totalCenterX += c[0];
            totalCenterY += c[1];
            Point center = new Point(Math.round(c[0]), Math.round(c[1]));
            // circle center

            Imgproc.circle(maskedInputMat, center, 1, new Scalar(0, 100, 100), 3, 8, 0);
            // circle outline
            int radius = (int) Math.round(c[2]);
            //Imgproc.circle(maskedInputMat, center, radius, new Scalar(255,0,255), 3, 8, 0 );
        }
        double avgX = totalCenterX / circles.cols();
        double avgY = totalCenterY / circles.cols();
        valuesX.add(avgX);
        valuesY.add(avgY);
        point[0] = avgX;
        point[1] = avgY;

        Imgproc.circle(maskedInputMat, new Point(avgX, avgY), 20, new Scalar(255, 255, 255), 4, 8, 0);
        return maskedInputMat;
    }

    private double getDistance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2));
    }

    public double[] getHubLocation() {
        double[] point = new double[2];
        point[0] = valuesX.average();
        point[1] = valuesY.average();
        return point;
    }

}
