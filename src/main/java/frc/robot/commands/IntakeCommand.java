
package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Intake_Subsystem;

public class IntakeCommand extends CommandBase {
  
  private final Intake_Subsystem intake_Subsystem;

  public IntakeCommand(Intake_Subsystem intake_Subsystem) {
    this.intake_Subsystem = intake_Subsystem;
    addRequirements(intake_Subsystem);
  }

  @Override
  public void initialize() {
    intake_Subsystem.IntakeSystem();  
  }

  @Override
  public void execute() {}

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return true;
  }
}
