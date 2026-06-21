package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp
public class vishaalOpMode extends LinearOpMode {
    private vishaalDrive drive;

    @Override
    public void runOpMode() throws InterruptedException {
        drive.init(hardwareMap);
        waitForStart();
        while(opModeIsActive()) {
            drive.drive(gamepad1.left_stick_y, gamepad1.right_stick_x, gamepad1.left_stick_x);
            drive.setFlywheels(gamepad1.right_trigger);
            drive.setIntakes(gamepad1.left_trigger);
            drive.openBallGate(gamepad1.x);
        }
    }
}
