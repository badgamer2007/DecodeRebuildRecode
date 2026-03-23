package org.firstinspires.ftc.teamcode.pedroPathing.diySwerveTuning;

import com.pedropathing.follower.Follower;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.pedroPathing.Constants;

/**
 * This is the Directions Test.
 * It is used to confirm that your pods move to their zero positions WITHOUT spinning the wheels.
 * Use this to verify your angle offsets and servo directions first.
 *
 * Steps:
 * 1. Run the OpMode (off the ground).
 * 2. All pods should rotate to their zero positions (facing "forward" relative to the pod's offset).
 * 3. If they oscillate, check if servos need reversing in RobotConstants.java.
 * 4. If they move to the wrong position, check offsets or wiring.
 * 5. Once stable, move to the Swerve Offsets Test to check motor directions.
 */
@TeleOp(name = "Directions Test", group = "Swerve Tuning")
public class DirectionsTest extends OpMode {
    private Follower follower;

    @Override
    public void init() {
        follower = Constants.createFollower(hardwareMap);
        telemetry.addLine("Directions Test Initialized.");
        telemetry.addLine("Press START to move pods to zero position (Motors will NOT spin).");
        telemetry.update();
    }

    @Override
    public void start() {
        follower.startTeleopDrive(true);
    }

    @Override
    public void loop() {
        // Hold at zero position (0 power, 0 turn)
        follower.setTeleOpDrive(0, 0, 0, true);
        follower.update();

        telemetry.addData("Status", "Holding pods at zero position (No Motor Power)");
        telemetry.addLine("Check if all pods are facing perfectly forward.");
        telemetry.update();
    }
}
