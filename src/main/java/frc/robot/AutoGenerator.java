
package frc.robot;

import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

public class AutoGenerator {
  private final Drive_Subsystem m_drive;
  private final Shooter_Subsystem m_shooter;

  private final SendableChooser<Command> autoChooser = new SendableChooser<>();

  public AutoGenerator(Drive_Subsystem m_drive,Shooter_Subsystem m_shooter) {
    this.m_drive = m_drive;
    this.m_shooter = m_shooter;
  }

  public void configureAutonomous() {
    configureYasar();
  }

  public void addDashboardWidgets(ShuffleboardTab dashboard) {
    dashboard.add("Auto Chooser", autoChooser).withSize(2, 1).withPosition(0, 0);
  }

  private void configureYasar() {
    var autoCommandGroup = Yasar();
    autoChooser.setDefaultOption("Yasar", autoCommandGroup);

  }
  private Command Yasar(){
    return new InstantCommand(m_shooter::shoot_Start, m_shooter).alongWith(new PrintCommand("1: AUTONOMMMMM")).andThen(new WaitCommand(3)).andThen(new AutoDriveCommand(m_drive));
      }
  public Command getAutonomousCommand() {
    return autoChooser.getSelected();
  }
}