package vitals;
 
public abstract class VitalsChecker {
 
  public static boolean vitalsOk(float temperature, float pulseRate, float spo2) throws InterruptedException {
    return isTemperatureOk(temperature) &&
           isPulseRateOk(pulseRate) &&
           isSpo2Ok(spo2);
  }
 
  private static boolean isTemperatureOk(float temperature) throws InterruptedException {
    if (temperature < 95 || temperature > 102) {
      System.out.println("Temperature is critical!");
      showAlertAnimation();
      return false;
    }
    return true;
  }
 
  private static boolean isPulseRateOk(float pulseRate) throws InterruptedException {
    if (pulseRate < 60 || pulseRate > 100) {
      System.out.println("Pulse Rate is out of range!");
      showAlertAnimation();
      return false;
    }
    return true;
  }
 
  private static boolean isSpo2Ok(float spo2) throws InterruptedException {
    if (spo2 < 90) {
      System.out.println("Oxygen Saturation out of range!");
      showAlertAnimation();
      return false;
    }
    return true;
  }
 
  private static void showAlertAnimation() throws InterruptedException {
    for (int i = 0; i < 6; i++) {
      System.out.print("\r* ");
      Thread.sleep(1000);
      System.out.print("\r *");
      Thread.sleep(1000);
    }
    System.out.println(); // clean line
  }
}