package org.firstinspires.ftc.teamcode.pedroPathing;

import com.pedropathing.follower.Follower;
import com.pedropathing.follower.FollowerConstants;
import com.pedropathing.ftc.FollowerBuilder;
import com.pedropathing.ftc.drivetrains.CoaxialPod;
import com.pedropathing.ftc.drivetrains.SwerveConstants;
import com.pedropathing.ftc.localization.constants.PinpointConstants;
import com.pedropathing.geometry.Pose;
import com.pedropathing.paths.PathConstraints;
import com.qualcomm.hardware.gobilda.GoBildaPinpointDriver;
import com.qualcomm.robotcore.hardware.HardwareMap;
import org.firstinspires.ftc.robotcore.external.navigation.DistanceUnit;

import org.firstinspires.ftc.teamcode.globals.RobotConstants;

public class Constants {
    public static FollowerConstants followerConstants = new FollowerConstants();

    public static PinpointConstants localizeConstants = new PinpointConstants()
            .forwardPodY(RobotConstants.forwardY)
            .strafePodX(RobotConstants.strafeX)
            .distanceUnit(DistanceUnit.MM)
            .hardwareMapName(RobotConstants.pinpointName)
            .encoderResolution(GoBildaPinpointDriver.GoBildaOdometryPods.goBILDA_4_BAR_POD)
            .forwardEncoderDirection(GoBildaPinpointDriver.EncoderDirection.FORWARD)
            .strafeEncoderDirection(GoBildaPinpointDriver.EncoderDirection.REVERSED);

    public static SwerveConstants swerveConstants = new SwerveConstants()
            .velocity(74)
            .zeroPowerBehavior(SwerveConstants.ZeroPowerBehavior.IGNORE_ANGLE_CHANGES)
            .useBrakeModeInTeleOp(true)
            .maxPower(0.8);

    private static double  twwb = RobotConstants.twwb;

    private static CoaxialPod leftFront(HardwareMap hardwareMap){
        CoaxialPod pod = new CoaxialPod(hardwareMap, RobotConstants.fL_motorName, RobotConstants.fL_servoName, RobotConstants.fL_encoderName, RobotConstants.fL_PID,
                RobotConstants.fL_motorDirection, RobotConstants.fL_servoDirection, RobotConstants.fL_offset, new Pose(twwb, twwb),
                RobotConstants.fL_analogMin, RobotConstants.fL_analogMax, RobotConstants.fL_analogReverse);
        pod.setServoCachingThreshold(RobotConstants.driveServoCaching); return pod;
    }

    private static CoaxialPod rightFront(HardwareMap hardwareMap){
        CoaxialPod pod = new CoaxialPod(hardwareMap, RobotConstants.fR_motorName, RobotConstants.fR_servoName, RobotConstants.fR_encoderName, RobotConstants.fR_PID,
                RobotConstants.fR_motorDirection, RobotConstants.fR_servoDirection, RobotConstants.fR_offset, new Pose(twwb, -twwb),
                RobotConstants.fR_analogMin, RobotConstants.fR_analogMax, RobotConstants.fR_analogReverse);
        pod.setServoCachingThreshold(RobotConstants.driveServoCaching); return pod;
    }

    private static CoaxialPod leftBack(HardwareMap hardwareMap){
        CoaxialPod pod = new CoaxialPod(hardwareMap, RobotConstants.bL_motorName, RobotConstants.bL_servoName, RobotConstants.bL_encoderName, RobotConstants.bL_PID,
                RobotConstants.bL_motorDirection, RobotConstants.bL_servoDirection, RobotConstants.bL_offset, new Pose(-twwb, twwb),
                RobotConstants.bL_analogMin, RobotConstants.bL_analogMax, RobotConstants.bL_analogReverse);
        pod.setServoCachingThreshold(RobotConstants.driveServoCaching); return pod;
    }

    private static CoaxialPod rightBack(HardwareMap hardwareMap){
        CoaxialPod pod = new CoaxialPod(hardwareMap, RobotConstants.bR_motorName, RobotConstants.bR_servoName, RobotConstants.bR_encoderName, RobotConstants.bR_PID,
                RobotConstants.bR_motorDirection, RobotConstants.bR_servoDirection, RobotConstants.bR_offset, new Pose(-twwb, -twwb),
                RobotConstants.bR_analogMin, RobotConstants.bR_analogMax, RobotConstants.bR_analogReverse);
        pod.setServoCachingThreshold(RobotConstants.driveServoCaching); return pod;
    }

    public static PathConstraints pathConstraints = new PathConstraints(0.99, 100, 1, 1);

    public static Follower createFollower(HardwareMap hardwareMap) {
        return new FollowerBuilder(followerConstants, hardwareMap)
                .pathConstraints(pathConstraints)
                .swerveDrivetrain(swerveConstants, leftFront(hardwareMap), rightFront(hardwareMap), leftBack(hardwareMap), rightBack(hardwareMap))
                .pinpointLocalizer(localizeConstants)
                .build();
    }
}
