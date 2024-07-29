package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSubsystem;

public class DefaultShooterCommand extends CommandBase {
  private final ShooterSubsystem shooterSubsystem;

  public DefaultShooterCommand(ShooterSubsystem shooterSubsystem) {
    this.shooterSubsystem = shooterSubsystem;
    addRequirements(shooterSubsystem);
  }

  @Override
  public void initialize() {
    shooterSubsystem.stopShooter();
  }

  @Override
  public void execute() {
    shooterSubsystem.stopShooter();
  }

  @Override
  public void end(boolean interrupted) {
    shooterSubsystem.stopShooter();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
