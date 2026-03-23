package org.firstinspires.ftc.teamcode.pedroPathing.diySwerveTuning;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.PwmControl;

import org.firstinspires.ftc.teamcode.globals.RobotConstants;

/**
 * This is a tuning OpMode to find the minimum and maximum voltages of your swerve absolute analog encoders.
 * It is adapted from the Pedro Pathing documentation and uses RobotConstants for configuration.
 *
 * To use this:
 * 1. Press Start.
 * 2. Slowly rotate each swerve pod manually for 4 to 5 full rotations.
 * 3. Record the min and max voltages displayed on the telemetry.
 * 4. Update your pod creation methods in Constants.java with these values.
 */
@TeleOp(name = "Analog Min/Max Test", group = "Swerve Tuning")
public class AnalogMinMaxTest extends LinearOpMode {

    @Override
    public void runOpMode() throws InterruptedException {
        // Initialize analog encoders
        AnalogInput fl_encoder = hardwareMap.get(AnalogInput.class, RobotConstants.fL_encoderName);
        AnalogInput fr_encoder = hardwareMap.get(AnalogInput.class, RobotConstants.fR_encoderName);
        AnalogInput bl_encoder = hardwareMap.get(AnalogInput.class, RobotConstants.bL_encoderName);
        AnalogInput br_encoder = hardwareMap.get(AnalogInput.class, RobotConstants.bR_encoderName);

        // Initialize rotation servos to enable the encoders (especially for Axon servos)
        CRServo fl_servo = hardwareMap.get(CRServo.class, RobotConstants.fL_servoName);
        CRServo fr_servo = hardwareMap.get(CRServo.class, RobotConstants.fR_servoName);
        CRServo bl_servo = hardwareMap.get(CRServo.class, RobotConstants.bL_servoName);
        CRServo br_servo = hardwareMap.get(CRServo.class, RobotConstants.bR_servoName);

        // Set power to 0 and enable PWM to ensure the servo electronics are active
        fl_servo.setPower(0);
        fr_servo.setPower(0);
        bl_servo.setPower(0);
        br_servo.setPower(0);

        if (fl_servo instanceof PwmControl) ((PwmControl) fl_servo).setPwmEnable();
        if (fr_servo instanceof PwmControl) ((PwmControl) fr_servo).setPwmEnable();
        if (bl_servo instanceof PwmControl) ((PwmControl) bl_servo).setPwmEnable();
        if (br_servo instanceof PwmControl) ((PwmControl) br_servo).setPwmEnable();

        // Variables to store min and max voltages
        double fl_min = 5.0, fl_max = 0.0;
        double fr_min = 5.0, fr_max = 0.0;
        double bl_min = 5.0, bl_max = 0.0;
        double br_min = 5.0, br_max = 0.0;

        telemetry.addLine("Analog Min/Max Tuner Ready.");
        telemetry.addLine("Slowly rotate each pod manually 4-5 times after pressing START.");
        telemetry.update();

        waitForStart();

        while (opModeIsActive()) {
            // Read current voltages
            double fl_v = fl_encoder.getVoltage();
            double fr_v = fr_encoder.getVoltage();
            double bl_v = bl_encoder.getVoltage();
            double br_v = br_encoder.getVoltage();

            // Update min/max for Front Left
            if (fl_v < fl_min && fl_v > 0.0001) fl_min = fl_v;
            if (fl_v > fl_max) fl_max = fl_v;

            // Update min/max for Front Right
            if (fr_v < fr_min && fr_v > 0.0001) fr_min = fr_v;
            if (fr_v > fr_max) fr_max = fr_v;

            // Update min/max for Back Left
            if (bl_v < bl_min && bl_v > 0.0001) bl_min = bl_v;
            if (bl_v > bl_max) bl_max = bl_v;

            // Update min/max for Back Right
            if (br_v < br_min && br_v > 0.0001) br_min = br_v;
            if (br_v > br_max) br_max = br_v;

            // Display results
            telemetry.addData("Status", "Rotating pods manually...");
            telemetry.addLine();
            telemetry.addData("FL (" + RobotConstants.fL_encoderName + ")", "Min: %.4f, Max: %.4f, Cur: %.4f", fl_min, fl_max, fl_v);
            telemetry.addData("FR (" + RobotConstants.fR_encoderName + ")", "Min: %.4f, Max: %.4f, Cur: %.4f", fr_min, fr_max, fr_v);
            telemetry.addData("BL (" + RobotConstants.bL_encoderName + ")", "Min: %.4f, Max: %.4f, Cur: %.4f", bl_min, bl_max, bl_v);
            telemetry.addData("BR (" + RobotConstants.bR_encoderName + ")", "Min: %.4f, Max: %.4f, Cur: %.4f", br_min, br_max, br_v);
            telemetry.update();
        }
    }
}
