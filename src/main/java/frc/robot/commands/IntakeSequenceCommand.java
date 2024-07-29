package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.TransferSubsystem;

public class IntakeSequenceCommand extends CommandBase {
  private final IntakeSubsystem intakeSubsystem;
  private final TransferSubsystem transferSubsystem;
  private final ArmSubsystem armSubsystem;
  private final double INTAKE_ARM_POSITION = 100;

  public IntakeSequenceCommand(IntakeSubsystem intakeSubsystem, TransferSubsystem transferSubsystem,
      ArmSubsystem armSubsystem) {
    this.intakeSubsystem = intakeSubsystem;
    this.transferSubsystem = transferSubsystem;
    this.armSubsystem = armSubsystem;
    addRequirements(intakeSubsystem, transferSubsystem, armSubsystem);
  }

  @Override
  public void initialize() {
    armSubsystem.moveToPosition(INTAKE_ARM_POSITION);
    transferSubsystem.closeGate();
  }

  @Override
  public void execute() {
    if (armSubsystem.isAtPosition(INTAKE_ARM_POSITION)) {
      intakeSubsystem.setIntakeSpeed(1.0);
      transferSubsystem.setTransferSpeed(1.0);
    }
  }

  @Override
  public void end(boolean interrupted) {
    intakeSubsystem.stopIntake();
    transferSubsystem.stopTransfer();
    armSubsystem.stopArm();
  }

  @Override
  public boolean isFinished() {
    return false; // Run until command is interrupted
  }
}
