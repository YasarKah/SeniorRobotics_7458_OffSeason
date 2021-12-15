// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Led_Subsystem;

public class LedCommand extends CommandBase {
  private final Led_Subsystem Led_Subsystem;

  public LedCommand(Led_Subsystem Led_Subsystem) {
    this.Led_Subsystem = Led_Subsystem;
    addRequirements(Led_Subsystem);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return false;
  }
}
