package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.LimelightSubsystem;
import edu.wpi.first.wpilibj.PS5Controller;

public class ShooterCommand extends CommandBase {
  private final ShooterSubsystem shooterSubsystem;
  private final LimelightSubsystem limelightSubsystem;
  private final PS5Controller controller;

  public ShooterCommand(ShooterSubsystem shooterSubsystem, LimelightSubsystem controller) {
    this.shooterSubsystem = shooterSubsystem;
    this.limelightSubsystem = controller;
    this.controller = null;
    addRequirements(shooterSubsystem);
  }

  @Override
  public void execute() {
    double targetArea = limelightSubsystem.getTargetArea();
    shooterSubsystem.shoot();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
