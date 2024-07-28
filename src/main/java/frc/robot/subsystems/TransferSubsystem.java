package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TransferSubsystem extends SubsystemBase {
  private final TalonFX transferMotor = new TalonFX(3);

  private final TalonFXConfiguration config = new TalonFXConfiguration();

  public TransferSubsystem() {

    var talonFXConfigs = new TalonFXConfiguration();

    // Initialize hardware
    config.Slot0.kP = 0.0;
    config.Slot0.kI = 0.0;
    config.Slot0.kD = 0.0;
    config.Slot0.kA = 0.0;

    var motionMagicConfigs = talonFXConfigs.MotionMagic;
    motionMagicConfigs.MotionMagicCruiseVelocity = 1000;
    motionMagicConfigs.MotionMagicAcceleration = 2000;

    transferMotor.getConfigurator().apply(talonFXConfigs);

    // transferMotor.configAllSettings(config);
    // transferMotor.configNeutralDeadband(0.001);
    transferMotor.setNeutralMode(NeutralModeValue.Brake);
  }

  public void setTransferSpeed(double speed) {
    transferMotor.set(speed);
  }

  @Override
  public void periodic() {
  }
}
