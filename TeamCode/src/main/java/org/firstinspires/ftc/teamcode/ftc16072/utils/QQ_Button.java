package org.firstinspires.ftc.teamcode.ftc16072.utils;

public class QQ_Button {
    boolean lastState;
    boolean state;

    public void update(boolean state) {
        lastState = this.state;
        this.state = state;
    }

    public boolean isPressed() {
        return state;
    }

    public boolean isNewlyPressed() {
        if (!lastState) {
            return state;
        }
        return false;
    }


}
