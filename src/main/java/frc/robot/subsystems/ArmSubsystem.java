package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkMaxPIDController;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsystem extends SubsystemBase {
  private final CANSparkMax armMotor = new CANSparkMax(6, MotorType.kBrushless);
  private final SparkMaxPIDController pidController = armMotor.getPIDController();

  private final double ARM_POSITION = 500;

  public ArmSubsystem() {
    // Initialize hardware
    pidController.setP(0.1);
    pidController.setI(0.0);
    pidController.setD(0.0);
    pidController.setFF(0.0);

    armMotor.setIdleMode(CANSparkMax.IdleMode.kBrake);

    pidController.setOutputRange(-1.0, 1.0);

    setDefaultCommand(new CommandBase() {
      {
        addRequirements(ArmSubsystem.this);
      }

      @Override
      public void initialize() {
        stopArm();
      }

      @Override
      public void execute() {
        stopArm();
      }

      @Override
      public void end(boolean interrupted) {
        stopArm();
      }

      @Override
      public boolean isFinished() {
        return false;
      }
    });
  }

  public void moveToPosition(double position) {
    pidController.setReference(position, CANSparkMax.ControlType.kPosition);
  }

  public void stopArm() {
    armMotor.set(0);
  }

  @Override
  public void periodic() {
  }

  public boolean isAtPosition(double position) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'isAtPosition'");
  }
}
