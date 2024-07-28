package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.PS5Controller;

public class IntakeCommand extends CommandBase {
  private final IntakeSubsystem intakeSubsystem;
  private final PS5Controller controller;

  public IntakeCommand(IntakeSubsystem intakeSubsystem, PS5Controller controller) {
    this.intakeSubsystem = intakeSubsystem;
    this.controller = controller;
    addRequirements(intakeSubsystem);
  }

  @Override
  public void execute() {
    double intakeSpeed = controller.getRightY();
    intakeSubsystem.setIntakeSpeed(intakeSpeed);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
