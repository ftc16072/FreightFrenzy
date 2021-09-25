package org.firstinspires.ftc.teamcode.ftc16072.utils;

import com.qualcomm.robotcore.hardware.Gamepad;

public class QQ_Gamepad {
    public QQ_DPad dpad = new QQ_DPad();
    public QQ_Button square = new QQ_Button();
    public QQ_Button triangle = new QQ_Button();
    public QQ_Button circle = new QQ_Button();
    public QQ_Button cross = new QQ_Button();
    public QQ_Button start = new QQ_Button();
    public QQ_Button back = new QQ_Button();
    public QQ_Button lBumper = new QQ_Button();
    public QQ_Button rBumper = new QQ_Button();
    public QQ_Joystick leftStick = new QQ_Joystick();
    public QQ_Joystick rightStick = new QQ_Joystick();
    public QQ_Trigger rightTrigger = new QQ_Trigger();
    public QQ_Trigger leftTrigger = new QQ_Trigger();

    public QQ_Gamepad(Gamepad gamepad) {
        update(gamepad);
    }


    public void update(Gamepad gamepad) {
        dpad.update(gamepad.dpad_up, gamepad.dpad_left, gamepad.dpad_right, gamepad.dpad_down);
        square.update(gamepad.square);
        triangle.update(gamepad.triangle);
        circle.update(gamepad.circle);
        cross.update(gamepad.cross);
        start.update(gamepad.start);
        back.update(gamepad.back);
        lBumper.update(gamepad.left_bumper);
        rBumper.update(gamepad.right_bumper);
        leftStick.update(gamepad.left_stick_x, gamepad.left_stick_y, gamepad.left_stick_button);
        rightStick.update(gamepad.right_stick_x, gamepad.right_stick_y, gamepad.right_stick_button);
        rightTrigger.update(gamepad.right_trigger);
        leftTrigger.update(gamepad.left_trigger);

    }

    //todo: add bind stuff


}
