package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
  private final TalonFX intakeMotor = new TalonFX(2);

  public IntakeSubsystem() {
    // Initialize hardware
    // intakeMotor.configNeutralDeadband(0.001);
    intakeMotor.setNeutralMode(NeutralModeValue.Brake);
  }

  public void setIntakeSpeed(double speed) {
    intakeMotor.set(speed);
  }

  @Override
  public void periodic() {
  }
}
