package pedroPathing;

import com.pedropathing.follower.Follower;
import com.pedropathing.localization.Pose;
import com.pedropathing.pathgen.PathChain;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
@Autonomous(name = "g")
public class PeEX extends LinearOpMode {
    private Follower follower;
    private final Pose startPose = new Pose(0, 0, Math.toRadians(90));
    private final Pose endPose = new Pose(0, 100, Math.toRadians(90));
    private
    private PathChain Line;
    @Override
    public void runOpMode() {
        follower.update();
    }
}
