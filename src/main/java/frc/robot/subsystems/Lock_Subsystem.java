// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Lock_Subsystem extends SubsystemBase {
  private int sayac = 0;
  public static boolean lockStatus = false;

  public Lock_Subsystem() {}

  @Override
  public void periodic() {
  }
  public void key(){
    sayac++;
    if(sayac >= 3){
      lockStatus = true;
    }
    else{
      lockStatus = false;
    }
  }
}
