package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.TransferSubsystem;

public class IntakeSequenceCommand extends CommandBase {
  private final IntakeSubsystem intakeSubsystem;
  private final TransferSubsystem transferSubsystem;

  public IntakeSequenceCommand(IntakeSubsystem intakeSubsystem, TransferSubsystem transferSubsystem) {
    this.intakeSubsystem = intakeSubsystem;
    this.transferSubsystem = transferSubsystem;
    addRequirements(intakeSubsystem, transferSubsystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    intakeSubsystem.setIntakeSpeed(1.0);
    transferSubsystem.setTransferSpeed(1.0);
  }

  @Override
  public void end(boolean interrupted) {
    intakeSubsystem.setIntakeSpeed(0.0);
    transferSubsystem.setTransferSpeed(0.0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
