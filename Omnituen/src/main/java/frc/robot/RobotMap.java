/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.*;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  
  public static Spark mod1A, mod1B;
  public static Spark mod2C, mod2D;
  public static Spark mod3E, mod3F;
  public static Spark mod4G, mod4H;

  public static Encoder mod1Encoder, mod2Encoder, mod3Encoder, mod4Encoder;

  public RobotMap() {
    // speed controllers
    mod1A = new Spark(0);
    mod1B = new Spark(0);
    mod2C = new Spark(0);
    mod2D = new Spark(0);
    mod3E = new Spark(0);
    mod3F = new Spark(0);
    mod4G = new Spark(0);
    mod4H = new Spark(0);

    // encoders
    mod1Encoder = new Encoder(0, 0, false, Encoder.EncodingType.k4X);
    mod1Encoder.setDistancePerPulse(1/360);
    mod1Encoder.setSamplesToAverage(5);
    mod2Encoder = new Encoder(0, 0, false, Encoder.EncodingType.k4X);
    mod2Encoder.setDistancePerPulse(1/360);
    mod2Encoder.setSamplesToAverage(5);
    mod3Encoder = new Encoder(0, 0, false, Encoder.EncodingType.k4X);
    mod3Encoder.setDistancePerPulse(1/360);
    mod3Encoder.setSamplesToAverage(5);
    mod4Encoder = new Encoder(0, 0, false, Encoder.EncodingType.k4X);
    mod4Encoder.setDistancePerPulse(1/360);
    mod4Encoder.setSamplesToAverage(5);
  }

}
