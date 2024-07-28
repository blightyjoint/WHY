package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSubsystem extends SubsystemBase {
  private final TalonFX shooterMotor = new TalonFX(4);

  private final TalonFXConfiguration config = new TalonFXConfiguration();

  public ShooterSubsystem() {

    var talonFXConfigs = new TalonFXConfiguration();

    config.Slot0.kP = 0.1;
    config.Slot0.kI = 0.0;
    config.Slot0.kD = 0.0;
    config.Slot0.kA = 0.0;

    var motionMagicConfigs = talonFXConfigs.MotionMagic;

    motionMagicConfigs.MotionMagicCruiseVelocity = 1000;
    motionMagicConfigs.MotionMagicAcceleration = 2000;

    shooterMotor.getConfigurator().apply(talonFXConfigs);

    // shooterMotor.configAllSettings(config);
    // shooterMotor.configSelectedFeedbackSensor();
    // shooterMotor.configNeutralDeadband(0.001);
    shooterMotor.setNeutralMode(NeutralModeValue.Brake);
  }

  public void setShooterSpeed(double speed) {
    shooterMotor.set(speed);
  }

  @Override
  public void periodic() {
  }
}
