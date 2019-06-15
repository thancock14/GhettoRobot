/************sense line*************/
import lejos.robotics.subsumption.*;
import lejos.nxt.*;
import lejos.nxt.comm.*;
import java.io.*;
import javax.bluetooth.*;

public class senseLine implements Behavior, SensorPortListener {
   boolean seeLine;
   public LightSensor light = new LightSensor(SensorPort.S1);
 
 blueTooth blue;
 
   // Constructor:
   public senseLine(blueTooth b) {
      blue = b;
      seeLine = false;
      SensorPort.S1.addSensorPortListener(this);
   }

   public void stateChanged(SensorPort port, int oldValue, int newValue) {
      if(light.readValue() < 38       && light.readValue() > 31)
         seeLine = true;
   }

   public boolean takeControl() {
      if(seeLine) {
         seeLine = false; // reset value
         return true;
      } else
         return false;
   }


   public void suppress() {
     /*  blue.Send(1);
		      try{
		 Thread.currentThread().sleep(150);
		  }
		  catch(Exception e) {}
		    LCD.clear();
		    LCD.drawString("stopline",0,0);
		    Motor.A.stop();
		    Motor.B.stop();*/
   }

   public void action() {
   
   
	boolean find = true;
	if(Motor.A.isMoving())
	{find = Motor.A.isForward(); }
	
	
   
       blue.Send(1);
		      try{
		 Thread.currentThread().sleep(150);
		  }
		  catch(Exception e) {}
		    LCD.clear();
		    LCD.drawString("stoplineaction",0,0);
		    Motor.A.stop();
		    Motor.B.stop();
		     try{
		 Thread.currentThread().sleep(1000);
		  }
		  catch(Exception e) {}
		    LCD.drawString("after stop", 0, 0);
	
	//this is how to reverse the bot
	
	if(find == true)
	{
	  blue.Send(6);
	      try{
		 Thread.currentThread().sleep(150);
		  }
		  catch(Exception e) {}
	    Motor.A.rotate(-720);
	    Motor.B.flt();
	     blue.Send(5);
	     try{
		 Thread.currentThread().sleep(150);
		  }
		  catch(Exception e) {}
	    Motor.A.rotate(540);
	    Motor.B.flt();
	    
	    blue.Send(8);
	     try{
		 Thread.currentThread().sleep(150);
		  }
		  catch(Exception e) {}
	    Motor.A.rotate(360);
	    Motor.B.flt();
	    
	}

	else
	{
	   blue.Send(5);
	      try{
		 Thread.currentThread().sleep(150);
		  }
		  catch(Exception e) {}
	    Motor.A.rotate(720);
	    Motor.B.flt();
	    
	}

   }
}
