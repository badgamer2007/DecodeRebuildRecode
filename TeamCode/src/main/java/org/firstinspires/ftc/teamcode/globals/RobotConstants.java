package org.firstinspires.ftc.teamcode.globals;

import com.pedropathing.geometry.Pose;
import com.pedropathing.control.PIDFCoefficients;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

public class RobotConstants {

    public enum RobotTeam {
        RED, BLUE
    }

    public static RobotTeam robotTeam = RobotTeam.RED;

    // Goal Poses
    public static Pose redGoal = new Pose(144, 144);
    public static Pose blueGoal = new Pose(0, 144);

    // Pinpoint
    public static String pinpointName = "odo";

    // Swerve Globals
    public static double analogMax = 3.3;
    public static double driveServoCaching = 0.01;
    public static double forwardY = -148.675;
    public static double strafeX = -23.675;
    public static double twwb = 267.35;

    // Front Right Swerve
    public static String fR_motorName = "fr_motor";
    public static String fR_servoName = "fr_rotation";
    public static String fR_encoderName = "fr_absolute";
    public static double fR_offset = 4.22;
    public static double fR_analogMin = 0.0;
    public static double fR_analogMax = 3.3;
    public static DcMotorSimple.Direction fR_servoDirection = DcMotorSimple.Direction.REVERSE;
    public static DcMotorSimple.Direction fR_motorDirection = DcMotorSimple.Direction.FORWARD;
    public static boolean fR_analogReverse = false;
    public static PIDFCoefficients fR_PID = new PIDFCoefficients(0.6, 0, 0.02, 0);

    // Back Right Swerve
    public static String bR_motorName = "br_motor";
    public static String bR_servoName = "br_rotation";
    public static String bR_encoderName = "br_absolute";
    public static double bR_offset = 6.01;
    public static double bR_analogMin = 0.0;
    public static double bR_analogMax = 3.3;
    public static DcMotorSimple.Direction bR_servoDirection = DcMotorSimple.Direction.REVERSE;
    public static DcMotorSimple.Direction bR_motorDirection = DcMotorSimple.Direction.FORWARD;
    public static boolean bR_analogReverse = false;
    public static PIDFCoefficients bR_PID = new PIDFCoefficients(0.3, 0, 0.02, 0);

    // Back Left Swerve
    public static String bL_motorName = "bl_motor";
    public static String bL_servoName = "bl_rotation";
    public static String bL_encoderName = "bl_absolute";
    public static double bL_offset = 1.47;
    public static double bL_analogMin = 0.0;
    public static double bL_analogMax = 3.3;
    public static DcMotorSimple.Direction bL_servoDirection = DcMotorSimple.Direction.REVERSE;
    public static DcMotorSimple.Direction bL_motorDirection = DcMotorSimple.Direction.FORWARD;
    public static boolean bL_analogReverse = false;
    public static PIDFCoefficients bL_PID = new PIDFCoefficients(0.6, 0, 0.02, 0);

    // Front Left Swerve
    public static String fL_motorName = "fl_motor";
    public static String fL_servoName = "fl_rotation";
    public static String fL_encoderName = "fl_absolute";
    public static double fL_offset = 6.12;
    public static double fL_analogMin = 0.0;
    public static double fL_analogMax = 3.3;
    public static DcMotorSimple.Direction fL_servoDirection = DcMotorSimple.Direction.REVERSE;
    public static DcMotorSimple.Direction fL_motorDirection = DcMotorSimple.Direction.FORWARD;
    public static boolean fL_analogReverse = false;
    public static PIDFCoefficients fL_PID = new PIDFCoefficients(0.6, 0, 0.02, 0);
}
