// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.AddressableLED;
import edu.wpi.first.wpilibj.AddressableLEDBuffer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.MotorConstants;

public class Led_Subsystem extends SubsystemBase {

  public AddressableLED led = new AddressableLED(MotorConstants.Led_Port);;
  public AddressableLEDBuffer buffer = new AddressableLEDBuffer(MotorConstants.Led_Buffer);

  public Led_Subsystem() {
    led.setLength(buffer.getLength());
    led.setData(buffer);
    led.start();
  }

  public void startLED() {
    for (var i = 0; i < buffer.getLength(); i++) {
      buffer.setRGB(i, 255, 255, 0);
      led.setData(buffer);
    }
  }

  public void stopLED() {
    for (var i = 0; i < buffer.getLength(); i++) {
      buffer.setRGB(i, 0, 0, 0);
      led.setData(buffer);
    }
  }
  public void setMor(){
    stopLED();
    for (var i = 0; i < buffer.getLength(); i++) {
      buffer.setRGB(i, 96, 0, 128);
      led.setData(buffer);
    }
  }
  public void rightLED(int red, int green, int blue) {
    stopLED();
    for (var i =10; i <= 17; i++) {
      buffer.setRGB(i, red, green, blue);
    }
    led.setData(buffer);
  }

  public void leftLED(int red, int green, int blue) {
    stopLED();
    for (var i = 0; i <= 8; i++){
      buffer.setRGB(i, red, green, blue);
    }
    led.setData(buffer);
  }

  @Override
  public void periodic() {
  }
}
