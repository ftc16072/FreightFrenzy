package org.firstinspires.ftc.teamcode.ftc16072.actions;

import org.firstinspires.ftc.teamcode.ftc16072.opModes.QQ_Opmode;

public abstract class PassedValueAction extends QQ_Action {
    double[] value;

    PassedValueAction(double[] value) {
        this.value = value;
    }

    PassedValueAction() {
    }

    abstract public QQ_Action run(QQ_Opmode opmode, double[] value);

    @Override
    public QQ_Action run(QQ_Opmode opmode) {
        boolean test = false;
        for (double d : value) {
            test = test || d > 0;
        }
        if (test) {
            return run(opmode, value);
        } else {
            return this.nextAction;
        }
    }
}
