package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ArmSubsystem extends SubsystemBase {
  private final TalonFX armMotor = new TalonFX(16);
  private final TalonFXConfiguration talonFXConfigs = new TalonFXConfiguration();
  private final MotionMagicVoltage request = new MotionMagicVoltage(0).withSlot(0);

  private static final double P = 4;
  private static final double I = 0.0;
  private static final double D = 0.1;
  private static final double FF = 0.0;

  public ArmSubsystem() {
    configureMotor();

    var motionMagicConfigs = talonFXConfigs.MotionMagic;
    motionMagicConfigs.MotionMagicCruiseVelocity = 80;
    motionMagicConfigs.MotionMagicAcceleration = 160;
    motionMagicConfigs.MotionMagicJerk = 1600;

    armMotor.setNeutralMode(NeutralModeValue.Brake);

    setDefaultCommand(createDefaultArmCommand());
  }

  private void configureMotor() {
    talonFXConfigs.Slot0.kP = P;
    talonFXConfigs.Slot0.kI = I;
    talonFXConfigs.Slot0.kD = D;
    talonFXConfigs.Slot0.kS = 0.3;
    armMotor.getConfigurator().apply(talonFXConfigs);
  }

  private Command createDefaultArmCommand() {
    return run(() -> {
      stopArm();
      // Removed closeGate() since the servo is no longer used
    });
  }

  public void moveToPosition(double position) {
    armMotor.setControl(request.withPosition(position));
  }

  /*
   * public void setArmSpeedRPM(double rpm) {
   * armMotor.set(rpm);
   * }
   */

  public void stopArm() {
    armMotor.set(0);
  }

  @Override
  public void periodic() {
    // Add periodic code here if needed
  }

  /*
   * public boolean isAtPosition(double position) {
   * double currentPosition = armMotor.getSelectedSensorPosition();
   * return Math.abs(currentPosition - position) < 10;
   * }
   */
}
