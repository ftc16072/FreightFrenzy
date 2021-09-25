package org.firstinspires.ftc.teamcode.ftc16072.utils;

import java.util.Arrays;
import java.util.List;

public class QQ_DPad {
    public QQ_Button up = new QQ_Button();
    public QQ_Button left = new QQ_Button();
    public QQ_Button right = new QQ_Button();
    public QQ_Button down = new QQ_Button();

    public void update(boolean up, boolean left, boolean right, boolean down) {
        this.up.update(up);
        this.left.update(left);
        this.right.update(right);
        this.down.update(down);
    }


}
