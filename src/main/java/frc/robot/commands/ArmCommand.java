package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.CommandPS5Controller;
import frc.robot.subsystems.ArmSubsystem;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.PS5Controller;

public class ArmCommand extends CommandBase {
  private final ArmSubsystem armSubsystem;
  private final CommandPS5Controller controller;

  public ArmCommand(ArmSubsystem armSubsystem, CommandPS5Controller controller2) {
    this.armSubsystem = armSubsystem;
    this.controller = controller2;
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

public Command setArmPositon(Object object) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'setArmPositon'");
}
}
