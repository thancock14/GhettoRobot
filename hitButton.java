/************touchbutton*************/

import lejos.nxt.*;
import lejos.nxt.comm.*;
import java.io.*;
import javax.bluetooth.*;
import lejos.robotics.subsumption.*;

public class hitButton implements Behavior, SensorPortListener {
   boolean hit;
   public TouchSensor touch = new TouchSensor(SensorPort.S3);
   blueTooth blue;
   
   // Constructor:
   public hitButton(blueTooth b) {
      blue = b;
      hit = false;
      SensorPort.S3.addSensorPortListener(this);
   }
   
    public void stateChanged(SensorPort port, int oldValue, int newValue) {
      if(touch.isPressed())
         hit = true;
   }
   
    public boolean takeControl() {
      if(hit) {
         hit = false; // reset value
         return true;
      } else
         return false;
   }
   
 /*  
   public boolean takeControl() {
      return touch.isPressed();
   }*/

   public void suppress() {
     /*  blue.Send(1);
		      try{
		 Thread.currentThread().sleep(150);
		  }
		  catch(Exception e) {}
		    LCD.clear();
		    LCD.drawString("stopbutton",0,0);
		    Motor.A.stop();
		    Motor.B.stop();*/
   }

   public void action() {
       //stop
       blue.Send(1);
		      try{
		 Thread.currentThread().sleep(150);
		  }
		  catch(Exception e) {}
		    LCD.clear();
		    LCD.drawString("stop",0,0);
		    Motor.A.stop();
		    Motor.B.stop();
	    
	    
	    
	    
	    blue.Send(4);
	   // Motor.C.setSpeed(900);
	     try{
		 Thread.currentThread().sleep(150);
		  }
		  catch(Exception e) {}
		  
	    Motor.C.rotate(80);//as far as it should go
	    Motor.C.rotate(-75);
	    //wait for so long
		 
		
   }
}