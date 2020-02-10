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
      Behavior b2 = new seeOtherBot(blue, sonar);
      Behavior b3 = new hitButton(blue);
      Behavior b4 = new senseLine(blue);
      //Array is in increasing priority order as defined by Arbitrator docs
      Behavior [] bArray = {b1, b2, b3, b4};
      Arbitrator arby = new Arbitrator(bArray);
      arby.start();  
   }
}
