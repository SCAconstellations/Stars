// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.Victor;

/** Add your docs here. */
public class SwerveMotorPair {
    TalonFX m_drive;
    Victor m_rotation;
    Encoder m_rotation_encoder;

    SwerveMotorPair(TalonFX drive, Victor rotation, Encoder rotation_encoder){
        m_drive = drive;
        m_rotation = rotation;
        m_rotation_encoder = rotation_encoder;

        m_drive.configFactoryDefault();
            m_drive.setSensorPhase(false);
            m_drive.setNeutralMode(NeutralMode.Brake);
            m_drive.configOpenloopRamp(0.5);
            m_drive.configClosedloopRamp(0);
            m_drive.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor, 0, 10);
    }

    public void rotateToAngle(double angle) {
        double ticks = m_rotation_encoder.get();
        double actual_angle = ticks * Constants.ROTATION_TICKS_TO_RADIANS;

        double diff = angle - actual_angle;

        // Taking the diff into -pi and pi
        diff = diff % (2 * Math.PI);
        diff = (diff + (2 * Math.PI)) % (2 * Math.PI);
        if(diff > Math.PI) {
            diff -= (2 * Math.PI);
        }

        if(diff > 0){ // angle diff is positive
            m_rotation.set(1);
        } else{
            m_rotation.set(-1);
        }
    } 
}
