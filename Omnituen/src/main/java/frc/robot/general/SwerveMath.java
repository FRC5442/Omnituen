/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.general;

import java.lang.Math;
import edu.wpi.first.wpilibj.drive.Vector2d;
import frc.robot.Robot;

/**
 * Class to handle math related to swerve.
 */
public class SwerveMath {

    public SwerveMath() {}

    public Double[][] findSwerveSpeedsHeadings(Vector2d moveVector, double rotation) {
        // variable names come from the white paper
        double a = moveVector.x - (rotation * (Robot.sharedConstants.ROBOT_LENGTH / 2));
        double b = moveVector.x + (rotation * (Robot.sharedConstants.ROBOT_LENGTH / 2));
        double c = moveVector.y - (rotation * (Robot.sharedConstants.ROBOT_WIDTH / 2));
        double d = moveVector.y + (rotation * (Robot.sharedConstants.ROBOT_WIDTH / 2));

        // returns Double[speed][angle]
        return new Double[][] {
            { Math.sqrt(Math.pow(b, 2) + Math.pow(c, 2)), (Math.atan2(b, c) * 180) / Math.PI }, 
            { Math.sqrt(Math.pow(b, 2) + Math.pow(d, 2)), (Math.atan2(b, d) * 180) / Math.PI }, 
            { Math.sqrt(Math.pow(a, 2) + Math.pow(d, 2)), (Math.atan2(a, d) * 180) / Math.PI }, 
            { Math.sqrt(Math.pow(a, 2) + Math.pow(c, 2)), (Math.atan2(a, c) * 180) / Math.PI }
        };
    }
}
