package frc.robot;

import edu.wpi.first.wpilibj2.command.button.CommandPS5Controller;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

public class RobotContainer {
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  private final ArmSubsystem armSubsystem = new ArmSubsystem();
  private final LimelightSubsystem limelightSubsystem = new LimelightSubsystem();
  private final TransferSubsystem transferSubsystem = new TransferSubsystem();

  private final CommandPS5Controller controller = new CommandPS5Controller(0);

  public RobotContainer() {
    configureButtonBindings();
    setDefaultCommands();
  }

  private void configureButtonBindings() {
    controller.R1().whileTrue(new IntakeSequenceCommand(intakeSubsystem, transferSubsystem, armSubsystem));
    controller.L1().whileTrue(new OuttakeCommand(intakeSubsystem, transferSubsystem));
    controller.R2().whileTrue(new ShootingSequenceCommand(shooterSubsystem, transferSubsystem));
    controller.cross().onTrue(new ArmPositionCommand(armSubsystem, 300));
    controller.triangle()
        .onTrue(new LimelightAutoShootCommand(shooterSubsystem, limelightSubsystem, transferSubsystem));
    controller.circle().onTrue(new CloseShotCommand(shooterSubsystem, armSubsystem, transferSubsystem));
  }

  private void setDefaultCommands() {
    intakeSubsystem.setDefaultCommand(new IntakeSequenceCommand(intakeSubsystem, transferSubsystem, armSubsystem));
    shooterSubsystem.setDefaultCommand(new BasicShootCommand(shooterSubsystem));
    armSubsystem.setDefaultCommand(new ArmPositionCommand(armSubsystem, 0));
    transferSubsystem.setDefaultCommand(new IdleTransferCommand(transferSubsystem));
  }
}
