package org.firstinspires.ftc.teamcode.ftc16072.pipelines;

import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;

/**
 * We use this pipeline as an Example
 * <p>
 * it adds a green rectangle to the camera view
 */
public class GreenRectangle extends OpenCvPipeline {
    @Override
    public Mat processFrame(Mat input) {
        Imgproc.rectangle(
                input,
                new Point(
                        input.cols() / 4.0,
                        input.rows() / 4.0),
                new Point(
                        input.cols() * (3f / 4f),
                        input.rows() * (3f / 4f)),
                new Scalar(0, 255, 0), 4);
        return input;
    }
}
