/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.drive.Vector2d;
import frc.robot.Robot;

public class SwerveDrive extends Command {
  public SwerveDrive() {
    requires(Robot.swerveGroup);
  }

  @Override
  protected void initialize() {}

  @Override
  protected void execute() {
    Vector2d moveVector = new Vector2d(Robot.oi.xboxController1.getRawAxis(0), Robot.oi.xboxController1.getRawAxis(1));
    Robot.swerveGroup.moveCrab(moveVector, Robot.oi.xboxController1.getRawAxis(4));
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {}

  @Override
  protected void interrupted() {}
}
