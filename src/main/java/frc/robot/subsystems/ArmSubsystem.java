package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsystem extends SubsystemBase {
  private final TalonFX armMotor = new TalonFX(1);

  private final TalonFXConfiguration config = new TalonFXConfiguration();

  public ArmSubsystem() {

    var talonFXConfigs = new TalonFXConfiguration();

    // Initialize hardware
    config.Slot0.kP = 0.1;
    config.Slot0.kI = 0.0;
    config.Slot0.kD = 0.0;
    config.Slot0.kA = 0.0;

    var motionMagicConfigs = talonFXConfigs.MotionMagic;

    motionMagicConfigs.MotionMagicCruiseVelocity = 1000;
    motionMagicConfigs.MotionMagicAcceleration = 2000;

    armMotor.getConfigurator().apply(talonFXConfigs);

    // armMotor.configAllSettings(config);
    // armMotor.configSelectedFeedbackSensor();
    // armMotor.configNeutralDeadband(0.001);
    armMotor.setNeutralMode(NeutralModeValue.Brake);
  }

  public void setArmPosition(double position) {
    armMotor.setControl(new MotionMagicVoltage(position, false, 0.0, 0, false, false, false));
  }

  @Override
  public void periodic() {
  }
}
