// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.CANcoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.ConstantsOld;

public class SwerveModuleOLD extends SubsystemBase {

      private final CANSparkMax driveMotor;
      private final CANSparkMax turnMotor;

      private final RelativeEncoder driveEncoder;
      private final RelativeEncoder turnEncoder;

      private final CANcoder absoluteEncoder;
      private final boolean absoluteEncoderReversed;
      private final double  absoluteEncoderOffset;

      private final SparkPIDController turnPidController;
      private final SparkPIDController drivController;

  /** Creates a new SwerveModule. */
  public SwerveModuleOLD(int driveMotorID, int turnMotorID, boolean driveMotorReversed, 
                        boolean turnMotorReversed, int absoluteEncoderID, 
                        double absoluteEncoderOffset, boolean absoluteEncoderReversed) {

    this.absoluteEncoderOffset = absoluteEncoderOffset;
    this.absoluteEncoderReversed = absoluteEncoderReversed;
    absoluteEncoder = new CANcoder(absoluteEncoderID);

    driveMotor = new CANSparkMax(driveMotorID, MotorType.kBrushless);
    turnMotor = new CANSparkMax(turnMotorID, MotorType.kBrushless);

    driveEncoder = driveMotor.getEncoder();
    turnEncoder = turnMotor.getEncoder();

    driveEncoder.setPositionConversionFactor(ConstantsOld.kDriveEncoderRot2Meter);
    driveEncoder.setVelocityConversionFactor(ConstantsOld.kDriveEncoderRPM2MeterPerSec);
    turnEncoder.setPositionConversionFactor(ConstantsOld.kTurnMotorGearRatio);
    turnEncoder.setVelocityConversionFactor(ConstantsOld.kTurnMotorGearRatio);

    turnPidController = turnMotor.getPIDController();
    drivController = driveMotor.getPIDController();

    turnPidController.setP(ConstantsOld.kPTurning);
    turnPidController.setPositionPIDWrappingMaxInput(1);
    turnPidController.setPositionPIDWrappingMinInput(-1);
    turnPidController.setPositionPIDWrappingEnabled(true);

    resetEncoders();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public double getDrivePosition(){
    return driveEncoder.getPosition();
  }

  public double getTurnPosition(){
    return turnEncoder.getPosition();
  }

  public double getDriveVelocity(){
    return driveEncoder.getVelocity();
  }

  public double getTurnVelocity(){
    return turnEncoder.getVelocity();
  }

  public double getAbsoluteEncoderPos(){
    return absoluteEncoder.getAbsolutePosition().getValueAsDouble();
  }

  public void resetEncoders(){
    driveEncoder.setPosition(0);
    turnEncoder.setPosition(getAbsoluteEncoderPos() + absoluteEncoderOffset);
  }

  public SwerveModuleState getState(){
    return new SwerveModuleState(getDriveVelocity(), new Rotation2d(getTurnPosition()));
  }

  public void setDesiredState(SwerveModuleState state){
    if(Math.abs(state.speedMetersPerSecond) < 0.001){
      stop();
      return;
    }
    state = SwerveModuleState.optimize(state, getState().angle);
    driveMotor.set(state.speedMetersPerSecond / ConstantsOld.kPhysicalMaxSpeedMetersPerSecond);
    turnPidController.setReference(state.angle.getRotations(), CANSparkMax.ControlType.kPosition);
  }

  public void stop(){
    driveMotor.set(0);
    turnMotor.set(0);
  }
}
