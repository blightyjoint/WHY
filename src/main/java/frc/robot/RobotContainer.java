package frc.robot;

import edu.wpi.first.wpilibj.PS5Controller;
import edu.wpi.first.wpilibj2.command.button.CommandPS5Controller;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.*;
import frc.robot.commands.*;

public class RobotContainer {
  // Subsystems
  private final ArmSubsystem armSubsystem = new ArmSubsystem();
  private final IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  private final TransferSubsystem transferSubsystem = new TransferSubsystem();
  private final ShooterSubsystem shooterSubsystem = new ShooterSubsystem();
  private final LimelightSubsystem limelightSubsystem = new LimelightSubsystem();

  // Controller
  private final CommandPS5Controller controller = new CommandPS5Controller(0);

  private final IntakeSequenceCommand intakeSequenceCommand = new IntakeSequenceCommand(intakeSubsystem,
      transferSubsystem);
  private final ShootingSequenceCommand shootingSequenceCommand = new ShootingSequenceCommand(shooterSubsystem,
      limelightSubsystem);

  // Commands
  private final ArmCommand armCommand = new ArmCommand(armSubsystem, controller);
  private final IntakeCommand intakeCommand = new IntakeCommand(intakeSubsystem, null);
  private final TransferCommand transferCommand = new TransferCommand(transferSubsystem, controller);
  private final ShooterCommand shooterCommand = new ShooterCommand(shooterSubsystem, null);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {

    // controller.square().whileTrue(armCommand);
    // controller.circle().whileTrue(intakeCommand);
    // controller.cross().whileTrue(transferCommand);
    // controller.triangle().whileTrue(shooterCommand);

    controller.cross().onTrue(intakeSequenceCommand);
    controller.circle().onTrue(shootingSequenceCommand);

    controller.L1().whileTrue(new IntakeSequenceCommand(intakeSubsystem, transferSubsystem));
    controller.R1().whileTrue(new ShootingSequenceCommand(shooterSubsystem, limelightSubsystem));
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
