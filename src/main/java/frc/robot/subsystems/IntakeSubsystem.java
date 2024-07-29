package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class IntakeSubsystem extends SubsystemBase {
  private final CANSparkMax intakeMotor = new CANSparkMax(7, MotorType.kBrushless);

  public IntakeSubsystem() {
    intakeMotor.setIdleMode(CANSparkMax.IdleMode.kBrake);

    setDefaultCommand(new CommandBase() {
      {
        addRequirements(IntakeSubsystem.this);
      }

      @Override
      public void initialize() {
        stopIntake();
      }

      @Override
      public void execute() {
        stopIntake();
      }

      @Override
      public void end(boolean interrupted) {
        stopIntake();
      }

      @Override
      public boolean isFinished() {
        return false;
      }
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
