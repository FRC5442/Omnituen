/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Encoder;

/**
 * Basic subsystem class to control a single swerve module.
 */
public class SwerveModule extends Subsystem {

  Spark topGear, bottomGear;
  Encoder topEncoder, bottomEncoder;

  public SwerveModule(Spark topGear, Spark bottomGear, Encoder topEncoder, Encoder bottomEncoder) {
    this.topGear = topGear;
    this.bottomGear = bottomGear;
    this.topEncoder = topEncoder;
    this.bottomEncoder = bottomEncoder;
  }

  public void move(double speed, double angle) {
    if ((topEncoder.getDistance() + bottomEncoder.getDistance()) / 2 >= angle - 5 &&
        (topEncoder.getDistance() + bottomEncoder.getDistance()) / 2 <= angle + 5) {
          topGear.set(speed);
          bottomGear.set(-speed);
    }
    else {
      topGear.set(speed + (1 / (((topEncoder.getDistance() + bottomEncoder.getDistance()) / 2) - angle)));
      bottomGear.set(-speed + (1 / (((topEncoder.getDistance() + bottomEncoder.getDistance()) / 2) - angle)));
    }
  }

  @Override
  public void initDefaultCommand() {}
}
