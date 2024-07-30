package frc.robot.subsystems;

// import frc.robot.controls.VelocityControlledLoop;
import com.ctre.phoenix6.controls.MotionMagicVoltage;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsystem extends SubsystemBase {
  private final VelocityControlledLoop armMotor;
  private final Servo gateServo = new Servo(0);

  private static final double P = 0.1;
  private static final double I = 0.0;
  private static final double D = 0.0;
  private static final double FF = 0.0;

  private static final double ARM_POSITION = 500;
  private static final double ARM_VELOCITY_RPM = 2000; // Example RPM value

  public ArmSubsystem() {
    // Initialize hardware
    armMotor = new VelocityControlledLoop(6, P, I, D, FF);

    setDefaultCommand(createDefaultArmCommand());
  }

  private Command createDefaultArmCommand() {
    return run(() -> {
      stopArm();
      closeGate();
    });
  }

  public void moveToPosition(double position) {
    MotionMagicVoltage motionMagic = new MotionMagicVoltage(position);
    armMotor.getMotor().setControl(motionMagic);
  }

  public void setArmSpeedRPM(double rpm) {
    armMotor.setVelocity(rpm);
  }

  public void stopArm() {
    armMotor.stop();
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

  public boolean isAtPosition(double position) {
    // TODO: Implement position checking logic
    throw new UnsupportedOperationException("Unimplemented method 'isAtPosition'");
  }
}
