// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import static frc.robot.subsystems.Lock_Subsystem.lockStatus;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator_Subsystem;
import frc.robot.subsystems.Lock_Subsystem;

public class ElevatorCommand extends CommandBase {
  private final Elevator_Subsystem elevator_Subsystem;
  private final Lock_Subsystem lock_Subsystem;

  public ElevatorCommand(Elevator_Subsystem elevator_Subsystem, Lock_Subsystem lock_Subsystem) {
    this.elevator_Subsystem = elevator_Subsystem;
    this.lock_Subsystem = lock_Subsystem;
    addRequirements(elevator_Subsystem);
    addRequirements(lock_Subsystem);
  }

  @Override
  public void initialize() {
    if (lock_Subsystem.lockStatus)
    System.out.println("Kilit Kalktı");
    elevator_Subsystem.Winch_Up();
  }

  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
