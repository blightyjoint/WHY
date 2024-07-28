package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.TransferSubsystem;
import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj.PS5Controller;

public class TransferCommand extends CommandBase {
  private final TransferSubsystem transferSubsystem;
  private final PS5Controller controller;

  public TransferCommand(TransferSubsystem transferSubsystem, PS5Controller controller) {
    this.transferSubsystem = transferSubsystem;
    this.controller = controller;
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
