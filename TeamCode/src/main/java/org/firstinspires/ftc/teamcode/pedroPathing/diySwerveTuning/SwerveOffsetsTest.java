package org.firstinspires.ftc.teamcode.pedroPathing.diySwerveTuning;

import com.pedropathing.follower.Follower;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.pedroPathing.Constants;

/**
 * This is the Swerve Offsets Test.
 * It is used to confirm that your motor directions are correct while pods are at zero.
 *
 * Steps:
 * 1. Run the OpMode (off the ground).
 * 2. All pods should rotate to their zero positions.
 * 3. Once they are at zero, all pods should rotate their wheels to move the robot forward.
 * 4. If a pod's wheel is rotating backward, reverse its motor direction in RobotConstants.java.
 * 5. If everything is correct, the robot should slowly drive forward when placed on the ground.
 */
@TeleOp(name = "Swerve Offsets Test", group = "Swerve Tuning")
public class SwerveOffsetsTest extends OpMode {
    private Follower follower;

    @Override
    public void init() {
        follower = Constants.createFollower(hardwareMap);
        telemetry.addLine("Swerve Offsets Test Initialized.");
        telemetry.addLine("Press START to test motor directions at zero position.");
        telemetry.update();
    }

    @Override
    public void start() {
        follower.startTeleopDrive(true);
    }

    @Override
    public void loop() {
        // Set a constant small forward power to all pods
        follower.setTeleOpDrive(0.2, 0, 0, true);
        follower.update();

        telemetry.addData("Status", "Checking motor directions (Forward Power Applied)");
        telemetry.addLine("All wheels should be spinning to move the robot FORWARD.");
        telemetry.addLine("If not, reverse the motor in RobotConstants.java");
        telemetry.update();
    }
}
