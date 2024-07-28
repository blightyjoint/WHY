package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;

public class LimelightSubsystem extends SubsystemBase {
  private final NetworkTable limelightTable;

  public LimelightSubsystem() {
    limelightTable = NetworkTableInstance.getDefault().getTable("limelight");
  }

  public double getTargetX() {
    return limelightTable.getEntry("tx").getDouble(0.0);
  }

  public double getTargetY() {
    return limelightTable.getEntry("ty").getDouble(0.0);
  }

  @Override
  public void periodic() {
  }
}
