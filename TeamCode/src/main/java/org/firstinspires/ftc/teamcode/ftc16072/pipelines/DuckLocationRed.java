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
 * <p>
 * uses a quick and dirty method that works becausea we know where they are every time
 */
@Config
public class DuckLocationRed extends DuckLocationBase {
    Telemetry telemetry;
    public static Rect space1 = new Rect(70, 120, 50, 50);
    public static Rect space2 = new Rect(200, 120, 50, 50);

    public static Rect space3 = new Rect(300, 120, 20, 50);
    protected int slotSelected = -1;
    Scalar blue = new Scalar(0, 0, 255);
    Scalar green = new Scalar(0, 255, 0);

    /**
     * constructer to give us acces to telemetry
     *
     * @param telemetry so that we can return values to the telelmetry for debugging
     */
    public DuckLocationRed(Telemetry telemetry) {
        super(telemetry);
    }
}

