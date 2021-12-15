// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drive_Subsystem;
import frc.robot.subsystems.Led_Subsystem;
import frc.robot.Constants.JoystickConstants;

public class TeleDriveCommand extends CommandBase {
  public final Joystick driver_Controller;
  private final Drive_Subsystem drive_Subsystem;
  private final Led_Subsystem led_Subsystem;
  public static double Rotasyon;
  
  public TeleDriveCommand(Joystick driver_Controller, Drive_Subsystem drive_Subsystem, Led_Subsystem led_Subsystem) {
    this.driver_Controller = driver_Controller;
    this.drive_Subsystem = drive_Subsystem;
    this.led_Subsystem = led_Subsystem;
    addRequirements(drive_Subsystem);
    addRequirements(led_Subsystem);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    drive_Subsystem.arcadeDrive(getSpeed(), getRotation(),true);
  }
  private double getSpeed() {
    double speed =-driver_Controller.getRawAxis(JoystickConstants.LeftAxisY);
    return speed;
  }
  private double getRotation() {
    double rotation = driver_Controller.getRawAxis(JoystickConstants.RightAxisX);
    Rotasyon = rotation;
    if(rotation > 0.2){
      led_Subsystem.rightLED(255, 50, 0);
    }
    else if(rotation < -0.2){
      led_Subsystem.leftLED(255, 50, 0);
    }
    else{
      Led_Subsystem.stopLED();
    }
    return rotation;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
