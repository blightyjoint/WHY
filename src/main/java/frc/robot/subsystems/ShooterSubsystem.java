package frc.robot.subsystems;

// import com.ctre.phoenix6.hardware.CANSparkFlex;
import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.signals.NeutralModeValue;
import com.revrobotics.CANSparkBase.ControlType;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.SparkPIDController;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {
  public static final double SHOOTER_CONSTANT_SPEED = 0;
  private final double SHOOTER_FULL_SPEED = 1.0;
  private final double SHOOTER_TARGET_POSITION = 1000;
  private final com.revrobotics.CANSparkFlex shooterMotor1 = new com.revrobotics.CANSparkFlex(
      Constants.ShooterMotor1Port,
      MotorType.kBrushless);
  private final com.revrobotics.CANSparkFlex shooterMotor2 = new com.revrobotics.CANSparkFlex(
      Constants.ShooterMotor2Port, MotorType.kBrushless);

  private SparkPIDController pidController1;
  private SparkPIDController pidController2;

  /*
   * private final com.revrobotics.CANSparkFlex shooterMotor1 = new
   * com.revrobotics.CANSparkFlex(4, null);
   * private final com.revrobotics.CANSparkFlex shooterMotor2 = new
   * com.revrobotics.CANSparkFlex(5, null);
   */

  // private final MotionMagicVoltage pidController1 = new
  // MotionMagicVoltage(SHOOTER_FULL_SPEED);
  // private final MotionMagicVoltage pidController2 = new
  // MotionMagicVoltage(SHOOTER_FULL_SPEED);

  public ShooterSubsystem() {

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

    // shooterMotor1.getConfigurator().apply(pidController1);
    // shooterMotor2.getConfigurator().apply(pidController2);

    // shooterMotor2.follow(shooterMotor1);
    // Maybe enable this ^^

    setDefaultCommand(createDefaultShooterCommand());

    shooterMotor1.burnFlash();
    shooterMotor2.burnFlash();
  }

  private Command createDefaultShooterCommand() {
    return run(() -> stopShooter());
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

  @Override
  public void periodic() {
  }

  public boolean isAtSpeed() {
    throw new UnsupportedOperationException("Unimplemented method 'isAtSpeed'");
  }
}
