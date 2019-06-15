import lejos.robotics.subsumption.*;
import lejos.nxt.*;
import lejos.nxt.comm.*;
import java.io.*;
import javax.bluetooth.*;

public class blueTooth  {
	RemoteDevice btrd = null;
	BTConnection btc = null;
	DataInputStream dis;
	DataOutputStream dos;
	
	public blueTooth(int num)
	{
   if(num == 1)
   {
  // Change this to the name of your receiver
		String name = "Receiver";
		
		LCD.drawString("Connecting...", 0, 0);
		LCD.refresh();
		
		 btrd = Bluetooth.getKnownDevice(name);
		 
		
		if (btrd == null) {
		  LCD.clear();
		  LCD.drawString("No such device", 0, 0);
		  LCD.refresh();
		  try{
		  Thread.sleep(2000);
		  }
		  catch(Exception e) {}
		  System.exit(1);
		}
		
		 btc = Bluetooth.connect(btrd);
		 LCD.refresh();
		 //LCD.drawString("Here", 0, 0);
		 try{
		  Thread.sleep(2000);
		  }
		  catch(Exception e) {}
		
		if (btc == null) {
		  LCD.clear();
		  LCD.drawString("Connect fail", 0, 0);
		  LCD.refresh();
		  try{
		  Thread.sleep(2000);
		  }
		  catch(Exception e) {}
		  System.exit(1);
		}
		
		LCD.clear();
		LCD.drawString("Connected", 0, 0);
		try{
		  Thread.sleep(2000);
		  }
		  catch(Exception e) {}
		LCD.refresh();
		
         dis = btc.openDataInputStream();
		 dos = btc.openDataOutputStream();
		}
		
  
  }
  
  
  
   
   public void Send(int sender)
   {
      try{
         
		 dos.writeInt(sender);//send move backward
		    dos.flush();
		    
		  }
		  catch(Exception e) {LCD.drawString("error didn't sent", 0, 0);
		  try{
		 Thread.currentThread().sleep(500);
		  }
		  catch(Exception j) {}}
      
		    
   }
   
   public int Receive()
   {
     int receiver = 0;
     
     
     try{
		receiver = dis.readInt();
		  }
		  catch(Exception e) {}
     return receiver;
   }
}
