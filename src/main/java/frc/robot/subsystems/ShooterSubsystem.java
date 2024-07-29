package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
  public static final double SHOOTER_CONSTANT_SPEED = 0;
  private final CANSparkMax shooterMotor1 = new CANSparkMax(4, MotorType.kBrushless);
  private final CANSparkMax shooterMotor2 = new CANSparkMax(5, MotorType.kBrushless);
  private final SparkMaxPIDController pidController1 = shooterMotor1.getPIDController();
  private final SparkMaxPIDController pidController2 = shooterMotor2.getPIDController();

  private final double SHOOTER_FULL_SPEED = 1.0; // Full speed
  private final double SHOOTER_TARGET_POSITION = 1000; // Example target position for Motion Magic

  public ShooterSubsystem() {
    // Initialize hardware
    pidController1.setP(0.1); // Example PID values
    pidController1.setI(0.0);
    pidController1.setD(0.0);
    pidController1.setFF(0.0);

    pidController2.setP(0.1); // Example PID values
    pidController2.setI(0.0);
    pidController2.setD(0.0);
    pidController2.setFF(0.0);

    shooterMotor1.setIdleMode(CANSparkMax.IdleMode.kBrake);
    shooterMotor2.setIdleMode(CANSparkMax.IdleMode.kBrake);

    // Set the motors to follow each other
    shooterMotor2.follow(shooterMotor1, true); // true for inverted, adjust as needed

    // Configure PID Controller for Motion Magic
    pidController1.setOutputRange(-1.0, 1.0); // Ensure output range
    pidController2.setOutputRange(-1.0, 1.0); // Ensure output range
  }

  public void shootNotes() {
    // Set target position for Motion Magic
    pidController1.setReference(SHOOTER_TARGET_POSITION, CANSparkMax.ControlType.kPosition);
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
    // Update shooter state if needed
  }

  public boolean isAtSpeed() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'isAtSpeed'");
  }
}
