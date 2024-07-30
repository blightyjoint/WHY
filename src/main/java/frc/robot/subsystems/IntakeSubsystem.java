package frc.robot.subsystems;

import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeSubsystem extends SubsystemBase {
  private final TalonFX intakeMotor = new TalonFX(Constants.IntakeMotorPort);

  public IntakeSubsystem() {
    // Initialize hardware
    TalonFXConfiguration config = new TalonFXConfiguration();
    intakeMotor.getConfigurator().apply(config);

    intakeMotor.setNeutralMode(NeutralModeValue.Brake);

    setDefaultCommand(createStopIntakeCommand());
  }

  private Command createStopIntakeCommand() {
    return run(() -> {
      stopIntake();
    });
  }

  public void setIntakeSpeed(double speed) {
    intakeMotor.setControl(new VoltageOut(speed));
  }

  public void stopIntake() {
    intakeMotor.setControl(new VoltageOut(0));
  }

  @Override
  public void periodic() {
  }
}
