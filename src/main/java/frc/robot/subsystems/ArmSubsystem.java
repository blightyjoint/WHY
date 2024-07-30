package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
// import com.ctre.phoenix6.controls.ControlType;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsystem extends SubsystemBase {
  private final TalonFX armMotor = new TalonFX(6);
  private final Servo gateServo = new Servo(0);

  private static final double P = 0.1;
  private static final double I = 0.0;
  private static final double D = 0.0;
  private static final double FF = 0.0;

  public ArmSubsystem() {
    configureMotor();

    armMotor.setNeutralMode(NeutralModeValue.Brake);

    setDefaultCommand(createDefaultArmCommand());
  }

  private void configureMotor() {
    TalonFXConfiguration config = new TalonFXConfiguration();
    config.Slot0.kP = P;
    config.Slot0.kI = I;
    config.Slot0.kD = D;
    config.Slot0.kA = FF;

  }

  private Command createDefaultArmCommand() {
    return run(() -> {
      stopArm();
      closeGate();
    });
  }

  public void moveToPosition(double position) {
    armMotor.set(position);
  }

  public void setArmSpeedRPM(double rpm) {
    armMotor.set(rpm);
  }

  public void stopArm() {
    armMotor.set(0);
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

  /*
   * public boolean isAtPosition(double position) {
   * double currentPosition = armMotor.getSelectedSensorPosition();
   * return Math.abs(currentPosition - position) < 10;
   * }
   */
}
