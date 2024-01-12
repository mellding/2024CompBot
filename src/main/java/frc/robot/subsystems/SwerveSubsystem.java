// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.Pigeon2;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SwerveSubsystem extends SubsystemBase {

  private final SwerveModule frontLeft = new SwerveModule(
    Constants.kFrontLeftDriveMotorID,
    Constants.kFrontLeftTurnMotorID,
    Constants.kFrontLeftDriveEncoderReversed, 
    Constants.kFrontLeftTurnEncoderReversed,
    Constants.kFrontLeftAbsoluteEncoderID, 
    Constants.kFrontLeftEncoderOffset,
    Constants.kFrontLeftAbsoluteEncoderReversed);

  private final SwerveModule frontRight = new SwerveModule(
    Constants.kFrontRightDriveMotorID,
    Constants.kFrontRightTurnMotorID,
    Constants.kFrontRightDriveEncoderReversed, 
    Constants.kFrontRightTurnEncoderReversed,
    Constants.kFrontRightAbsoluteEncoderID, 
    Constants.kFrontRightEncoderOffset,
    Constants.kFrontRightAbsoluteEncoderReversed);
    
  private final SwerveModule backLeft = new SwerveModule(
    Constants.kbackLeftDriveMotorID,
    Constants.kbackLeftTurnMotorID,
    Constants.kbackLeftDriveEncoderReversed, 
    Constants.kbackLeftTurnEncoderReversed,
    Constants.kbackLeftAbsoluteEncoderID, 
    Constants.kbackLeftEncoderOffset,
    Constants.kbackLeftAbsoluteEncoderReversed);

  private final SwerveModule backRight = new SwerveModule(
    Constants.kbackRightDriveMotorID,
    Constants.kbackRightTurnMotorID,
    Constants.kbackRightDriveEncoderReversed, 
    Constants.kbackRightTurnEncoderReversed,
    Constants.kbackRightAbsoluteEncoderID, 
    Constants.kbackRightEncoderOffset,
    Constants.kbackRightAbsoluteEncoderReversed);  

  private final Pigeon2 gyro = new Pigeon2(Constants.kPigeon2ID);

    /** Creates a new SwerveSubsystem. */
  public SwerveSubsystem() {
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
