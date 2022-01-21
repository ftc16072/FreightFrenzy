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
        System.out.println("QQ -- QQUI");
        System.out.flush();
        this.opmode = opmode;
        System.out.println("QQ -- QQUI 1");
        System.out.flush();
        this.telemetry = opmode.telemetry;
        System.out.println("QQ -- QQUI 2");
        System.out.flush();

    }

    public abstract void update();

    public HashMap<String, Options> getOptionsHashMap() {
        return optionsHashMap;
    }
}
