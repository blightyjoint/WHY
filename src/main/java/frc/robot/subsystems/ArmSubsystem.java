package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class ArmSubsystem extends SubsystemBase {
  private final CANSparkMax armMotor = new CANSparkMax(1, MotorType.kBrushless);

  public ArmSubsystem() {
    // Initialize hardware
  }

  public void setArmPosition(double position) {
    armMotor.set(position); // Example: you might need PID control here
  }

  @Override
  public void periodic() {
    // Update arm state if needed
  }
}
