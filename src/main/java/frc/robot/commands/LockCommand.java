// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Lock_Subsystem;

public class LockCommand extends CommandBase {
  private final Lock_Subsystem Lock_Subsystem;
  public LockCommand(Lock_Subsystem Lock_Subsystem) {
    this.Lock_Subsystem = Lock_Subsystem;
    addRequirements(Lock_Subsystem);
  }

  @Override
  public void initialize() {
    Lock_Subsystem.key();
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
