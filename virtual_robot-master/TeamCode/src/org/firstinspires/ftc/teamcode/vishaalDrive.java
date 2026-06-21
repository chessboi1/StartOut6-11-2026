package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class vishaalDrive {
    DcMotor rRight, rLeft, fRight, fLeft, flywheel1, flywheel2, intake1, intake2;
    Servo load;
    public void init(HardwareMap hwMap) {
        rRight = hwMap.get(DcMotor.class, "NAME");  // defining motors
        rLeft = hwMap.get(DcMotor.class, "NAME");
        fRight = hwMap.get(DcMotor.class, "NAME");
        fLeft = hwMap.get(DcMotor.class, "NAME");
        flywheel1 = hwMap.get(DcMotor.class, "NAME");
        flywheel2 = hwMap.get(DcMotor.class, "NAME");
        intake1 = hwMap.get(DcMotor.class, "NAME");
        intake2 = hwMap.get(DcMotor.class, "NAME");

        fRight.setDirection(DcMotor.Direction.REVERSE);
        rRight.setDirection(DcMotor.Direction.REVERSE);
        flywheel2.setDirection(DcMotor.Direction.REVERSE);
        intake2.setDirection(DcMotor.Direction.REVERSE);

        rRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);  // ZPB settings
        rLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        fLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        flywheel1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        flywheel2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        intake1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);
        intake2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.FLOAT);

        rRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER); // RunMode settings
        rLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        fRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        fLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        flywheel1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        flywheel2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        intake1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        intake2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        load = hwMap.get(Servo.class, "NAME"); // define load
    }

    public void drive(double throttle, double rotate, double strafe) { // robot rel. mecanum drive
        fRight.setPower(throttle - rotate - strafe);
        fLeft.setPower(throttle + rotate + strafe);
        rRight.setPower(throttle + rotate - strafe);
        rLeft.setPower(throttle - rotate + strafe);
    }

    public void setFlywheels(double power) { // sets flywheel power
        if (power > 1) {
            power = 1;
        }
        else if (power < -1) {
            power = -1;
        }

        flywheel1.setPower(power);
        flywheel2.setPower(power);
    }

    public void setIntakes(double power) { // sets intake power
        if (power > 1) {
            power = 1;
        }
        else if (power < -1) {
            power = -1;
        }

        intake1.setPower(power);
        intake2.setPower(power);
    }

    public void openBallGate(boolean openGate) { // opens ball gate
        if (openGate) {
            load.setPosition(1); // idk which position will be 1 or 0, I'm just assuming 1 is open
        }
        else {
            load.setPosition(0);
        }
    }

}
