package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;

public class LimelightSubsystem extends SubsystemBase {
  private final NetworkTable limelightTable = NetworkTableInstance.getDefault().getTable("limelight");

  public LimelightSubsystem() {
    setDefaultCommand(new CommandBase() {
      {
        addRequirements(LimelightSubsystem.this);
      }

      @Override
      public void initialize() {
        setLEDMode(1);
        setCamMode(0);
      }

      @Override
      public void execute() {
      }

      @Override
      public void end(boolean interrupted) {
      }

      @Override
      public boolean isFinished() {
        return false;
      }
    });
  }

  public double getTargetOffset() {
    return limelightTable.getEntry("tx").getDouble(0.0);
  }

  public double getTargetArea() {
    return limelightTable.getEntry("ta").getDouble(0.0);
  }

  public void setLEDMode(int mode) {
    limelightTable.getEntry("ledMode").setNumber(mode);
  }

  public void setCamMode(int mode) {
    limelightTable.getEntry("camMode").setNumber(mode);
  }

  public void setPipeline(int pipeline) {
    limelightTable.getEntry("pipeline").setNumber(pipeline);
  }

  @Override
  public void periodic() {
  }
}
