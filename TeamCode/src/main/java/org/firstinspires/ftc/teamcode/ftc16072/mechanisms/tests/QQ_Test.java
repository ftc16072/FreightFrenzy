package org.firstinspires.ftc.teamcode.ftc16072.mechanisms.tests;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public abstract class QQ_Test {
    private String description;

    /**
     * @return returns the description of the test
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description A string to describe the test
     */
    public QQ_Test(String description) {
        this.description = description;
    }

    /**
     * @param on        if true, it will run the test
     * @param telemetry lets the test print stuff to the screen
     */
    public abstract void run(boolean on, Telemetry telemetry);
}
