package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class TransferSubsystem extends SubsystemBase {
  private final CANSparkMax transferMotor = new CANSparkMax(3, MotorType.kBrushless);

  public TransferSubsystem() {
    // Initialize hardware
  }

  public void setTransferSpeed(double speed) {
    transferMotor.set(speed); // Example: you might need PID control here
  }

  @Override
  public void periodic() {
    // Update transfer state if needed
  }
}
