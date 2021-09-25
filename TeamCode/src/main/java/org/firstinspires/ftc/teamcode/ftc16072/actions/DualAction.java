package org.firstinspires.ftc.teamcode.ftc16072.actions;

import org.firstinspires.ftc.teamcode.ftc16072.opModes.QQ_Opmode;

public class DualAction extends QQ_Action {
    QQ_Action a1;
    QQ_Action a2;

    public DualAction(String description, QQ_Action action1, QQ_Action action2) {
        super(description);
        a1 = action1;
        a2 = action2;
    }

    @Override
    public QQ_Action run(QQ_Opmode opmode) {
        a1.run(opmode);
        a2.run(opmode);
        if (a1.nextAction == null && a2.nextAction == null) {
            return this.nextAction;
        } else {
            return this;
        }
    }
}
