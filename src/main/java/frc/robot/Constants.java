// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.trajectory.TrapezoidProfile;
import edu.wpi.first.math.util.Units;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

    public final class USB{
        public static final int DRIVER_CONTROLLER = 0;      // Driver Controller USB ID
        public static final int OPERATOR_CONTROLLER = 1;    // Operator controller USB ID
        public static final int OPERATOR_LY = 1;
        public static final int OPERATOR_LX = 0;
        public static final int OPERATOR_RY = 5;
        public static final int OPERATOR_RX = 4;
        public static final int OPERATOR_RT = 3;
        public static final int OPERATOR_LT = 2;
    }

    public final class ModuleConstants{
        public static final double kWheelDiameterMeters = Units.inchesToMeters(3);
        public static final double kDriveMotorGearRatio = 1 / 8.14;
        public static final double kTurningMotorGearRatio = 1 / 12.8;
        public static final double kDriveEncoderRot2Meter = kDriveMotorGearRatio * Math.PI * kWheelDiameterMeters;
        public static final double kTurnEncoderRot2Rad = kTurningMotorGearRatio * 2 * Math.PI;
        public static final double kDriveEncoderRPM2MeterPerSec = kDriveEncoderRot2Meter / 60;
        public static final double kTurnEncoderRPM2RadPerSec = kTurnEncoderRot2Rad / 60;
        public static final double kPTurning = 0.6;
        public static int kDriveMotorCurrentLimit = 30;
        public static int kTurnMotorCurrentLimit = 30;
    }

    public final class Sensors{
      public static final int GYRO_ID = 16;
    }

    public final class Feeder{
        public static final int outerMotorID = 0;
        public static final int innerMotorID = 0;
        public static final int positionMotorID = 0;

        public static final double outerMotorKP = 0.01;
        public static final double outerMotorKI = 0.0;
        public static final double outerMotorKD = 0.0;
        public static final double outerMotorMAX = 1.0;
        public static final double outerMotorMIN = -1.0;
        public static final double innerMotorKP = 0.01;
        public static final double innerMotorKI = 0.0;
        public static final double innerMotorKD = 0.0;
        public static final int outerMotorCurrentLimit = 10;
        public static final int innerMotorCurrentLimit = 10;
        public static final int positionMotorCurrentLimit = 5;
        public static final double innerMotorMIN = -1.0;
        public static final double innerMotorMAX = 1.0;
        public static final double positionMotorKP = 0.01;
        public static final double positionMotorKI = 0.0;
        public static final double positionMotorKD = 0.0;
        public static final double positionMotorMIN = -0.25;
        public static final double positionMotorMAX = 0.25;
    }

    public static final class DriveConstants {

        public static final double kTrackWidth = Units.inchesToMeters(21);
        // Distance between right and left wheels
        public static final double kWheelBase = Units.inchesToMeters(21);
        // Distance between front and back wheels
        public static final SwerveDriveKinematics kDriveKinematics = new SwerveDriveKinematics(
                new Translation2d(kWheelBase / 2, -kTrackWidth / 2),
                new Translation2d(kWheelBase / 2, kTrackWidth / 2),
                new Translation2d(-kWheelBase / 2, -kTrackWidth / 2),
                new Translation2d(-kWheelBase / 2, kTrackWidth / 2));

        public static final int kFrontLeftDriveMotorPort = 8;
        public static final int kFrontLeftTurningMotorPort = 7;

        public static final int kBackLeftDriveMotorPort = 6;
        public static final int kBackLeftTurningMotorPort = 5;

        public static final int kFrontRightDriveMotorPort = 2;
        public static final int kFrontRightTurningMotorPort = 1;

        public static final int kBackRightDriveMotorPort = 4;
        public static final int kBackRightTurningMotorPort = 3;

        public static final boolean kFrontLeftTurningEncoderReversed = false;
        public static final boolean kBackLeftTurningEncoderReversed = false;
        public static final boolean kFrontRightTurningEncoderReversed = false;
        public static final boolean kBackRightTurningEncoderReversed = false;

        public static final boolean kFrontLeftDriveReversed = false;
        public static final boolean kBackLeftDriveReversed = false;
        public static final boolean kFrontRightDriveReversed = true;
        public static final boolean kBackRightDriveReversed = true;

        public static final int kFrontLeftDriveAbsoluteEncoderPort = 12;
        public static final int kBackLeftDriveAbsoluteEncoderPort = 14;
        public static final int kFrontRightDriveAbsoluteEncoderPort = 13;
        public static final int kBackRightDriveAbsoluteEncoderPort = 15;

        public static final boolean kFrontLeftDriveAbsoluteEncoderReversed = true;
        public static final boolean kBackLeftDriveAbsoluteEncoderReversed = true;
        public static final boolean kFrontRightDriveAbsoluteEncoderReversed = true;
        public static final boolean kBackRightDriveAbsoluteEncoderReversed = true;

        public static final double kFrontLeftDriveAbsoluteEncoderOffsetRad = 0.0;
        public static final double kBackLeftDriveAbsoluteEncoderOffsetRad = 0.0;
        public static final double kFrontRightDriveAbsoluteEncoderOffsetRad = 0.0;
        public static final double kBackRightDriveAbsoluteEncoderOffsetRad = 0.0;

        public static final double kPhysicalMaxSpeedMetersPerSecond = 3.81;
        public static final double kPhysicalMaxAngularSpeedRadiansPerSecond = 2 * 2 * Math.PI;

        public static final double kTeleDriveMaxSpeedMetersPerSecond = kPhysicalMaxSpeedMetersPerSecond / 1.5;
        public static final double kTeleDriveMaxAngularSpeedRadiansPerSecond = kPhysicalMaxAngularSpeedRadiansPerSecond / 4;
        public static final double kTeleDriveMaxAccelerationUnitsPerSecond = 3;
        public static final double kTeleDriveMaxAngularAccelerationUnitsPerSecond = 3;

        public static final double kSlowButtonDriveModifier = 0.25;
        public static final double kSlowButtonTurnModifier = 0.5;
    }

    public static final class AutoConstants {
        public static final double kMaxSpeedMetersPerSecond = DriveConstants.kPhysicalMaxSpeedMetersPerSecond / 8;
        public static final double kMaxAngularSpeedRadiansPerSecond = DriveConstants.kPhysicalMaxAngularSpeedRadiansPerSecond / 10;
        public static final double kMaxAccelerationMetersPerSecondSquared = 3;
        public static final double kMaxAngularAccelerationRadiansPerSecondSquared = Math.PI / 4;
        public static final double kPXController = 1.5;
        public static final double kPYController = 1.5;
        public static final double kPThetaController = 3;

        public static final TrapezoidProfile.Constraints kThetaControllerConstraints = //
                new TrapezoidProfile.Constraints(
                        kMaxAngularSpeedRadiansPerSecond,
                        kMaxAngularAccelerationRadiansPerSecondSquared);
    }

    public static final class OIConstants {
        public static final int kDriverControllerPort = 0;

        public static final int kDriverYAxis = 1;
        public static final int kDriverXAxis = 0;
        public static final int kDriverRotAxis = 4;
        public static final int kDriverFieldOrientedButtonIdx = 1;

        public static final double kDeadband = 0.05;
    }

}
