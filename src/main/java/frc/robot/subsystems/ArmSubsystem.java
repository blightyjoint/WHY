package frc.robot.subsystems;

import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ArmSubsystem extends SubsystemBase {
  private final TalonFX armMotor = new TalonFX(Constants.ArmMotorPort);

  private final double ARM_POSITION = 500;

  public ArmSubsystem() {
    TalonFXConfiguration config = new TalonFXConfiguration();
    config.Slot0.kP = 0.1;
    config.Slot0.kI = 0.0;
    config.Slot0.kD = 0.0;
    config.Slot0.kV = 0.0;
    armMotor.getConfigurator().apply(config);

    // armMotor.setInverted(InvertedValue.Clockwise_Positive;
    armMotor.setInverted(false);
    armMotor.setNeutralMode(NeutralModeValue.Brake);

    setDefaultCommand(createStopArmCommand());
  }

  private Command createStopArmCommand() {
    return run(() -> {
      stopArm();
    });
  }

  public void moveToPosition(double position) {
    armMotor.setControl(new PositionVoltage(position, position, true, 0, 0, false, false, false));
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
