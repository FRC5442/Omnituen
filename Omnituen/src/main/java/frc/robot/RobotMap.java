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

  public static Encoder mod1AEncoder, mod1BEncoder;
  public static Encoder mod2CEncoder, mod2DEncoder;
  public static Encoder mod3EEncoder, mod3FEncoder;
  public static Encoder mod4GEncoder, mod4HEncoder;

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
    mod1AEncoder = new Encoder(0, 0, false, Encoder.EncodingType.k4X);
    mod1AEncoder.setDistancePerPulse(1/360);
    mod1AEncoder.setSamplesToAverage(5);
    mod1BEncoder = new Encoder(0, 0, false, Encoder.EncodingType.k4X);
    mod1BEncoder.setDistancePerPulse(1/360);
    mod1BEncoder.setSamplesToAverage(5);
    mod2CEncoder = new Encoder(0, 0, false, Encoder.EncodingType.k4X);
    mod2CEncoder.setDistancePerPulse(1/360);
    mod2CEncoder.setSamplesToAverage(5);
    mod2DEncoder = new Encoder(0, 0, false, Encoder.EncodingType.k4X);
    mod2DEncoder.setDistancePerPulse(1/360);
    mod2DEncoder.setSamplesToAverage(5);
    mod3EEncoder = new Encoder(0, 0, false, Encoder.EncodingType.k4X);
    mod3EEncoder.setDistancePerPulse(1/360);
    mod3EEncoder.setSamplesToAverage(5);
    mod3FEncoder = new Encoder(0, 0, false, Encoder.EncodingType.k4X);
    mod3FEncoder.setDistancePerPulse(1/360);
    mod3FEncoder.setSamplesToAverage(5);
    mod4GEncoder = new Encoder(0, 0, false, Encoder.EncodingType.k4X);
    mod4GEncoder.setDistancePerPulse(1/360);
    mod4GEncoder.setSamplesToAverage(5);
    mod4HEncoder = new Encoder(0, 0, false, Encoder.EncodingType.k4X);
    mod4HEncoder.setDistancePerPulse(1/360);
    mod4HEncoder.setSamplesToAverage(5);
  }

}
