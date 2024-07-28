package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.LimelightSubsystem;

public class ShooterCommand extends CommandBase {
  private final ShooterSubsystem shooterSubsystem;
  private final LimelightSubsystem limelightSubsystem;

  public ShooterCommand(ShooterSubsystem shooterSubsystem, LimelightSubsystem limelightSubsystem) {
    this.shooterSubsystem = shooterSubsystem;
    this.limelightSubsystem = limelightSubsystem;
    addRequirements(shooterSubsystem);
  }

  @Override
  public void execute() {
    double targetArea = limelightSubsystem.getTargetArea();
    shooterSubsystem.setShooterSpeed(shooterSubsystem.SHOOTER_CONSTANT_SPEED);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
