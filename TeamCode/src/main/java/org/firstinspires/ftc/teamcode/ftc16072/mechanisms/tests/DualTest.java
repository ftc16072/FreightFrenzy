package org.firstinspires.ftc.teamcode.ftc16072.mechanisms.tests;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class DualTest extends QQ_Test {
    QQ_Test test1;
    QQ_Test test2;

    /**
     * @param description A string to describe the test
     */
    public DualTest(String description, QQ_Test test1, QQ_Test test2) {
        super(description);
        this.test1 = test1;
        this.test2 = test2;
    }

    /**
     * @param on        if true, it will run the test
     * @param telemetry lets the test print stuff to the screen
     */
    @Override
    public void run(boolean on, Telemetry telemetry) {
        this.test1.run(on, telemetry);
        this.test2.run(on, telemetry);
    }
}
