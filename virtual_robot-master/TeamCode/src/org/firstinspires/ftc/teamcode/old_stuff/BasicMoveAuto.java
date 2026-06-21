package org.firstinspires.ftc.teamcode.old_stuff;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

@Autonomous(name = "BasicMoveAuto")
public class sBasicMoveAuto extends LinearOpMode {
    private DcMotor LMotor1, RMotor1, LMotor2, RMotor2;
    int t = 0;

    @Override
    public void runOpMode() throws InterruptedException {
        LMotor1 = hardwareMap.get(DcMotor.class, "LM1");
        RMotor1 = hardwareMap.get(DcMotor.class, "RM1");
        LMotor2 = hardwareMap.get(DcMotor.class, "LM2");
        RMotor2 = hardwareMap.get(DcMotor.class, "RM2");
        RMotor1.setDirection(DcMotorSimple.Direction.REVERSE);
        waitForStart();
        while(opModeIsActive()) {
            LMotor1.setPower(1);
            RMotor1.setPower(1);
            LMotor2.setPower(1);
            RMotor2.setPower(1);
            wait(1000);
        }
    }
}
