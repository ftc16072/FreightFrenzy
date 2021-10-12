package org.firstinspires.ftc.teamcode.ftc16072.utils;

public class QQ_Button extends QQ_GamepadInput{
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

    public boolean isReleased() {
        return !state;
    }

    public boolean isNewlyReleased() {
        if (lastState) {
            return !state;
        }
        return false;
    }


    @Override
    boolean state() {
        switch (condition){
            case PUSHED:
                return isPressed();
            case NEWPUSHED:
                return isNewlyPressed();
            case RELEASED:
                return isReleased();
            case NEWRELEASED:
                return isNewlyReleased();
            default:
                return false;
        }
    }
}
