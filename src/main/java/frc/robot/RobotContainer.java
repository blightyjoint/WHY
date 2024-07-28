package frc.robot;

import edu.wpi.first.wpilibj.PS4Controller;
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
  private final PS4Controller controller = new PS4Controller(0);

  // Commands
  private final ArmCommand armCommand = new ArmCommand(armSubsystem, controller);
  private final IntakeCommand intakeCommand = new IntakeCommand(intakeSubsystem, null);
  // private final IntakeCommand intakeCommand = new
  // IntakeCommand(intakeSubsystem, controller);
  private final TransferCommand transferCommand = new TransferCommand(transferSubsystem, controller);
  private final ShooterCommand shooterCommand = new ShooterCommand(shooterSubsystem, controller);

  public RobotContainer() {
    configureBindings();
  }

  private void configureBindings() {
    // Button bindings
    new edu.wpi.first.wpilibj2.command.button.JoystickButton(controller, PS4Controller.Button.kSquare.value)
        .whileTrue(new ArmCommand(armSubsystem, controller));

    new edu.wpi.first.wpilibj2.command.button.JoystickButton(controller, PS4Controller.Button.kCircle.value)
        .whileTrue(new IntakeCommand(intakeSubsystem, null));

    new edu.wpi.first.wpilibj2.command.button.JoystickButton(controller, PS4Controller.Button.kCross.value)
        .whileTrue(new TransferCommand(transferSubsystem, controller));

    new edu.wpi.first.wpilibj2.command.button.JoystickButton(controller, PS4Controller.Button.kTriangle.value)
        .whileTrue(new ShooterCommand(shooterSubsystem, controller));
  }

  public Command getAutonomousCommand() {
    // Return the command to run in autonomous mode
    return null;
  }
}
