package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.ControlType;
import com.revrobotics.CANEncoder;
import com.revrobotics.SparkMaxPIDController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {
  public static final double SHOOTER_CONSTANT_SPEED = 0;
  private final double SHOOTER_FULL_SPEED = 1.0;
  private final double SHOOTER_TARGET_POSITION = 1000;

  private final CANSparkMax shooterMotor1;
  private final CANSparkMax shooterMotor2;
  private final SparkMaxPIDController pidController1;
  private final SparkMaxPIDController pidController2;
  private final CANEncoder encoder1;
  private final CANEncoder encoder2;

  private boolean shooterSpeedReached;

  public ShooterSubsystem() {
    shooterMotor1 = new CANSparkMax(Constants.ShooterMotor1Port, MotorType.kBrushless);
    shooterMotor2 = new CANSparkMax(Constants.ShooterMotor2Port, MotorType.kBrushless);
    pidController1 = shooterMotor1.getPIDController();
    pidController2 = shooterMotor2.getPIDController();
    encoder1 = shooterMotor1.getEncoder();
    encoder2 = shooterMotor2.getEncoder();

    shooterMotor1.restoreFactoryDefaults();
    shooterMotor2.restoreFactoryDefaults();

    // Set PID values for pidController1
    pidController1.setFF(0.002);
    pidController1.setP(0.002);
    pidController1.setI(0.000);
    pidController1.setD(0.001);
    pidController1.setOutputRange(0, 6000);

    // Set PID values for pidController2
    pidController2.setFF(0.002);
    pidController2.setP(0.002);
    pidController2.setI(0.000);
    pidController2.setD(0.001);
    pidController2.setOutputRange(0, 6000);

    setDefaultCommand(createDefaultShooterCommand());

    shooterMotor1.burnFlash();
    shooterMotor2.burnFlash();
  }

  private Command createDefaultShooterCommand() {
    return run(this::stopShooter);
  }

  public void shootNotes(double setPoint1, double setPoint2) {
    pidController1.setReference(setPoint1, ControlType.kVelocity);
    pidController2.setReference(setPoint2, ControlType.kVelocity);
  }

  public void setShooterSpeed(double speed) {
    shooterMotor1.set(speed);
  }

  public void stopShooter() {
    shooterMotor1.set(0);
    shooterMotor2.set(0);
  }

  public void setShooterRPM(double leftFlywheelSetPoint, double rightFlywheelSetPoint) {
    shooterSpeedReached = false;
    pidController1.setReference(leftFlywheelSetPoint, ControlType.kVelocity);
    pidController2.setReference(rightFlywheelSetPoint, ControlType.kVelocity);

    double leftVelocity = encoder1.getVelocity();
    double rightVelocity = encoder2.getVelocity();

    if (leftVelocity > leftFlywheelSetPoint * 0.9 && leftVelocity < leftFlywheelSetPoint * 1.1 &&
        rightVelocity > rightFlywheelSetPoint * 0.9 && rightVelocity < rightFlywheelSetPoint * 1.1) {
      shooterSpeedReached = true;
    } else {
      shooterSpeedReached = false;
    }
  }

  @Override
  public void periodic() {
    // Optionally, you can add periodic checks or updates here
  }

  public boolean isAtSpeed() {
    return shooterSpeedReached;
  }
}
