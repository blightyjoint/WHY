package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSubsystem;

public class BasicShootCommand extends CommandBase {
  private final ShooterSubsystem shooterSubsystem;

  public BasicShootCommand(ShooterSubsystem shooterSubsystem) {
    this.shooterSubsystem = shooterSubsystem;
    addRequirements(shooterSubsystem);
  }

  @Override
  public void initialize() {
    shooterSubsystem.setShooterSpeed(0.5);
  }

  @Override
  public void execute() {
  }

  @Override
  public void end(boolean interrupted) {
    shooterSubsystem.stopShooter();
  }

  @Override
  public boolean isFinished() {
    return false; // Run until command is interrupted
  }
}
