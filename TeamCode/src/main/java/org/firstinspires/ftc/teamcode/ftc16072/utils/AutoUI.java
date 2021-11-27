package org.firstinspires.ftc.teamcode.ftc16072.utils;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.robotcore.external.Func;
import org.firstinspires.ftc.robotcore.external.Function;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.ftc16072.opModes.QQ_Opmode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AutoUI extends QQUI{

    public enum Alliance implements Options{
        RED,
        BLUE;

        Alliance[] values = values();
        @Override
        public Options prev() {
            return values[(ordinal() - 1 + values.length) % values.length];
        }

        @Override
        public Options next() {
            return values[(ordinal() - 1) % values.length];
        }
    }
    Alliance alliancEnum = Alliance.RED;

    public enum Strategy implements Options{
        DUCK,
        OTHER;

        Strategy[] values = values();
        @Override
        public Options prev() {
            return values[(ordinal() - 1 + values.length) % values.length];
        }

        @Override
        public Options next() {
            return values[(ordinal() - 1) % values.length];
        }
    }
    Strategy strategyEnum = Strategy.DUCK;

    Function<String, String> addPointer = a -> ">" + a;
    Func<String> getData;
    Telemetry.Item alliance = telemetry.addData("Alliance", alliancEnum);
    Telemetry.Item strategy = telemetry.addData("Strategy", strategyEnum);

    List<Telemetry.Item> ui = Arrays.asList(
            alliance,
            strategy
    );




    int selectedIndex = 0;

    @Override
    public void update() {
        ui.get(selectedIndex).setCaption(addPointer.apply(ui.get(selectedIndex).getCaption()));
        if(opmode.gp1.dpad.up.isNewlyPressed() || opmode.gp2.dpad.up.isNewlyPressed()){
            selectedIndex = opmode.updatePosition(selectedIndex--, ui.size());
        } else if(opmode.gp1.dpad.down.isNewlyPressed() || opmode.gp2.dpad.down.isNewlyPressed()){
            selectedIndex = opmode.updatePosition(selectedIndex++, ui.size());
        }
        if(opmode.gp1.dpad.left.isNewlyPressed() || opmode.gp2.dpad.right.isNewlyPressed()){
            alliancEnum.prev();
            optionsHashMap.put(ui.get(selectedIndex).getCaption(), alliancEnum);
        } else if(opmode.gp1.dpad.right.isNewlyPressed() || opmode.gp2.dpad.left.isNewlyPressed()){
            alliancEnum.next();
            optionsHashMap.put(ui.get(selectedIndex).getCaption(),alliancEnum);
        }
        ui.get(selectedIndex).setValue(alliancEnum);

    }
    public AutoUI(QQ_Opmode opmode){
        super(opmode);
        telemetry.setItemSeparator("");
        optionsHashMap.put(alliance.getCaption(), alliancEnum);
        optionsHashMap.put(strategy.getCaption(), strategyEnum);

    }

}