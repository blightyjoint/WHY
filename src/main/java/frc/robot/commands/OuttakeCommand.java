package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.TransferSubsystem;

public class OuttakeCommand extends CommandBase {
  private final frc.robot.commands.IntakeSubsystem intakeSubsystem;
  private final TransferSubsystem transferSubsystem;

  public OuttakeCommand(frc.robot.commands.IntakeSubsystem intakeSubsystem2, TransferSubsystem transferSubsystem) {
    this.intakeSubsystem = intakeSubsystem2;
    this.transferSubsystem = transferSubsystem;
    addRequirements(intakeSubsystem2, transferSubsystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    intakeSubsystem.setIntakeSpeed(-1.0);
    transferSubsystem.setTransferSpeed(-1.0);
  }

  @Override
  public void end(boolean interrupted) {
    intakeSubsystem.setIntakeSpeed(0);
    transferSubsystem.setTransferSpeed(0);
    transferSubsystem.closeGate();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
