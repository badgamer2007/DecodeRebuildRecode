package org.firstinspires.ftc.teamcode.pedroPathing.diySwerveTuning;

import com.pedropathing.follower.Follower;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.pedroPathing.Constants;

/**
 * This is the Encoder Direction Test.
 * It is used to confirm that your absolute encoders are reversed correctly and motors turn CCW.
 *
 * Steps:
 * 1. Run the OpMode (off the ground).
 * 2. The pods should turn perpendicular to the center, forming an "O" shape.
 * 3. If they form an "X" shape (pointing towards center), reverse ALL encoder directions in RobotConstants.java.
 * 4. Once in an "O" shape, all wheels should spin to turn the robot counterclockwise (CCW).
 * 5. If wheels spin the wrong way, but were correct in Swerve Offsets Test, check your wiring/config matching.
 */
@TeleOp(name = "Encoder Direction Test", group = "Swerve Tuning")
public class EncoderDirectionTest extends OpMode {
    private Follower follower;

    @Override
    public void init() {
        follower = Constants.createFollower(hardwareMap);
        telemetry.addLine("Encoder Direction Test Initialized.");
        telemetry.addLine("Press START to test turn orientation and motor directions.");
        telemetry.update();
    }

    @Override
    public void start() {
        follower.startTeleopDrive(true);
    }

    @Override
    public void loop() {
        // Set a small turn power (CCW)
        follower.setTeleOpDrive(0, 0, 0.2, true);
        follower.update();

        telemetry.addData("Status", "Running Turn Test (CCW Turn Power Applied)");
        telemetry.addLine("1. Pods should form an 'O' shape (perpendicular to center).");
        telemetry.addLine("   - If 'X' shape, reverse all 'analogReverse' booleans in RobotConstants.");
        telemetry.addLine("2. Wheels should spin to turn the robot COUNTER-CLOCKWISE.");
        telemetry.update();
    }
}
