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
  Encoder encoder;

  public SwerveModule(Spark topGear, Spark bottomGear, Encoder encoder) {
    this.topGear = topGear;
    this.bottomGear = bottomGear;
    this.encoder = encoder;
  }
  
  //just a concept, not to be used yet...
  public void moveSwerve(double speed, double angle) {
    /*
    assert speed >= -1 && speed <= 1;
    assert angle >= 0 && angle <= 359;

    double currentAngle = encoder.getDistance();

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
    */
  }

  public void moveCrab(double speed, double rotation, double angle) {
    assert speed >= -1 && speed <= 1;
    assert rotation >= -1 && rotation <= 1;
    assert angle >= 0 && angle <= 359;

    double currentAngle = encoder.getDistance() % 360;

    if (Math.abs(angle - currentAngle) > 3) {
      topGear.set((angle - currentAngle) / 100);
      bottomGear.set((angle - currentAngle) / 100);
    }
    else {
      topGear.set((speed) + (rotation));
      bottomGear.set((-speed) + (rotation));
    }

    /*
    if (rotation == 0) {
      topGear.set(-speed);
      bottomGear.set(speed);
    }
    else {
      topGear.set(rotation);
      bottomGear.set(rotation);
    }
    */

  }

  @Override
  public void initDefaultCommand() {}
}
