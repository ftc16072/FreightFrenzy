package org.firstinspires.ftc.teamcode.ftc16072.mechanisms;

import android.graphics.Color;

import com.acmerobotics.dashboard.config.Config;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.tests.QQ_Test;

import java.util.List;

@Config
public class LEDS extends QQ_Mechanism {
    private QwiicLEDStrip ledStrip;
    public static int brightness = 50;
    public static int red = 255;
    public static int blue = 255;
    public static int green = 255;

    /**
     * forces the mechanism to have an init
     *
     * @param hwMap forces the init to take a hardware map
     */
    @Override
    public void init(HardwareMap hwMap) {
        ledStrip = hwMap.get(QwiicLEDStrip.class, "internal_leds");
        //       leds.setBrightness(5);

    }

    /**
     * forces the mechanism to have a getTests();
     *
     * @return returns the tests for the mechanism
     */
    @Override
    public List<QQ_Test> getTests() {
        return null;
    }

    @Override
    public void update(double time) {

    }

}
