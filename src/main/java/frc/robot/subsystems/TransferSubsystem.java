package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class TransferSubsystem extends SubsystemBase {
  private final TalonFX transferMotor = new TalonFX(Constants.TransferMotorPort);
  private final Servo gateServo = new Servo(0);

  public TransferSubsystem() {
    transferMotor.setNeutralMode(NeutralModeValue.Brake);

    setDefaultCommand(createDefaultTransferCommand());
  }

  private Command createDefaultTransferCommand() {
    return run(() -> {
      stopTransfer();
      closeGate();
    });
  }

  public void setTransferSpeed(double speed) {
    transferMotor.set(speed);
  }

  public void stopTransfer() {
    transferMotor.set(0);
  }

  public void openGate() {
    gateServo.setAngle(0.6);
  }

  public void closeGate() {
    gateServo.setAngle(0.0);
  }

  @Override
  public void periodic() {
  }
}
