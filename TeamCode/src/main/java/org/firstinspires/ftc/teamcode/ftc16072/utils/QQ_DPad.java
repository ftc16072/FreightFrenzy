package org.firstinspires.ftc.teamcode.ftc16072.utils;

import java.util.Arrays;
import java.util.List;

public class QQ_DPad {
    public QQ_Button up;
    public QQ_Button left;
    public QQ_Button right;
    public QQ_Button down;

    public QQ_DPad() {
        up = new QQ_Button();
        left = new QQ_Button();
        right = new QQ_Button();
        down = new QQ_Button();
    }

    public void update(boolean up, boolean left, boolean right, boolean down) {
        this.up.update(up);
        this.left.update(left);
        this.right.update(right);
        this.down.update(down);
    }


}
