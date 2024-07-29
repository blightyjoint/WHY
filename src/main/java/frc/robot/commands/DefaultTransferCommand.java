package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TransferSubsystem;

public class DefaultTransferCommand extends CommandBase {
  private final TransferSubsystem transferSubsystem;

  public DefaultTransferCommand(TransferSubsystem transferSubsystem) {
    this.transferSubsystem = transferSubsystem;
    addRequirements(transferSubsystem);
  }

  @Override
  public void initialize() {
    transferSubsystem.stopTransfer();
  }

  @Override
  public void execute() {
    transferSubsystem.stopTransfer();
  }

  @Override
  public void end(boolean interrupted) {
    transferSubsystem.stopTransfer();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
