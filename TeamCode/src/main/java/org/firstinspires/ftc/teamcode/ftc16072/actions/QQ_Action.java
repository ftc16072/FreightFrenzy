package org.firstinspires.ftc.teamcode.ftc16072.actions;

import org.firstinspires.ftc.teamcode.ftc16072.opModes.QQ_Opmode;

public abstract class QQ_Action {
    String description;
    QQ_Action nextAction;

    public QQ_Action(String description) {
        this.description = description;
    }

    public QQ_Action() {
        this(Class.class.getSimpleName());
    }

    public abstract QQ_Action run(QQ_Opmode opmode);

    public QQ_Action setNext(QQ_Action nextAction) {
        if (this.nextAction == null) {
            this.nextAction = nextAction;
        } else {
            this.nextAction.setNext(nextAction);
        }

        return this;
    }

    public String getDescription() {
        return description;
    }
}
