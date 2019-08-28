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
import frc.robot.general.SharedConstants;
import frc.robot.general.SwerveMath;

/**
 * Subsystem to sync/control each swerve module.
 */
public class SwerveGroup extends Subsystem {

  SwerveModule frontRight, frontLeft, backRight, backLeft;

  public SwerveGroup() {
    frontRight = new SwerveModule(RobotMap.mod1A, RobotMap.mod1B, RobotMap.mod1AEncoder, RobotMap.mod1BEncoder);
    frontLeft = new SwerveModule(RobotMap.mod2C, RobotMap.mod2D, RobotMap.mod2CEncoder, RobotMap.mod2DEncoder);
    backLeft = new SwerveModule(RobotMap.mod3E, RobotMap.mod3F, RobotMap.mod3EEncoder, RobotMap.mod3FEncoder);
    backRight = new SwerveModule(RobotMap.mod4G, RobotMap.mod4H, RobotMap.mod4GEncoder, RobotMap.mod4HEncoder);
  }

  public void move(Vector2d moveVector, double rotation) {
    Double[][] modSpeedsHeadings = Robot.swerveMath.findModSpeedsHeadings(moveVector, rotation, SharedConstants.RobotLength, SharedConstants.RobotWidth);
    frontRight.move(modSpeedsHeadings[0][0], modSpeedsHeadings[0][1]);
    frontLeft.move(modSpeedsHeadings[1][0], modSpeedsHeadings[1][1]);
    backLeft.move(modSpeedsHeadings[2][0], modSpeedsHeadings[2][1]);
    backRight.move(modSpeedsHeadings[3][0], modSpeedsHeadings[3][1]);
  }

  @Override
  public void initDefaultCommand() {
    setDefaultCommand(new SwerveDrive());
  }
}
