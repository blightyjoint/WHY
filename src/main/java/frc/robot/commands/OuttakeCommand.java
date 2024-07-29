package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.TransferSubsystem;

public class OuttakeCommand extends CommandBase {
  private final IntakeSubsystem intakeSubsystem;
  private final TransferSubsystem transferSubsystem;

  public OuttakeCommand(IntakeSubsystem intakeSubsystem, TransferSubsystem transferSubsystem) {
    this.intakeSubsystem = intakeSubsystem;
    this.transferSubsystem = transferSubsystem;
    addRequirements(intakeSubsystem, transferSubsystem);
  }

  @Override
  public void initialize() {
    intakeSubsystem.setIntakeSpeed(-1.0);
    transferSubsystem.setTransferSpeed(-1.0);
  }

  @Override
  public void execute() {
  }

  @Override
  public void end(boolean interrupted) {
    intakeSubsystem.stopIntake();
    transferSubsystem.stopTransfer();
  }

  @Override
  public boolean isFinished() {
    return false; // Run until command is interrupted
  }
}
