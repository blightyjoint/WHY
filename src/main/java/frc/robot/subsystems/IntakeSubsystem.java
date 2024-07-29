package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
  private final CANSparkMax intakeMotor = new CANSparkMax(7, MotorType.kBrushless);

  public IntakeSubsystem() {
    intakeMotor.setIdleMode(CANSparkMax.IdleMode.kBrake);

    setDefaultCommand(createStopIntakeCommand());
  }

  private Command createStopIntakeCommand() {
    return run(() -> {
      stopIntake();
    });
  }

  public void setIntakeSpeed(double speed) {
    intakeMotor.set(speed);
  }

  public void stopIntake() {
    intakeMotor.set(0);
  }

  @Override
  public void periodic() {
  }
}
