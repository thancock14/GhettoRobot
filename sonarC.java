import lejos.robotics.subsumption.*;
import lejos.nxt.*;
import lejos.nxt.comm.*;
import java.io.*;
import javax.bluetooth.*;

public class sonarC  {
	UltrasonicSensor sonar;
	int read;
	
	
	public sonarC()
	{
	  sonar = new UltrasonicSensor(SensorPort.S2);
      read = sonar.getDistance();
	}
  
  public void findS()
  {
    read = sonar.getDistance();
  }
  
   
  
}
