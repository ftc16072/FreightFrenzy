package org.firstinspires.ftc.teamcode.ftc16072.utils;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.ftc16072.opModes.QQ_Opmode;

import java.util.HashMap;

public abstract class QQUI {
    Telemetry telemetry;
    QQ_Opmode opmode;


    public interface Options {
        public Options prev();

        public Options next();
    }


    protected HashMap<String, Options> optionsHashMap = new HashMap<>();


    public QQUI(QQ_Opmode opmode){
        this.opmode = opmode;
        this.telemetry = opmode.telemetry;

    }

    public abstract void update();

    public HashMap<String, Options> getOptionsHashMap() {
        return optionsHashMap;
    }
}
