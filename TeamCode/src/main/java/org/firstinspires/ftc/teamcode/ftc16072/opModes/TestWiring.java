package org.firstinspires.ftc.teamcode.ftc16072.opModes;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.QQ_Mechanism;
import org.firstinspires.ftc.teamcode.ftc16072.mechanisms.tests.QQ_Test;

import java.util.List;

@TeleOp(name = "Test Wiring", group = "TESTS/DEV")
public class TestWiring extends QQ_Opmode {
    List<QQ_Mechanism> mechanismList;
    int currentMech = 0;
    List<QQ_Test> testsList;
    int currentTest = 0;

    @Override
    public void init() {
        super.init();
        mechanismList = robot.getMechanismList();

    }

    @Override
    public void loop() {
        super.loop();
        if (gp1.dpad.up.isNewlyPressed() || gp2.dpad.up.isNewlyPressed()) {
            currentMech = updatePosition(currentMech + 1, mechanismList.size());
        } else if (gp1.dpad.down.isNewlyPressed() || gp2.dpad.down.isNewlyPressed()) {
            currentMech = updatePosition(currentMech - 1, mechanismList.size());
        }
        telemetry.addData("Mechanism", mechanismList.get(currentMech).toString());
        testsList = mechanismList.get(currentMech).getTests();
        if (gp1.dpad.right.isNewlyPressed() || gp2.dpad.right.isNewlyPressed()) {
            currentTest = updatePosition(currentTest + 1, testsList.size());
        } else if (gp1.dpad.left.isNewlyPressed() || gp2.dpad.left.isNewlyPressed()) {
            currentTest = updatePosition(currentTest - 1, testsList.size());
        }

        telemetry.addData("Test", testsList.get(currentTest).getDescription());

        testsList.get(currentTest).run(gp1.cross.isPressed() || gp2.cross.isPressed(), telemetry);


    }

}
