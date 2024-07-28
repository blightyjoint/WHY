package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class ShooterSubsystem extends SubsystemBase {
  private final CANSparkMax shooterMotor = new CANSparkMax(4, MotorType.kBrushless);

  public ShooterSubsystem() {
    // Initialize hardware
  }

  public void setShooterSpeed(double speed) {
    shooterMotor.set(speed); // Example: you might need PID control here
  }

  @Override
  public void periodic() {
    // Update shooter state if needed
  }
}
