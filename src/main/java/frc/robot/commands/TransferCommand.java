package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.CommandPS5Controller;
import frc.robot.subsystems.TransferSubsystem;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.PS5Controller;

public class TransferCommand extends CommandBase {
  private final TransferSubsystem transferSubsystem;
  private final CommandPS5Controller controller;

  public TransferCommand(TransferSubsystem transferSubsystem, CommandPS5Controller controller2) {
    this.transferSubsystem = transferSubsystem;
    this.controller = controller2;
    addRequirements(transferSubsystem);
  }

  @Override
  public void execute() {
    double transferSpeed = controller.getR2Axis();
    transferSubsystem.setTransferSpeed(transferSpeed);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
