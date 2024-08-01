package frc.robot.commands;

import com.revrobotics.ControlType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.TransferSubsystem;

public class CloseShotCommand extends CommandBase {
  private final ShooterSubsystem shooterSubsystem;
  private final ArmSubsystem armSubsystem;
  private final TransferSubsystem transferSubsystem;
  private final double CLOSE_SHOT_ARM_POSITION = 10;

  public CloseShotCommand(ShooterSubsystem shooterSubsystem, ArmSubsystem armSubsystem,
      TransferSubsystem transferSubsystem) {
    this.shooterSubsystem = shooterSubsystem;
    this.armSubsystem = armSubsystem;
    this.transferSubsystem = transferSubsystem;
    addRequirements(shooterSubsystem, armSubsystem, transferSubsystem);
  }

  @Override
  public void initialize() {

  }

  @Override
  public void execute() {
    shooterSubsystem.shootNotes(CLOSE_SHOT_ARM_POSITION, CLOSE_SHOT_ARM_POSITION);
    transferSubsystem.setTransferSpeed(1.0);
    shooterSubsystem.stopShooter();
    armSubsystem.stopArm();
    transferSubsystem.stopTransfer();
    transferSubsystem.closeGate();

    // close shot pos
    armSubsystem.moveToPosition(CLOSE_SHOT_ARM_POSITION);
    transferSubsystem.openGate();
  }

  @Override
  public void end(boolean interrupted) {
  }

  @Override
  public boolean isFinished() {
    return false; // Run until command is interrupted
  }
}
