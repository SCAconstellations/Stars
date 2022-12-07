// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    //Controller declaration
    public static final int DRIVER_CONTROLLER = 0;
    public static final int OP_CONTROLLER = 1;
    
    //
    public static final double WHEEL_DIAMETER = 6.0;
    public static final double DRIVETRAIN_GEAR_RATIO = 7.56;
    public static final double ENCODER_TICKS_IN_REV = 2048;
    public static final double MULTIPLY_TICS_BY_THIS_TO_FIND_INCHES_WHEELS_MOVED = (((WHEEL_DIAMETER * Math.PI) / DRIVETRAIN_GEAR_RATIO) / ENCODER_TICKS_IN_REV );
}
