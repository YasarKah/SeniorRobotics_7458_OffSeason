
package frc.robot;

import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
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
    autoChooser.addOption("Yasar", autoCommandGroup);

  }
  private Command Yasar(){
    
    return new ShootCommand(m_shooter);
  }
  public Command getAutonomousCommand() {
    return autoChooser.getSelected();
  }
}