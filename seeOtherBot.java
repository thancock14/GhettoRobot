/************See Other Bot*************/ //at certain distance away
//make another class that has a different distance that does something different
										
import lejos.robotics.subsumption.*;
import lejos.nxt.*;

public class seeOtherBot implements Behavior{
   boolean seeBot;
  	
     
 sonarC sonar;
 blueTooth blue;
 
   // Constructor:
   public seeOtherBot(blueTooth b, sonarC s) {
      blue = b;
      sonar = s;
      seeBot = false;
      
   }

  
   
   public boolean takeControl() {
   if(sonar.read < 35 && sonar.read > 10) 
        { return true;}
        else
         return false;
   }

   public void suppress() {
    /*   blue.Send(1);
		      try{
		 Thread.currentThread().sleep(150);
		  }
		  catch(Exception e) {}
		    LCD.clear();
		    LCD.drawString("forward",0,0);
		    Motor.A.stop();
		    Motor.B.stop();*/
   }

   public void action() {
     /*   blue.Send(1);
		      try{
		 Thread.currentThread().sleep(150);
		  }
		  catch(Exception e) {}
		    LCD.clear();
		    LCD.drawString("forward",0,0);
		    Motor.A.stop();
		    Motor.B.stop();*/
	
      blue.Send(7);
           try{
		 Thread.currentThread().sleep(150);
		  }
		  catch(Exception e) {}
            Motor.A.forward();
		    Motor.B.forward();
		    sonar.findS();
      
	    
   }
}