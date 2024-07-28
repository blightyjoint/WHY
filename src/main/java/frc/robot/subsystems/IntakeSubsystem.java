package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class IntakeSubsystem extends SubsystemBase {
  private final CANSparkMax intakeMotor = new CANSparkMax(2, MotorType.kBrushless);

  public IntakeSubsystem() {
    // Initialize hardware
  }

  public void setIntakeSpeed(double speed) {
    intakeMotor.set(speed); // Example: you might need PID control here
  }

  @Override
  public void periodic() {
    // Update intake state if needed
  }
}
