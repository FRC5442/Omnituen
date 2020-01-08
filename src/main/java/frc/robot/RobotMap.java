/*----------------------------------------------------------------------------*/
/* Copyright (c) 2-117-2-118 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.*;
import com.revrobotics.frc.*;
import com.ctre.phoenix.*;
import com.kauailabs.navx.frc.*;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */

public class RobotMap {
  
  public static Spark mod1A, mod1B;
  public static Spark mod2C, mod2D;

  public static AnalogPotentiometer mod1Encoder, mod2Encoder;

  public RobotMap() {
    // speed controllers
    mod1A = new Spark(-1);
    mod1B = new Spark(-1);
    mod2C = new Spark(-1);
    mod2D = new Spark(-1);
  }
}
