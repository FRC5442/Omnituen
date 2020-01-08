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
    frontLeft = new SwerveModule(RobotMap.mod1A, RobotMap.mod1B, RobotMap.mod1Encoder);
    backRight = new SwerveModule(RobotMap.mod2C, RobotMap.mod2D, RobotMap.mod2Encoder);
  }

  public void moveSwerve(Vector2d moveVector, double rotation) {
    Double[][] modSpeedsHeadings = Robot.swerveMath.findSwerveSpeedsHeadings(moveVector, rotation);
    frontLeft.moveSwerve(modSpeedsHeadings[1][0], modSpeedsHeadings[1][1]);
    backRight.moveSwerve(modSpeedsHeadings[3][0], modSpeedsHeadings[3][1]);
  }

  public void moveCrab(Vector2d moveVector, double rotation) {
    if (rotation == 0) {
      frontLeft.moveCrab(moveVector.magnitude(), rotation, (Math.atan2(moveVector.y, moveVector.x) * 180 / Math.PI));
      backRight.moveCrab(moveVector.magnitude(), rotation, (Math.atan2(moveVector.y, moveVector.x) * 180 / Math.PI)); 
    }
    else {
      frontLeft.moveCrab(moveVector.magnitude(), rotation, 225);
      backRight.moveCrab(moveVector.magnitude(), rotation, 45);
    }
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new SwerveDrive());
  }
}
