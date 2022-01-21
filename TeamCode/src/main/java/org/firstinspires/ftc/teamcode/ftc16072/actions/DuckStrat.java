package org.firstinspires.ftc.teamcode.ftc16072.actions;


import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;
import org.firstinspires.ftc.teamcode.ftc16072.opModes.QQ_Opmode;
import org.firstinspires.ftc.teamcode.ftc16072.utils.AutoUI;

public class DuckStrat extends QQ_Action {
    QQ_Action list = new nullAction();

    public DuckStrat(){
        list.setNext(new DriveCM(-24, DistanceUnit.INCH))
                .setNext(new DuckSpin(true))
                .setNext(new DualAction("drive and move lift to the right height", new DriveCM(48, DistanceUnit.INCH), new GoToSelectedLevel()))
                .setNext(new DropCube(true))
                .setNext(new DelayTill(.25))
                .setNext(new DropCube(false));

    }

    @Override
    public QQ_Action run(QQ_Opmode opmode) {
        return list.run(opmode);
    }
}
