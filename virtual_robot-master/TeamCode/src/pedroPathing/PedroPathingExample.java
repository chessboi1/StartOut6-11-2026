package pedroPathing;
import com.pedropathing.follower.Follower;
import com.pedropathing.follower.FollowerConstants;
import com.pedropathing.localization.Localizer;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
@TeleOp(name = "PedroPathingExample", group = "Television")
public class PedroPathingExample extends LinearOpMode {
    private Follower follower;
    private Localizer localizer;
    private DcMotor LMotor1, RMotor1, LMotor2, RMotor2;



    public void runOpMode() {
        LMotor1 = hardwareMap.get(DcMotor.class, "Left_Motor1");
        RMotor1 = hardwareMap.get(DcMotor.class, "Right_Motor1");
        LMotor2 = hardwareMap.get(DcMotor.class, "Left_Motor2");
        RMotor2 = hardwareMap.get(DcMotor.class, "Right_Motor2");
        RMotor1.setDirection(DcMotorSimple.Direction.REVERSE);
        follower = new Follower();
        localizer = new YourLocalizerClass();
        waitForStart();
        while (opModeIsActive()) {
            pass
        }
    }
}
}

