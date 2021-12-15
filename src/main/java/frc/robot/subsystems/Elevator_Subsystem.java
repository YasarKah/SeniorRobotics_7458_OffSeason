// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MotorConstants;

public class Elevator_Subsystem extends SubsystemBase {
  private final WPI_VictorSPX m_Elevator = new WPI_VictorSPX(MotorConstants.Elevator_Motor_Port);
  
  public Elevator_Subsystem() {}

  @Override
  public void periodic() {
  }
  public void Winch_Up(){
    m_Elevator.set(1);
  }
  public void Winch_Stop(){
    m_Elevator.set(0);
  }
}
