package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandPS5Controller;
import frc.robot.commands.*;
import frc.robot.commands.IntakeSubsystem;
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
  }

  private void configureButtonBindings() {
    controller.R1().whileTrue(new IntakeSequenceCommand(intakeSubsystem, transferSubsystem, armSubsystem));
    controller.L1().whileTrue(new OuttakeCommand(intakeSubsystem, transferSubsystem));
    // controller.R2().whileTrue(new ShootingSequenceCommand(shooterSubsystem,
    // transferSubsystem));
    // controller.cross().whileTrue(new ArmPositionCommand(armSubsystem, 56));
    controller.triangle()
        .whileTrue(new LimelightAutoShootCommand(shooterSubsystem, limelightSubsystem, transferSubsystem));
    controller.circle().whileTrue(new CloseShotCommand(shooterSubsystem, armSubsystem, transferSubsystem));
  }

  public Command getAutonomousCommand() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'getAutonomousCommand'");
  }
}
