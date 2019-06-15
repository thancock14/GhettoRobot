import lejos.nxt.*;

public class SonicTest {
  public static void main(String[] args) throws Exception {
    UltrasonicSensor sonic = new UltrasonicSensor(SensorPort.S2);

    while (!Button.ESCAPE.isPressed()) {
      
      LCD.drawString(sonic.getVersion(), 0, 0);
      LCD.drawString(sonic.getProductID(), 0, 1);
      LCD.drawString(sonic.getSensorType(), 0, 2);
      LCD.drawInt(sonic.getDistance(), 0, 3);
    }
  }
}