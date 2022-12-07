// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

/** Add your docs here. */
public class MotorGroup {
    TalonFX[] m_motors;

    MotorGroup(TalonFX[] motors, boolean inverted) {
        assert motors.length > 0;
        m_motors = motors;

        for (TalonFX motor : m_motors) {
            motor.configFactoryDefault();
            motor.setInverted(inverted);
            motor.setSensorPhase(false);
            motor.setNeutralMode(NeutralMode.Brake);
            motor.configOpenloopRamp(0.5);
            motor.configClosedloopRamp(0);
            motor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, 0, 10);
        }
    }

    public void set(TalonFXControlMode mode, double val) {
        for (TalonFX motor : m_motors) {
            motor.set(mode, val);
        }
    }
}
