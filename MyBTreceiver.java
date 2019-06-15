import lejos.nxt.*;
import lejos.nxt.comm.*;
import java.io.*;

/**
 * Receive data from another NXT, a PC, a phone, 
 * or another bluetooth device.
 * 
 * Waits for a connection, receives an int and returns
 * its negative as a reply, 100 times, and then closes
 * the connection, and waits for a new one.
 * 
 * @author Lawrie Griffiths
 *
 */
public class MyBTreceiver {

	public static void main(String [] args)  throws Exception 
	{
		String connected = "Connected";
        String waiting = "Waiting...";
        String closing = "Closing...";
        
		
			LCD.drawString(waiting,0,0);
			LCD.refresh();

	        BTConnection btc = Bluetooth.waitForConnection();
	        
			LCD.clear();
			LCD.drawString(connected,0,0);
			LCD.refresh();	

			DataInputStream dis = btc.openDataInputStream();
			DataOutputStream dos = btc.openDataOutputStream();
			//Motor.C.setSpeed(720);
			
/*			
bluetooth commands

send    action
1		  stop
2		  backward
3		  forward
4		  move arm
5		  rotate(360)
6		  rotate(-360)
7		  rotate(whatever 20 centimeters is)s*/
			
			int end = 0;
			while (end != 20) {
			end = dis.readInt();
			LCD.refresh();
			LCD.drawString("here", 0, 0);
			LCD.drawInt(end, 0, 0);
			
			if (end == 1) {
			  	LCD.clear();
			  	LCD.drawString("stop",0,0);
			  	Motor.A.stop();
		        Motor.B.stop();
			   
			  }
			else if (end == 2) {
			  	LCD.clear();
			  	LCD.drawString("backward",0,0);
			  	Motor.A.backward();
		        Motor.B.backward();
			   
			  }
			 else if (end == 3) {
			  	LCD.clear();
			    LCD.drawString("forward",0,0);
			    Motor.A.forward();
		        Motor.B.forward();
			    
			  }
			  
			  else if (end == 4) {
			  	LCD.clear();
			  	LCD.drawString("4Move Arm",0,0);
			  	
			  	Motor.C.rotate(80);
			  	Motor.C.rotate(-75);
			    //Motor.B.forward();
				//Motor.C.forward();
			  }
			  else if (end == 5) {
			  	LCD.clear();
			    LCD.drawString("Rotate 720",0,0);
			    Motor.A.rotate(-540);
			    Motor.B.flt();
		        
			    
			  }
			  else if (end == 6) {
			  	LCD.clear();
			    LCD.drawString("Rotate -720",0,0);
			    Motor.A.rotate(-720);
			    Motor.B.flt();
		        
			    
			  }
			  else if (end == 7) {
			  	LCD.clear();
			    LCD.drawString("forward",0,0);
			    Motor.A.forward();
		        Motor.B.forward();
			    
			  }
			  else if (end == 8) {
			  	LCD.clear();
			    LCD.drawString("forward",0,0);
			    Motor.A.rotate(360);
			    Motor.B.flt();
			    
			  }
			  
			}
			
			dis.close();
			dos.close();
			Thread.sleep(100); // wait for data to drain
			LCD.clear();
			LCD.drawString(closing,0,0);
			LCD.refresh();
			btc.close();
			LCD.clear();
		
	}
}

