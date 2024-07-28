package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TransferSubsystem extends SubsystemBase {
  private final TalonFX transferMotor = new TalonFX(3);

  public TransferSubsystem() {
    // Initialize hardware
    // transferMotor.configNeutralDeadband(0.001);
    transferMotor.setNeutralMode(NeutralModeValue.Brake);
  }

  public void setTransferSpeed(double speed) {
    transferMotor.set(speed);
  }

  @Override
  public void periodic() {
  }
}
