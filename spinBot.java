
/************Spinning*************/
import lejos.robotics.subsumption.*;
import lejos.nxt.*;
import lejos.nxt.comm.*;
import java.io.*;
import javax.bluetooth.*;

public class spinBot implements Behavior {
   blueTooth blue;
   sonarC sonar;
   
   public spinBot(blueTooth b, sonarC s) {
     blue = b;
     sonar = s;
   }
  
 
   
   public boolean takeControl() {
      return true;
   }

   public void suppress() {
      blue.Send(1);
		    
		    try{
		 Thread.currentThread().sleep(150);
		  }
		  catch(Exception e) {}
		    LCD.clear();
		    LCD.drawString("stopspin",0,0);
		    Motor.A.stop();
		    Motor.B.stop();
   }

   public void action() {
            blue.Send(2);
            LCD.refresh();
		      try{
		 Thread.currentThread().sleep(150);
		  }
		  catch(Exception e) {}
		    LCD.clear();
		    LCD.drawString("forwardspin",0,0);
		    sonar.findS();
		    Motor.A.forward();
		    Motor.B.forward();
   }
}