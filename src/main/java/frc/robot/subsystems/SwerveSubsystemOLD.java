// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.Pigeon2;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.ConstantsOld;

public class SwerveSubsystemOLD extends SubsystemBase {

  private final SwerveModuleOLD frontLeft = new SwerveModuleOLD(
    ConstantsOld.kFrontLeftDriveMotorID,
    ConstantsOld.kFrontLeftTurnMotorID,
    ConstantsOld.kFrontLeftDriveEncoderReversed, 
    ConstantsOld.kFrontLeftTurnEncoderReversed,
    ConstantsOld.kFrontLeftAbsoluteEncoderID, 
    ConstantsOld.kFrontLeftEncoderOffset,
    ConstantsOld.kFrontLeftAbsoluteEncoderReversed);

  private final SwerveModuleOLD frontRight = new SwerveModuleOLD(
    ConstantsOld.kFrontRightDriveMotorID,
    ConstantsOld.kFrontRightTurnMotorID,
    ConstantsOld.kFrontRightDriveEncoderReversed, 
    ConstantsOld.kFrontRightTurnEncoderReversed,
    ConstantsOld.kFrontRightAbsoluteEncoderID, 
    ConstantsOld.kFrontRightEncoderOffset,
    ConstantsOld.kFrontRightAbsoluteEncoderReversed);
    
  private final SwerveModuleOLD backLeft = new SwerveModuleOLD(
    ConstantsOld.kbackLeftDriveMotorID,
    ConstantsOld.kbackLeftTurnMotorID,
    ConstantsOld.kbackLeftDriveEncoderReversed, 
    ConstantsOld.kbackLeftTurnEncoderReversed,
    ConstantsOld.kbackLeftAbsoluteEncoderID, 
    ConstantsOld.kbackLeftEncoderOffset,
    ConstantsOld.kbackLeftAbsoluteEncoderReversed);

  private final SwerveModuleOLD backRight = new SwerveModuleOLD(
    ConstantsOld.kbackRightDriveMotorID,
    ConstantsOld.kbackRightTurnMotorID,
    ConstantsOld.kbackRightDriveEncoderReversed, 
    ConstantsOld.kbackRightTurnEncoderReversed,
    ConstantsOld.kbackRightAbsoluteEncoderID, 
    ConstantsOld.kbackRightEncoderOffset,
    ConstantsOld.kbackRightAbsoluteEncoderReversed);  

  private final Pigeon2 gyro = new Pigeon2(ConstantsOld.kPigeon2ID);

    /** Creates a new SwerveSubsystem. */
  public SwerveSubsystemOLD() {
    new Thread(() -> {
      try{
        Thread.sleep(1000);
        zeroHeading();  
      }catch(Exception e){

      }
    }).start();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void zeroHeading(){
    gyro.reset();
  }

  public double getHeading(){
    return Math.IEEEremainder(gyro.getAngle(), 360);
  }

  public Rotation2d getRoation2d(){
    return Rotation2d.fromDegrees(getHeading());
  }

  public void stopModules(){
    frontLeft.stop();
    frontRight.stop();
    backLeft.stop();
    backRight.stop();
  }

  public void setModuleStates(SwerveModuleState[] desiredStates){
    frontLeft.setDesiredState(desiredStates[0]);
    frontRight.setDesiredState(desiredStates[1]);
    backLeft.setDesiredState(desiredStates[2]);
    backRight.setDesiredState(desiredStates[3]);
  }
}
