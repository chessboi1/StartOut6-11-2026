package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.*;

@TeleOp(name = "Mainer", group = "BetaBot")
public class Mainer extends LinearOpMode {
    int trust = 1;
    double ArmPower = 0;
    int ClawPos = 0;
    double Reason = 1.0;
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
            if (gamepad1.right_bumper){
                ArmPower = .7;
            }
            if (gamepad1.left_bumper){
                ArmPower = -.7;
            }
            if (gamepad1.x){
                ClawPos = -1;
            }
            if (gamepad1.y){
                ClawPos = 1;
            }
            Reason = gamepad1.right_stick_x;

            RMotor.setPower(gamepad1.left_stick_y - Reason);
            LMotor.setPower(gamepad1.left_stick_y + Reason);
            Claw.setPosition(ClawPos);
            Arm.setPower(ArmPower);
        }
    }
}
