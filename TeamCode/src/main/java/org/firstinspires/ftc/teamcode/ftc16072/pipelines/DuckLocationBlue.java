package org.firstinspires.ftc.teamcode.ftc16072.pipelines;

import com.acmerobotics.dashboard.config.Config;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.openftc.easyopencv.OpenCvPipeline;

/**
 * This class finds the location of ducks -- useful for testing auto before we have a TSE
 * <p>
 * uses a quick and dirty method that works becausea we know where they are every time
 */
@Config
public class DuckLocationBlue extends DuckLocationBase {
    public static Rect space1 = new Rect(0, 140, 50, 50);
    public static Rect space2 = new Rect(70, 160, 50, 50);
    public static Rect space3 = new Rect(170, 173, 50, 50);
    protected int slotSelected = -1;

    /**
     * constructer to give us acces to telemetry
     *
     * @param telemetry so that we can return values to the telelmetry for debugging
     */
    public DuckLocationBlue(Telemetry telemetry) {
        super(telemetry);
    }
}

