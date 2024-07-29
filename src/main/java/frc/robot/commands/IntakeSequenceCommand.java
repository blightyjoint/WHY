package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.TransferSubsystem;

public class IntakeSequenceCommand extends Command {
  ShooterSubsystem shooter;
  IntakeSubsystem intake;
  TransferSubsystem transfer;
  ArmSubsystem arm;

  public IntakeSequenceCommand(ShooterSubsystem s, IntakeSubsystem i,
      TransferSubsystem t, ArmSubsystem a) {
    shooter = s;
    intake = i;
    transfer = t;
    arm = a;
    addRequirements(intake, transfer);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    intake.setIntakeSpeed(1.0);
    transfer.setTransferSpeed(1.0);
  }

  @Override
  public void end(boolean interrupted) {
    intake.setIntakeSpeed(0.0);
    transfer.setTransferSpeed(0.0);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
