package org.firstinspires.ftc.teamcode.subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

public class Drivetrain {

    private DcMotor leftDriveMotor, rightDriveMotor;

    public DrivetrainSetup(DcMotor leftDriveMotor, DcMotor rightDriveMotor) {
        this.leftDriveMotor = leftDriveMotor;
        this.rightDriveMotor = rightDriveMotor;

        this.rightDriveMotor.setDirection(DcMotor.Direction.REVERSE);
        this.rightDriveMotor.setDirection(DcMotor.Direction.FORWARD);

        leftDriveMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        rightDriveMotor.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
    }

    public void tankDrive(double leftPower, double rightPower) {
        leftDriveMotor.setPower(leftPower);
        rightDriveMotor.setPower(rightPower);
    }

    public void arcadeDrive(double power, double turn) {
        double leftPower = Range.clip(power - turn, -1, 1);
        double rightPower = Range.clip(power + turn, -1, 1);

        tankDrive(leftPower, rightPower);
    }

    public void stop() {
        tankDrive(0, 0);
    }
}
