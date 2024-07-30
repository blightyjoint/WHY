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
        armSubsystem.moveToPosition(targetPosition);
    }

    @Override
    public void execute() {

    }

    @Override
    public void end(boolean interrupted) {
        armSubsystem.stopArm();
    }

    @Override
    public boolean isFinished() {
        return false;
        // return armSubsystem.isAtPosition(targetPosition);
    }
}