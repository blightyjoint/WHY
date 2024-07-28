package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
  private final CANSparkMax shooterMotor1 = new CANSparkMax(4, MotorType.kBrushless);
  private final CANSparkMax shooterMotor2 = new CANSparkMax(5, MotorType.kBrushless);
  private final SparkMaxPIDController pidController1 = shooterMotor1.getPIDController();
  private final SparkMaxPIDController pidController2 = shooterMotor2.getPIDController();

  public final double SHOOTER_CONSTANT_SPEED = 0.5;

  public ShooterSubsystem() {
    // Initialize hardware
    pidController1.setP(0.1);
    pidController1.setI(0.0);
    pidController1.setD(0.0);
    pidController1.setFF(0.0);

    pidController2.setP(0.1);
    pidController2.setI(0.0);
    pidController2.setD(0.0);
    pidController2.setFF(0.0);

    shooterMotor1.setIdleMode(CANSparkMax.IdleMode.kBrake);
    shooterMotor2.setIdleMode(CANSparkMax.IdleMode.kBrake);

    shooterMotor2.follow(shooterMotor1, true);

    pidController1.setOutputRange(-1.0, 1.0);
    pidController2.setOutputRange(-1.0, 1.0);
  }

  public void setShooterSpeed(double speed) {
    pidController1.setReference(speed, CANSparkMax.ControlType.kVelocity);
  }

  @Override
  public void periodic() {
  }
}
