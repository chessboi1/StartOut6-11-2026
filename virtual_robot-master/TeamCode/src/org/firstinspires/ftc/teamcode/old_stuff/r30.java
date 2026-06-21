package org.firstinspires.ftc.teamcode.old_stuff;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name= "r30", group = "television")
public class r30 extends LinearOpMode {
    double speed = -.5;
    private DcMotor Motor1, Motor2, LMotor1, LMotor2, RMotor1, RMotor2;
    private Servo Feeder;
    double go = 0.0;
    public void runOpMode() {
        LMotor1 = hardwareMap.get(DcMotor.class, "fl");
        RMotor1 = hardwareMap.get(DcMotor.class, "fr");
        LMotor2 = hardwareMap.get(DcMotor.class, "bl");
        RMotor2 = hardwareMap.get(DcMotor.class, "br");
        Motor1 = hardwareMap.get(DcMotor.class, "lturner");
        Motor2 = hardwareMap.get(DcMotor.class, "rturner");
        Feeder = hardwareMap.get(Servo.class, "feeder");
        RMotor1.setDirection(DcMotorSimple.Direction.REVERSE);
        waitForStart();
        while (opModeIsActive()) {
            if (gamepad1.x){
                Feeder.setPosition(.4);
            }
            if (gamepad1.y){
                Feeder.setPosition(.51);
            }
            if (gamepad1.a){
                go = 1.0;
            }
            if (gamepad1.b){
                go = 0.0;
            }
            Motor1.setPower(go);
            Motor2.setPower(-go);
            LMotor1.setPower(0);
            RMotor1.setPower(0);
            LMotor2.setPower(0);
            RMotor2.setPower(0);
            if (gamepad1.left_stick_y > 0){
                LMotor1.setPower(speed);
                RMotor1.setPower(speed);
                LMotor2.setPower(speed);
                RMotor2.setPower(speed);
            }
            if (gamepad1.left_stick_y < 0){
                LMotor1.setPower(-speed);
                RMotor1.setPower(-speed);
                LMotor2.setPower(-speed);
                RMotor2.setPower(-speed);
            }
            if (gamepad1.right_stick_x < 0){
                LMotor1.setPower(speed);
                RMotor1.setPower(-speed);
                LMotor2.setPower(-speed);
                RMotor2.setPower(speed);
            }
            if (gamepad1.right_stick_x > 0){
                LMotor1.setPower(-speed);
                RMotor1.setPower(speed);
                LMotor2.setPower(speed);
                RMotor2.setPower(-speed);
            }
            if (gamepad1.right_bumper == true){
                LMotor1.setPower(speed);
                RMotor1.setPower(-speed);
                LMotor2.setPower(speed);
                RMotor2.setPower(-speed);
            }
            if (gamepad1.left_bumper == true){
                LMotor1.setPower(-speed);
                RMotor1.setPower(speed);
                LMotor2.setPower(-speed);
                RMotor2.setPower(speed);
            }
        }
    }
}
