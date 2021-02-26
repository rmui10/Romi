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

  private final Encoder leftEncoder = new Encoder(4, 5);
  private final Encoder rightEncoder = new Encoder(6,7);

  private final int TICKS_PER_REVOLUTION = 1440;
  private final double DIAMETER = 2.7559; //inches
  private final double DISTANCE_PER_TICK = (DIAMETER * Math.PI) / TICKS_PER_REVOLUTION;

  /** Creates a new RomiDrivetrain. */
  public RomiDrivetrain() {
    leftEncoder.setDistancePerPulse(DISTANCE_PER_TICK);
    rightEncoder.setDistancePerPulse(DISTANCE_PER_TICK);
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
  
  public void reset() {
    leftEncoder.reset();
    rightEncoder.reset();
  }
  
  public double getLeftDistance() {
    return leftEncoder.getDistance();
  }

  public double getRightDistance() {
    return rightEncoder.getDistance();
  }

  public double getMaxDistance() {
   return Math.max(getLeftDistance(), getRightDistance());
  }
}