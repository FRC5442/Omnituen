/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.Vector2d;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.Robot;
import frc.robot.commands.SwerveDrive;

/**
 * Subsystem to sync/control each swerve module.
 */
public class SwerveGroup extends Subsystem {

  SwerveModule frontRight, frontLeft, backRight, backLeft;

  public SwerveGroup() {
    frontRight = new SwerveModule(RobotMap.mod1A, RobotMap.mod1B, RobotMap.mod1Encoder);
    frontLeft = new SwerveModule(RobotMap.mod2C, RobotMap.mod2D, RobotMap.mod2Encoder);
    backLeft = new SwerveModule(RobotMap.mod3E, RobotMap.mod3F, RobotMap.mod3Encoder);
    backRight = new SwerveModule(RobotMap.mod4G, RobotMap.mod4H, RobotMap.mod4Encoder);
  }

  public void moveSwerve(Vector2d moveVector, double rotation) {
    Double[][] modSpeedsHeadings = Robot.swerveMath.findSwerveSpeedsHeadings(moveVector, rotation);
    frontRight.moveSwerve(modSpeedsHeadings[0][0], modSpeedsHeadings[0][1]);
    frontLeft.moveSwerve(modSpeedsHeadings[1][0], modSpeedsHeadings[1][1]);
    backLeft.moveSwerve(modSpeedsHeadings[2][0], modSpeedsHeadings[2][1]);
    backRight.moveSwerve(modSpeedsHeadings[3][0], modSpeedsHeadings[3][1]);
  }

  public void moveCrab(Vector2d moveVector, double rotation) {
    if (rotation == 0) {
      frontRight.moveCrab(moveVector.magnitude(), rotation, (Math.atan2(moveVector.y, moveVector.x) * 180 / Math.PI));
      frontLeft.moveCrab(moveVector.magnitude(), rotation, (Math.atan2(moveVector.y, moveVector.x) * 180 / Math.PI));
      backLeft.moveCrab(moveVector.magnitude(), rotation, (Math.atan2(moveVector.y, moveVector.x) * 180 / Math.PI));
      backRight.moveCrab(moveVector.magnitude(), rotation, (Math.atan2(moveVector.y, moveVector.x) * 180 / Math.PI)); 
    }
    else {
      frontRight.moveCrab(moveVector.magnitude(), rotation, 315);
      frontLeft.moveCrab(moveVector.magnitude(), rotation, 225);
      backLeft.moveCrab(moveVector.magnitude(), rotation, 135);
      backRight.moveCrab(moveVector.magnitude(), rotation, 45);
    }
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new SwerveDrive());
  }
}
