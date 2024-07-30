package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;

public class DefaultIntakeCommand extends CommandBase {
  private final frc.robot.commands.IntakeSubsystem intakeSubsystem;

  public DefaultIntakeCommand(frc.robot.commands.IntakeSubsystem intakeSubsystem2) {
    this.intakeSubsystem = intakeSubsystem2;
    addRequirements(intakeSubsystem2);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    intakeSubsystem.stopIntake();
    intakeSubsystem.stopIntake();
    intakeSubsystem.stopIntake();
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
