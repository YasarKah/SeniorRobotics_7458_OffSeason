// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.TeleDriveCommand;

public class Sellektor_Subsystem extends SubsystemBase {
  public Sellektor_Subsystem() {
  }

  @Override
  public void periodic() {

  }

  public void Uzunlar() {
    Led_Subsystem.UzunLED();
  }

  public void UzunlarOff(){
    if(TeleDriveCommand.Rotasyon > 0.2 && TeleDriveCommand.Rotasyon < -0.2){}
    else{Led_Subsystem.stopLED();}
  }
}
