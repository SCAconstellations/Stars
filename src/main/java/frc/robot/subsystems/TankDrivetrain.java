// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.TalonFXControlMode;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.MotorGroup;
import frc.robot.IDrivetrain;


public class TankDrivetrain extends SubsystemBase implements IDrivetrain {
  public final MotorGroup m_motor_group_right;
  public final MotorGroup m_motor_group_left;

  /** Creates a new ExampleSubsystem. */
  public TankDrivetrain(MotorGroup motor_group_right, MotorGroup motor_group_left) {
    m_motor_group_right = motor_group_right;
    m_motor_group_left = motor_group_left;
  }

  // Things are driving without the drivetrain
  public void driveStraight(double percentage) {
    m_motor_group_right.set(TalonFXControlMode.PercentOutput, percentage);
    m_motor_group_left.set(TalonFXControlMode.PercentOutput, percentage);
  }

  public void turnLeft(double percentage) {
    m_motor_group_right.set(TalonFXControlMode.PercentOutput, percentage);
    m_motor_group_left.set(TalonFXControlMode.PercentOutput, -percentage);
  }

  public void turnRight(double percentage) {
     m_motor_group_right.set(TalonFXControlMode.PercentOutput, -percentage);
    m_motor_group_left.set(TalonFXControlMode.PercentOutput, percentage);
    
  }

  public void driveBack(double percentage) {
     m_motor_group_right.set(TalonFXControlMode.PercentOutput, -percentage);
    m_motor_group_left.set(TalonFXControlMode.PercentOutput, -percentage);
  }

  public void driveStop() {
     m_motor_group_right.set(TalonFXControlMode.PercentOutput, 0);
    m_motor_group_left.set(TalonFXControlMode.PercentOutput, 0);
  }

  public void driveHardStop() {
    m_motor_group_right.set(TalonFXControlMode.Velocity, 0);
    m_motor_group_left.set(TalonFXControlMode.Velocity, 0);
  }
}