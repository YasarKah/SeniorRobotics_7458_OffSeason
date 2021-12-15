// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Led_Subsystem;
import frc.robot.subsystems.Sellektor_Subsystem;

public class SellektorCommand extends CommandBase {

  private final Sellektor_Subsystem Sellektor_Subsystem;

  public SellektorCommand(Sellektor_Subsystem Sellektor_Subsystem) {

    this.Sellektor_Subsystem = Sellektor_Subsystem;
    addRequirements(Sellektor_Subsystem);

  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    Sellektor_Subsystem.Uzunlar();
  }

  @Override
  public void end(boolean interrupted) {
    Sellektor_Subsystem.UzunlarOff();
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
