package org.firstinspires.ftc.teamcode.old_stuff;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "MainTele", group = "Decode")
public class DecodeTele extends LinearOpMode {
    private DcMotor LMotor1, RMotor1, LMotor2, RMotor2, Launcher, Spinyard;

    @Override
    public void runOpMode() throws InterruptedException {
        LMotor1 = hardwareMap.get(DcMotor .class, "LM1");
        RMotor1 = hardwareMap.get(DcMotor.class, "RM1");
        LMotor2 = hardwareMap.get(DcMotor.class, "LM2");
        RMotor2 = hardwareMap.get(DcMotor.class, "RM2");
        Launcher = hardwareMap.get(DcMotor.class, "outtake");
        Spinyard = hardwareMap.get(DcMotor.class, "intake");
        waitForStart();
        while (opModeIsActive()){
            LMotor1.setPower(gamepad1.left_stick_y + gamepad1.right_stick_x + gamepad1.left_stick_x);
            LMotor2.setPower(gamepad1.left_stick_y + gamepad1.right_stick_x - gamepad1.left_stick_x);
            RMotor1.setPower(gamepad1.left_stick_y - gamepad1.right_stick_x - gamepad1.left_stick_x);
            RMotor2.setPower(gamepad1.left_stick_y - gamepad1.right_stick_x + gamepad1.left_stick_x);
            if (gamepad1.b){
                Launcher.setPower(1);
            }
            if (gamepad1.a){
                Launcher.setPower(0);
            }
            if (gamepad1.y){
                Spinyard.setPower(1);
            }
            if (gamepad1.x){
                Spinyard.setPower(0);
            }
        }

    }
}
