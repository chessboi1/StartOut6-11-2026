package org.firstinspires.ftc.teamcode.old_stuff;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous(name = "Test Auto", group = "Auto")
public class TestAuto extends LinearOpMode {
    private DcMotor LMotor, RMotor, Arm;
    private Servo Claw;
    public void runOpMode() {
        LMotor = hardwareMap.get(DcMotor.class, "Left_Motor");
        RMotor = hardwareMap.get(DcMotor.class, "Right_Motor");
        Arm = hardwareMap.get(DcMotor.class, "Arm");
        Claw = hardwareMap.get(Servo.class, "Claw");
        Arm.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        LMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        waitForStart();
        while (opModeIsActive()) {
            Claw.setPosition(-1);
            RMotor.setPower(.5);
            LMotor.setPower(.5);
            sleep(2000);
            RMotor.setPower(0);
            LMotor.setPower(0);
            Arm.setPower(.4);
            sleep(1200);
            Arm.setPower(0);
            Claw.setPosition(1);
            sleep(700);
            RMotor.setPower(-.5);
            LMotor.setPower(-.5);
            sleep(2000);
            RMotor.setPower(0);
            LMotor.setPower(0);


        }
    }
}
