package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.PS5Controller;

public class ArmCommand extends CommandBase {
  private final ArmSubsystem armSubsystem;
  private final PS5Controller controller;

  public ArmCommand(ArmSubsystem armSubsystem, PS5Controller controller) {
    this.armSubsystem = armSubsystem;
    this.controller = controller;
    addRequirements(armSubsystem);
  }

  @Override
  public void execute() {
    double armPosition = controller.getLeftY() * 1000;
    armSubsystem.setArmPosition(armPosition);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
