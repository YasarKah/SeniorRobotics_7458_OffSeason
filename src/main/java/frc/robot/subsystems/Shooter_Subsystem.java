package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MotorConstants;

public class Shooter_Subsystem extends SubsystemBase {
  private final WPI_VictorSPX m_shooter_MotorLeft = new WPI_VictorSPX(MotorConstants.kShooter_Motor_PortLeft);
  private final WPI_VictorSPX m_shooter_MotorRight = new WPI_VictorSPX(MotorConstants.kShooter_Motor_PortRight);
  private boolean shooter_state = false;

  public Shooter_Subsystem() {
    m_shooter_MotorLeft.configVoltageCompSaturation(10);
    m_shooter_MotorLeft.enableVoltageCompensation(true);
    m_shooter_MotorLeft.setInverted(true);

    m_shooter_MotorRight.configVoltageCompSaturation(10);
    m_shooter_MotorRight.enableVoltageCompensation(true);
  }

  @Override
  public void periodic() {

  }

  public void shoot() {
    System.out.println("Geldii");
    if (!shooter_state) {
      shoot_Start();
      shooter_state = true;
    } else {
      shoot_Stop();
      shooter_state = false;
    }
  }

  public void shoot_Start() {
    m_shooter_MotorLeft.set(1);
    m_shooter_MotorRight.set(1);
  }
  public void shoot_Stop() {
    m_shooter_MotorLeft.set(0);
    m_shooter_MotorRight.set(0);
  }
}
