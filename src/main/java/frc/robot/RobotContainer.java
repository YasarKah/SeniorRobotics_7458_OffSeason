// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import frc.robot.Constants.JoystickConstants;
import frc.robot.commands.ConveyorCommand;
import frc.robot.commands.ElevatorCommand;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.LockCommand;
import frc.robot.commands.ShootCommand;
import frc.robot.commands.TeleDriveCommand;
import frc.robot.subsystems.Conveyor_Subsystem;
import frc.robot.subsystems.Drive_Subsystem;
import frc.robot.subsystems.Elevator_Subsystem;
import frc.robot.subsystems.Intake_Subsystem;
import frc.robot.subsystems.Led_Subsystem;
import frc.robot.subsystems.Lock_Subsystem;
import frc.robot.subsystems.Shooter_Subsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class RobotContainer {
  

  public final Drive_Subsystem m_drive = new Drive_Subsystem();
  public final Shooter_Subsystem m_shooter = new Shooter_Subsystem();
  public final Intake_Subsystem m_intake = new Intake_Subsystem();
  public final Conveyor_Subsystem m_conveyor = new Conveyor_Subsystem();
  public final Elevator_Subsystem m_elevator= new Elevator_Subsystem();
  public final Lock_Subsystem m_lock = new Lock_Subsystem();
  public final Led_Subsystem m_led = new Led_Subsystem();

  Joystick driver_Controller = new Joystick(0);
  public static final ShuffleboardTab driverTab = Shuffleboard.getTab("Robot Statistics");

  private final AutoGenerator autoGenerator = new AutoGenerator(m_drive, m_shooter);

  private void configureButtonBindings() {
    new JoystickButton(driver_Controller, JoystickConstants.B).whenPressed(new ShootCommand(m_shooter)); 
    new JoystickButton(driver_Controller, JoystickConstants.X).whenPressed(new IntakeCommand(m_intake));
    new JoystickButton(driver_Controller, JoystickConstants.A).whileHeld(new ConveyorCommand(m_conveyor));
    new JoystickButton(driver_Controller, JoystickConstants.Y).whileHeld(new LockCommand(m_lock));
    new JoystickButton(driver_Controller, JoystickConstants.R1).whileHeld(new ElevatorCommand(m_elevator));
  }
  public RobotContainer() {
    m_drive.setDefaultCommand(new TeleDriveCommand(driver_Controller, m_drive, m_led));
    autoGenerator.configureAutonomous();
    configureButtonBindings();
  }
  private void configureDriverDashboard() {
    autoGenerator.addDashboardWidgets(driverTab);
  }
  public Command getAutonomousCommand() {
    return autoGenerator.getAutonomousCommand();
  }
}
