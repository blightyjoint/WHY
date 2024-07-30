package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShooterSubsystem;
import frc.robot.subsystems.TransferSubsystem;

public class ShootingSequenceCommand extends CommandBase {
    private final ShooterSubsystem shooterSubsystem;
    private final TransferSubsystem transferSubsystem;
    private boolean shooterAtSpeed = false;

    public ShootingSequenceCommand(ShooterSubsystem shooterSubsystem,
            TransferSubsystem transferSubsystem) {
        this.shooterSubsystem = shooterSubsystem;
        this.transferSubsystem = transferSubsystem;

        addRequirements(shooterSubsystem, transferSubsystem);
    }

    @Override
    public void initialize() {
        shooterSubsystem.setShooterSpeed(1.0);
        transferSubsystem.closeGate();
        shooterAtSpeed = false;
    }

    @Override
    public void execute() {
        if (shooterSubsystem.isAtSpeed()) {
            shooterAtSpeed = true;
            transferSubsystem.openGate();
            transferSubsystem.setTransferSpeed(1.0);
        }
    }

    @Override
    public void end(boolean interrupted) {
        shooterSubsystem.stopShooter();
        transferSubsystem.stopTransfer();
        transferSubsystem.closeGate();
    }

    @Override
    public boolean isFinished() {
        return shooterAtSpeed && !shooterSubsystem.isAtSpeed();
    }
}