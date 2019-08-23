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
    mod1A = new Spark(0);
    mod1B = new Spark(0);
    mod2C = new Spark(0);
    mod2D = new Spark(0);
    mod3E = new Spark(0);
    mod3F = new Spark(0);
    mod4G = new Spark(0);
    mod4H = new Spark(0);

    mod1AEncoder = new Encoder(0, 0, false, Encoder.EncodingType.k4X);
    mod1BEncoder = new Encoder(0, 0, false, Encoder.EncodingType.k4X);
    mod2CEncoder = new Encoder(0, 0, false, Encoder.EncodingType.k4X);
    mod2DEncoder = new Encoder(0, 0, false, Encoder.EncodingType.k4X);
    mod3EEncoder = new Encoder(0, 0, false, Encoder.EncodingType.k4X);
    mod3FEncoder = new Encoder(0, 0, false, Encoder.EncodingType.k4X);
    mod4GEncoder = new Encoder(0, 0, false, Encoder.EncodingType.k4X);
    mod4HEncoder = new Encoder(0, 0, false, Encoder.EncodingType.k4X);
  }

}
