// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
public class RomiDrivetrain {

  private final Spark leftMotor = new Spark(0);
  private final Spark rightMotor = new Spark(1);
  private final DifferentialDrive diffDrive = new DifferentialDrive(leftMotor, rightMotor);
  private final Encoder encoder = new Encoder(0,1);

  private void robotInit (){
    encoder.setDistancePerPulse(distancePerPulse);
  }
  /** Creates a new RomiDrivetrain. */
  public RomiDrivetrain() {
  
  }

  public void arcadeDrive(double xaxisSpeed, double zaxisRotate) { 
    diffDrive.arcadeDrive(xaxisSpeed, zaxisRotate);
  }
  
  public void tankDrive(double leftSpeed, double rightSpeed) {
    diffDrive.tankDrive(leftSpeed,  rightSpeed);
  }
  
  public void setLeftSpeed(double leftSpeed) {//setsSpeeeed
  leftMotor.set(leftSpeed);
  }

  public void setRightSpeed(double rightSpeed) {
   rightMotor.set(rightSpeed);
  }
}