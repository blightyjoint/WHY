package frc.robot;

import edu.wpi.first.wpilibj.PS5Controller;
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
  private final PS5Controller controller = new PS5Controller(0);

  // Commands
  private final ArmCommand armCommand = new ArmCommand(armSubsystem, controller);
  private final IntakeCommand intakeCommand = new IntakeCommand(intakeSubsystem, null);
  private final TransferCommand transferCommand = new TransferCommand(transferSubsystem, controller);
  private final ShooterCommand shooterCommand = new ShooterCommand(shooterSubsystem, null);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    // Button bindings
    new edu.wpi.first.wpilibj2.command.button.JoystickButton(controller, PS5Controller.Button.kSquare.value)
        .whileTrue(armCommand);

    new edu.wpi.first.wpilibj2.command.button.JoystickButton(controller, PS5Controller.Button.kCircle.value)
        .whileTrue(intakeCommand);

    new edu.wpi.first.wpilibj2.command.button.JoystickButton(controller, PS5Controller.Button.kCross.value)
        .whileTrue(transferCommand);

    new edu.wpi.first.wpilibj2.command.button.JoystickButton(controller, PS5Controller.Button.kTriangle.value)
        .whileTrue(shooterCommand);
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
