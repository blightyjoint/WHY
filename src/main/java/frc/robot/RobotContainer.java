package frc.robot;

import edu.wpi.first.wpilibj.PS5Controller;
import edu.wpi.first.wpilibj2.command.button.CommandPS5Controller;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.*;
import frc.robot.commands.*;

public class RobotContainer {
  // Subsystems
  private final ArmSubsystem arm = new ArmSubsystem();
  private final IntakeSubsystem intake = new IntakeSubsystem();
  private final TransferSubsystem transfer = new TransferSubsystem();
  private final ShooterSubsystem shooter = new ShooterSubsystem();
  private final LimelightSubsystem limelight = new LimelightSubsystem();

  // Controller
  private final CommandPS5Controller controller = new CommandPS5Controller(0);

  private final IntakeSequenceCommand intakeSequenceCommand = new IntakeSequenceCommand(shooter, intake,
      transfer, arm);
  private final ShootingSequenceCommand shootingSequenceCommand = new ShootingSequenceCommand(shooter,
      limelight);

  // Commands
  private final ArmCommand armCommand = new ArmCommand(arm, controller);
  private final IntakeCommand intakeCommand = new IntakeCommand(intake, null);
  private final TransferCommand transferCommand = new TransferCommand(transfer, controller);
  private final ShooterCommand shooterCommand = new ShooterCommand(shooter, null);

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

    controller.R2().whileTrue(new IntakeSequenceCommand(shooter, intake, transfer, arm));
    controller.R1().whileTrue(new ShootingSequenceCommand(shooter, limelight));
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
