package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSubsystem;

public class ArmPositionCommand extends CommandBase {
    private final ArmSubsystem armSubsystem;
    private final double targetPosition;

    public ArmPositionCommand(ArmSubsystem armSubsystem, double targetPosition) {
        this.armSubsystem = armSubsystem;
        this.targetPosition = targetPosition;
        addRequirements(armSubsystem);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        armSubsystem.stopArm();
        armSubsystem.moveToPosition(targetPosition);
    }

    @Override
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return false;
        // return armSubsystem.isAtPosition(targetPosition);
    }
}