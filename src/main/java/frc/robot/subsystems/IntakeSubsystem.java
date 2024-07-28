package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
  private final TalonFX intakeMotor = new TalonFX(2);

  private final TalonFXConfiguration config = new TalonFXConfiguration();

  public IntakeSubsystem() {

    var talonFXConfigs = new TalonFXConfiguration();

    config.Slot0.kP = 0.1;
    config.Slot0.kI = 0.0;
    config.Slot0.kD = 0.0;
    config.Slot0.kV = 0.0;

    intakeMotor.getConfigurator().apply(talonFXConfigs);
    // intakeMotor.configAllSettings(config);
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
