package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSubsystem;
import edu.wpi.first.wpilibj.PS4Controller;

public class ShooterCommand extends CommandBase {
  private final ShooterSubsystem shooterSubsystem;
  private final PS4Controller controller;

  public ShooterCommand(ShooterSubsystem shooterSubsystem, PS4Controller controller) {
    this.shooterSubsystem = shooterSubsystem;
    this.controller = controller;
    addRequirements(shooterSubsystem);
  }

  @Override
  public void execute() {
    double shooterSpeed = controller.getL2Axis();
    shooterSubsystem.setShooterSpeed(shooterSpeed);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
