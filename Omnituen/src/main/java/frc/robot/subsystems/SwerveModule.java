/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Spark;

/**
 * Basic subsystem class to control a single swerve module.
 */
public class SwerveModule extends Subsystem {

  Spark topGear, bottomGear;

  public SwerveModule(Spark topGear, Spark bottomGear) {
    this.topGear = topGear;
    this.bottomGear = bottomGear;
  }

  @Override
  public void initDefaultCommand() {}

}
