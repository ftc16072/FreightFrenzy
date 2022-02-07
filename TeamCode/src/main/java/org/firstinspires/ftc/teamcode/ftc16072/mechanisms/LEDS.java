package org.firstinspires.ftc.teamcode.ftc16072.mechanisms;

import com.qualcomm.robotcore.hardware.DigitalChannel;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.tests.QQ_Test;

import java.util.List;

class LEDS extends QQ_Mechanism {
    private DigitalChannel redLED;
    private DigitalChannel greenLED;
    private DigitalChannel red1LED;
    private DigitalChannel green1LED;

    /**
     * forces the mechanism to have an init
     *
     * @param hwMap forces the init to take a hardware map
     */
    @Override
    public void init(HardwareMap hwMap) {
        redLED = hwMap.get(DigitalChannel.class, "red");
        greenLED = hwMap.get(DigitalChannel.class, "green");
        red1LED = hwMap.get(DigitalChannel.class, "red1");
        green1LED = hwMap.get(DigitalChannel.class, "green1");
        redLED.setMode(DigitalChannel.Mode.OUTPUT);
        greenLED.setMode(DigitalChannel.Mode.OUTPUT);
        red1LED.setMode(DigitalChannel.Mode.OUTPUT);
        green1LED.setMode(DigitalChannel.Mode.OUTPUT);
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

    public void internalRed() {
        redLED.setState(true);
        red1LED.setState(true);
    }

    public void internalGreen() {
        greenLED.setState(true);
        green1LED.setState(true);
    }
}
