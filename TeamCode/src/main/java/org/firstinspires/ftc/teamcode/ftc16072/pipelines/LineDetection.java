package org.firstinspires.ftc.teamcode.ftc16072.pipelines;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.imgproc.LineSegmentDetector;
import org.openftc.easyopencv.OpenCvPipeline;

import java.util.Arrays;
import java.util.List;

/**
 * We use this pipeline as an Example
 * <p>
 * it adds a green rectangle to the camera view
 */
public class LineDetection extends OpenCvPipeline {
    @Override
    public Mat processFrame(Mat input) {
        Mat greyScale = new Mat();
        Imgproc.cvtColor(input, greyScale, Imgproc.COLOR_BGR2GRAY);
        Mat blurGrey = new Mat();
        Size size = new Size(5, 5);
        Imgproc.GaussianBlur(greyScale, blurGrey, size, 0);
        greyScale.release();
        int low_threshold = 50;
        int high_threshold = 50;
        Mat edges = new Mat();
        Imgproc.Canny(blurGrey, edges, low_threshold, high_threshold);
        blurGrey.release();
        int rho = 1;
        double theta = Math.PI / 180;
        int threshold = 15;
        int minLineLength = 50;
        int maxLineGap = 20;
        Mat lines = new Mat();
        Imgproc.HoughLinesP(edges, lines, rho, theta, threshold, minLineLength, maxLineGap);

        for (int i = 0; i < lines.rows(); i++) {
            double[] data = lines.get(i, 0);
            double r = data[0];
            double tHeta = data[1];
            double a = Math.cos(tHeta);
            double b = Math.sin(tHeta);
            double x0 = a * r;
            double y0 = b * r;

            Point pt1 = new Point();
            Point pt2 = new Point();

            pt1.x = Math.round(x0 + 1000 * (-b));
            pt1.y = Math.round(y0 + 1000 * (a));
            pt1.x = Math.round(x0 - 1000 * (-b));
            pt1.y = Math.round(y0 - 1000 * (a));
            Imgproc.line(input, pt1, pt2, new Scalar(0, 0, 255), 3);
        }

        lines.release();


        return input;
    }
}
