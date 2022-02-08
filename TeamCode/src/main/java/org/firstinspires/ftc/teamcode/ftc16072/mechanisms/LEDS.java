package org.firstinspires.ftc.teamcode.ftc16072.mechanisms;

import android.graphics.Color;

import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.tests.QQ_Test;

import java.util.List;

class LEDS extends QQ_Mechanism {
    private QwiicLEDStrip ledStrip;

    /**
     * forces the mechanism to have an init
     *
     * @param hwMap forces the init to take a hardware map
     */
    @Override
    public void init(HardwareMap hwMap) {
        ledStrip = hwMap.get(QwiicLEDStrip.class, "internal_leds");
        //       leds.setBrightness(5);
        ledStrip.setColor(Color.rgb(255, 255, 255));
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
