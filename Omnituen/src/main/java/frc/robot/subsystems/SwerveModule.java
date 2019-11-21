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
    assert speed >= -1 && speed <= 1;
    assert angle >= 0 && angle <= 359;

    double topDistance = topEncoder.getDistance() % 360;
    double bottomDistance = bottomEncoder.getDistance() % 360;

    double currentAngle = (topDistance + bottomDistance) / 2;

    if (currentAngle >= angle - 1 &&
        currentAngle <= angle + 1) {
          topGear.set(-speed);
          bottomGear.set(speed);
    }
    else {
      // if module angle not in tolerable angle range: set both gears to the speed + (range of 0-1) angle difference
      topGear.set(-speed + (1 / (currentAngle - angle)));
      bottomGear.set(speed + (1 / (currentAngle - angle)));
    }
  }

  @Override
  public void initDefaultCommand() {}
}
