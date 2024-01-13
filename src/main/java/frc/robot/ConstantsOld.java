// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.util.Units;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class ConstantsOld {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

public static final double kWheelDiameterMeters             = Units.inchesToMeters(3);
public static final double kDriveMotorGearRatio             = 1/8.14;
public static final double kTurnMotorGearRatio              = 1/12.8;
public static final double kDriveEncoderRot2Meter           = kDriveMotorGearRatio * Math.PI * kWheelDiameterMeters;
public static final double kDriveEncoderRPM2MeterPerSec     = kDriveEncoderRot2Meter / 60;
public static final double kTurnEncoderRatio                = kTurnMotorGearRatio * 2 * Math.PI;
public static final double kPTurning                        = 0.5;
public static final double kPhysicalMaxSpeedMetersPerSecond = 3.81;
public static int kFrontLeftDriveMotorID;
public static int kFrontLeftTurnMotorID;
public static boolean kFrontLeftDriveEncoderReversed;
public static boolean kFrontLeftTurnEncoderReversed;
public static int kFrontLeftAbsoluteEncoderID;
public static double kFrontLeftEncoderOffset;
public static boolean kFrontLeftAbsoluteEncoderReversed;
public static int kFrontRightDriveMotorID;
public static int kFrontRightTurnMotorID;
public static boolean kFrontRightDriveEncoderReversed;
public static boolean kFrontRightTurnEncoderReversed;
public static int kFrontRightAbsoluteEncoderID;
public static double kFrontRightEncoderOffset;
public static boolean kFrontRightAbsoluteEncoderReversed;
public static int kbackLeftDriveMotorID;
public static int kbackLeftTurnMotorID;
public static boolean kbackLeftDriveEncoderReversed;
public static boolean kbackLeftTurnEncoderReversed;
public static int kbackLeftAbsoluteEncoderID;
public static double kbackLeftEncoderOffset;
public static boolean kbackLeftAbsoluteEncoderReversed;
public static int kbackRightDriveMotorID;
public static int kbackRightTurnMotorID;
public static boolean kbackRightDriveEncoderReversed;
public static boolean kbackRightTurnEncoderReversed;
public static int kbackRightAbsoluteEncoderID;
public static double kbackRightEncoderOffset;
public static boolean kbackRightAbsoluteEncoderReversed;
public static int kPigeon2ID;
}
