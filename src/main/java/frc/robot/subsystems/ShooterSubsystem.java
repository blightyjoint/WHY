package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
  private final CANSparkMax shooterMotor = new CANSparkMax(4, MotorType.kBrushless);
  private final SparkMaxPIDController pidController = shooterMotor.getPIDController();

  private final double SHOOTER_CONSTANT_SPEED = 0.5;

  public ShooterSubsystem() {
    // Initialize hardware
    pidController.setP(0.1);
    pidController.setI(0.0);
    pidController.setD(0.0);
    pidController.setFF(0.0);

    shooterMotor.setIdleMode(CANSparkMax.IdleMode.kBrake);
    pidController.setOutputRange(-1.0, 1.0);
  }

  public void shoot() {
    shooterMotor.set(SHOOTER_CONSTANT_SPEED);
  }

  @Override
  public void periodic() {
  }
}
