package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsystem extends SubsystemBase {
  private final CANSparkMax armMotor = new CANSparkMax(6, MotorType.kBrushless);
  private final SparkMaxPIDController pidController = armMotor.getPIDController();

  private final double ARM_POSITION = 500; // Example target position for arm

  public ArmSubsystem() {
    // Initialize hardware
    pidController.setP(0.1); // Example PID values
    pidController.setI(0.0);
    pidController.setD(0.0);
    pidController.setFF(0.0);

    armMotor.setIdleMode(CANSparkMax.IdleMode.kBrake);

    // Configure PID Controller for Motion Magic
    pidController.setOutputRange(-1.0, 1.0); // Ensure output range
  }

  public void moveToPosition(double cLOSE_SHOT_ARM_POSITION) {
    // Set target position for Motion Magic
    pidController.setReference(ARM_POSITION, CANSparkMax.ControlType.kPosition);
  }

  public void stopArm() {
    armMotor.set(0);
  }

  @Override
  public void periodic() {
    // Update arm state if needed
  }

public boolean isAtPosition(double iNTAKE_ARM_POSITION) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'isAtPosition'");
}
}
