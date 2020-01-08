/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.AnalogPotentiometer;

/**
 * Basic subsystem class to control a single swerve module.
 */
public class SwerveModule extends Subsystem {

  Spark topGear, bottomGear;
  AnalogPotentiometer encoder;

  public SwerveModule(Spark topGear, Spark bottomGear, AnalogPotentiometer encoder) {
    this.topGear = topGear;
    this.bottomGear = bottomGear;
    this.encoder = encoder;
  }
  
  //just a concept, not to be used yet...
  public void moveSwerve(double speed, double angle) {
  }

  public void moveCrab(double speed, double rotation, double angle) {
    assert speed >= -1 && speed <= 1;
    assert rotation >= -1 && rotation <= 1;
    assert angle >= 0 && angle <= 359;

    double currentAngle = encoder.get();

    topGear.set((speed) + (rotation));
    bottomGear.set((-speed) + (rotation));
  }

  @Override
  public void initDefaultCommand() {}
}
