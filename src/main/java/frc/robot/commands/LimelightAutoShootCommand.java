package frc.robot.commands;

import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Limelight;
import frc.robot.subsystems.TransferSubsystem;

public class LimelightAutoShootCommand extends CommandBase {
  private final ShooterSubsystem shooterSubsystem;
  private final Limelight limelightSubsystem;
  private final TransferSubsystem transferSubsystem;

  public LimelightAutoShootCommand(ShooterSubsystem shooterSubsystem, Limelight limelightSubsystem,
      TransferSubsystem transferSubsystem) {
    this.shooterSubsystem = shooterSubsystem;
    this.limelightSubsystem = limelightSubsystem;
    this.transferSubsystem = transferSubsystem;
    addRequirements(shooterSubsystem, limelightSubsystem, transferSubsystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    if (isAlignedWithTarget()) {
      shooterSubsystem.shootNotes(0, 0);
      transferSubsystem.setTransferSpeed(1.0);
    } else {
      shooterSubsystem.stopShooter();
      transferSubsystem.stopTransfer();
    }

    transferSubsystem.openGate();

  }

  private boolean isAlignedWithTarget() {
    double targetOffset = limelightSubsystem.getTargetOffset();
    return Math.abs(targetOffset) < 1.0;
    // shooterSubsystem.stopShooter();
    // transferSubsystem.stopTransfer();
    // transferSubsystem.closeGate();
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false; // Run until command is interrupted
  }
}
