package frc.robot.subsystems;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class VelocityClosedLoop extends SubsystemBase {
    private final TalonFX motor;
    private final VelocityClosedLoop velocityControl;
    double Velocity;

    public VelocityClosedLoop(int deviceID, double p, double i, double d, double ff) {
        motor = new TalonFX(deviceID);

        TalonFXConfiguration config = new TalonFXConfiguration();
        config.Slot0.kP = p;
        config.Slot0.kI = i;
        config.Slot0.kD = d;
        config.Slot0.kA = ff;

        motor.getConfigurator().apply(config);

        velocityControl = new VelocityClosedLoop(0, ff, ff, ff, ff);
    }

    public void setVelocity(double velocityRPM) {
        velocityControl.Velocity = velocityRPM;
        motor.set(1);
    }

    public void stop() {
        motor.set(0);
    }

    public TalonFX getMotor() {
        return motor;
    }

    @Override
    public void periodic() {
    }
}
