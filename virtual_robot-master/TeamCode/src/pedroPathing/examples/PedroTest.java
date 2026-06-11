package pedroPathing.examples;

import com.pedropathing.follower.Follower;
import com.pedropathing.localization.Pose;
import com.pedropathing.util.Timer;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
@Autonomous(name = "PedroTest")
public class PedroTest extends LinearOpMode {
    private DcMotor LMotor1, RMotor1, LMotor2, RMotor2;
    double speed = .6;
    double fastspeed = .6 * 0.8;
    public void runOpMode() {
        LMotor1 = hardwareMap.get(DcMotor.class, "LM1");
        RMotor1 = hardwareMap.get(DcMotor.class, "RM1");
        LMotor2 = hardwareMap.get(DcMotor.class, "LM2");
        RMotor2 = hardwareMap.get(DcMotor.class, "RM2");
        RMotor1.setDirection(DcMotorSimple.Direction.REVERSE);
        RMotor1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        RMotor2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        LMotor1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        LMotor2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        Follower follower;
        Timer pathTimer;
        Timer actionTimer;
        Timer opmodeTimer;
        int pathState;
        waitForStart();
        while (opModeIsActive()) {

            final Pose startPose = new Pose(28.5, 128, Math.toRadians(180)); // Start Pose of our robot.
            final Pose scorePose = new Pose(60, 85, Math.toRadians(135)); // Scoring Pose of our robot. It is facing the goal at a 135 degree angle.
            final Pose pickup1Pose = new Pose(37, 121, Math.toRadians(0)); // Highest (First Set) of Artifacts from the Spike Mark.
            final Pose pickup2Pose = new Pose(43, 130, Math.toRadians(0)); // Middle (Second Set) of Artifacts from the Spike Mark.
            final Pose pickup3Pose = new Pose(49, 135, Math.toRadians(0)); // Lowest (Third Set) of Artifacts from the Spike Mark.
            follower.followPath(startPose, true);




        }

    }
}
