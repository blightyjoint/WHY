package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;

public class DefaultArmCommand extends CommandBase {
  private final ArmSubsystem armSubsystem;

  public DefaultArmCommand(ArmSubsystem armSubsystem) {
    this.armSubsystem = armSubsystem;
    addRequirements(armSubsystem);
  }

  @Override
  public void initialize() {
    armSubsystem.stopArm();
  }

  @Override
  public void execute() {
    armSubsystem.stopArm();
  }

  @Override
  public void end(boolean interrupted) {
    armSubsystem.stopArm();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
