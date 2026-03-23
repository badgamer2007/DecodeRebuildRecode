package org.firstinspires.ftc.teamcode.pedroPathing.diySwerveTuning;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.CRServoImplEx;

import org.firstinspires.ftc.teamcode.globals.RobotConstants;

@TeleOp(name = "Analog Offset Test", group = "Swerve Tuning")
public class AnalogOffsetTest extends OpMode {
    private static final double TAU = 2 * Math.PI;

    CRServoImplEx fLServo, fRServo, bLServo, bRServo;

    AnalogInput fL, fR, bL, bR;

    @Override
    public void init() {
        fLServo = hardwareMap.get(CRServoImplEx.class, RobotConstants.fL_servoName);
        fRServo = hardwareMap.get(CRServoImplEx.class, RobotConstants.fR_servoName);
        bLServo = hardwareMap.get(CRServoImplEx.class, RobotConstants.bL_servoName);
        bRServo = hardwareMap.get(CRServoImplEx.class, RobotConstants.bR_servoName);

        fL = hardwareMap.get(AnalogInput.class, RobotConstants.fL_encoderName);
        fR = hardwareMap.get(AnalogInput.class, RobotConstants.fR_encoderName);
        bL = hardwareMap.get(AnalogInput.class, RobotConstants.bL_encoderName);
        bR = hardwareMap.get(AnalogInput.class, RobotConstants.bR_encoderName);

        // Enable PWM for all rotation servos to activate the encoders
        fLServo.setPwmEnable();
        fRServo.setPwmEnable();
        bLServo.setPwmEnable();
        bRServo.setPwmEnable();
        fLServo.setPower(0);
        fRServo.setPower(0);
        bLServo.setPower(0);
        bRServo.setPower(0);


    }

    @Override
    public void loop() {
        telemetry.addData("FL Angle (rad)", getAngle(fL.getVoltage(), RobotConstants.fL_analogMin, RobotConstants.fL_analogMax));
        telemetry.addData("FR Angle (rad)", getAngle(fR.getVoltage(), RobotConstants.fR_analogMin, RobotConstants.fR_analogMax));
        telemetry.addData("BL Angle (rad)", getAngle(bL.getVoltage(), RobotConstants.bL_analogMin, RobotConstants.bL_analogMax));
        telemetry.addData("BR Angle (rad)", getAngle(bR.getVoltage(), RobotConstants.bR_analogMin, RobotConstants.bR_analogMax));

        telemetry.addLine();
        telemetry.addData("FL Voltage", fL.getVoltage());
        telemetry.addData("FR Voltage", fR.getVoltage());
        telemetry.addData("BL Voltage", bL.getVoltage());
        telemetry.addData("BR Voltage", bR.getVoltage());

        telemetry.update();
    }

    /**
     * Calculates the angle in radians based on the voltage and calibrated min/max values.
     */
    public double getAngle(double voltage, double min, double max) {
        // Map the voltage range [min, max] to [0, TAU]
        return ((voltage - min) / (max - min)) * TAU;
    }
}
