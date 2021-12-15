// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator_Subsystem;
import frc.robot.subsystems.Lock_Subsystem;

public class ElevatorCommand extends CommandBase {
  private final Elevator_Subsystem elevator_Subsystem;

  public ElevatorCommand(Elevator_Subsystem elevator_Subsystem) {
    this.elevator_Subsystem = elevator_Subsystem;
    addRequirements(elevator_Subsystem);
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    if (Lock_Subsystem.lockStatus) {
      elevator_Subsystem.Winch_Up();
    }
    else{
      elevator_Subsystem.Winch_Stop();
    }
  }

  @Override
  public void end(boolean interrupted) {
    elevator_Subsystem.Winch_Stop();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
