/************Final Main*************/
import lejos.robotics.subsumption.*;
import lejos.nxt.*;
import lejos.nxt.comm.*;
import java.io.*;
import javax.bluetooth.*;

public class ghettoBot {
   public static void main(String [] args) {
   
   
   
      blueTooth blue = new blueTooth(1);
      sonarC sonar = new sonarC();
      //hitC hit = new hitC();

   
      Behavior b1 = new spinBot(blue, sonar);
      Behavior b2 = new senseLine(blue);
      Behavior b3 = new seeOtherBot(blue, sonar);
      Behavior b4 = new hitButton(blue);
      Behavior [] bArray = {b1, b3, b4, b2};
      Arbitrator arby = new Arbitrator(bArray);
      //Arbitrator arbitrator = new  Arbitrator(bArray);
      arby.start();
      //arbitrator.start();
      
      
      
      
   }
}
