package org.firstinspires.ftc.teamcode.old_stuff;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;


@TeleOp(name = "EthanCardoneDosuemDemo", group = "Televison")
public class EthanDosuemDemo extends LinearOpMode {
    private DcMotor LMotor1, RMotor1, LMotor2, RMotor2;
    double speed = .6;
    double slowspeed = .3;
    double fastspeed = .9;
    public void runOpMode() {
        LMotor1 = hardwareMap.get(DcMotor.class, "Left_Motor1");
        RMotor1 = hardwareMap.get(DcMotor.class, "Right_Motor1");
        LMotor2 = hardwareMap.get(DcMotor.class, "Left_Motor2");
        RMotor2 = hardwareMap.get(DcMotor.class, "Right_Motor2");
        RMotor1.setDirection(DcMotorSimple.Direction.REVERSE);
        RMotor1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RMotor2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        LMotor1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        LMotor2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        waitForStart();
        while (opModeIsActive()) {
            speed = .6;
            LMotor1.setPower(0);
            RMotor1.setPower(0);
            LMotor2.setPower(0);
            RMotor2.setPower(0);
            if (gamepad1.left_trigger > .1){
                speed = slowspeed;
            }
            if (gamepad1.right_trigger > .1){
                speed = fastspeed;
            }
            if (gamepad1.left_stick_y > 0.1){
                LMotor1.setPower(speed);
                RMotor1.setPower(speed);
                LMotor2.setPower(speed);
                RMotor2.setPower(speed);
            }
            if (gamepad1.left_stick_y < -0.1){
                LMotor1.setPower(-speed);
                RMotor1.setPower(-speed);
                LMotor2.setPower(-speed);
                RMotor2.setPower(-speed);
            }
            if (gamepad1.left_bumper == true){
                if (gamepad1.right_stick_x < 0.1){
                    if (gamepad1.right_stick_x > -0.1){
                        speed = speed * 1.2;
                        LMotor1.setPower(speed);
                        RMotor1.setPower(-speed);
                        LMotor2.setPower(-speed);
                        RMotor2.setPower(speed);
                    }
                }
            }
            if (gamepad1.right_bumper == true){
                if (gamepad1.right_stick_x < 0.1){
                    if (gamepad1.right_stick_x > -0.1){
                        speed = speed * 1.2;
                        LMotor1.setPower(-speed);
                        RMotor1.setPower(speed);
                        LMotor2.setPower(speed);
                        RMotor2.setPower(-speed);
                    }
                }
            }
            if (gamepad1.right_stick_x < -0.1){
                if (gamepad1.left_stick_y < 0.1){
                    if (gamepad1.left_stick_y > -0.1){
                        LMotor1.setPower(speed);
                        RMotor1.setPower(-speed);
                        LMotor2.setPower(speed);
                        RMotor2.setPower(-speed);
                    }
                }
            }
            if (gamepad1.right_stick_x > 0.1){
                if (gamepad1.left_stick_y < 0.1){
                    if (gamepad1.left_stick_y > -0.1){
                        LMotor1.setPower(-speed);
                        RMotor1.setPower(speed);
                        LMotor2.setPower(-speed);
                        RMotor2.setPower(speed);
                    }
                }
            }
        }
    }
}