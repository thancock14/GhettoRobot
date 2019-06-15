import lejos.robotics.subsumption.*;
import lejos.nxt.*;
import lejos.nxt.comm.*;
import java.io.*;
import javax.bluetooth.*;

public class hitC  {
TouchSensor touch; 
	
	boolean read;
	
	
	public sonarC()
	{
	  touch = new TouchSensor(SensorPort.S3);
      read = touch.isPressed();
	}
  
  public void findS()
  {
    read = touch.isPressed();
  }
  
   
  
}
