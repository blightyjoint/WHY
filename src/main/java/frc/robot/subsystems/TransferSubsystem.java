package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TransferSubsystem extends SubsystemBase {
  private final CANSparkMax transferMotor = new CANSparkMax(8, MotorType.kBrushless);
  private final Servo gateServo = new Servo(0);

  public TransferSubsystem() {
    transferMotor.setIdleMode(CANSparkMax.IdleMode.kBrake);

    setDefaultCommand(new CommandBase() {
      {
        addRequirements(TransferSubsystem.this);
      }

      @Override
      public void initialize() {
        stopTransfer();
        closeGate();
      }

      @Override
      public void execute() {
        stopTransfer();
        closeGate();
      }

      @Override
      public void end(boolean interrupted) {
        stopTransfer();
        closeGate();
      }

      @Override
      public boolean isFinished() {
        return false;
      }
    });
  }

  public void setTransferSpeed(double speed) {
    transferMotor.set(speed);
  }

  public void stopTransfer() {
    transferMotor.set(0);
  }

  public void openGate() {
    gateServo.setAngle(90);
  }

  public void closeGate() {
    gateServo.setAngle(0);
  }

  @Override
  public void periodic() {
  }
}
