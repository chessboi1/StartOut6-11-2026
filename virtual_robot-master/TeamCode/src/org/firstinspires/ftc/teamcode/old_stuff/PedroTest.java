package org.firstinspires.ftc.teamcode.old_stuff;

import com.acmerobotics.roadrunner.followers.PathFollower;
import com.pedropathing.pathgen.*;
import com.pedropathing.localization.*;
import com.pedropathing.pathgen.math.*;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

@Autonomous(name = "Bezier Follow Example")
public class PedroTest extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        // 1️⃣ Initialize the robot’s drive + localization
        Drive drive = new Drive(hardwareMap);
        Localization localization = new Localization(hardwareMap, drive);

        // 2️⃣ Define Bézier path points (in inches or field units)
        Pose startPose = new Pose(0, 0, 0);          // starting position
        Pose controlPoint = new Pose(24, 24, 0);     // control point (curvature)
        Pose endPose = new Pose(48, 0, 0);           // ending position

        // 3️⃣ Create a Bézier curve
        BezierCurve bezierCurve = new BezierCurve(startPose, controlPoint, endPose);

        // 4️⃣ Generate a path from the curve
        Path path = new Path(bezierCurve);

        // 5️⃣ Setup path follower
        PathFollower follower = new PathFollower(localization, drive);

        // 6️⃣ Set initial pose
        localization.setPose(startPose);

        waitForStart();

        // 7️⃣ Follow the Bézier path
        while (opModeIsActive() && !follower.finalize()) {
            follower.followPath(path);
            drive.update();
            localization.update();

            telemetry.addData("Pose", localization.getPose());
            telemetry.update();
        }

        drive.stop();
    }
}