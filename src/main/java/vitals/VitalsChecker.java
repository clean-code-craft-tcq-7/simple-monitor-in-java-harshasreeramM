package vitals;


public abstract class VitalsChecker {

  static void displayError(String message){
    System.out.println(message);
    for (int i = 0; i < 6; i++) {
        System.out.print("\r* ");
        Thread.sleep(1000);
        System.out.print("\r *");
        Thread.sleep(1000);
      }
  }

  static boolean vitalsOk(float temperature, float pulseRate, float spo2) 
      throws InterruptedException {
    if (temperature > 102 || temperature < 95) {
      displayError("Temperature is critical!");
      return false;
    } else if (pulseRate < 60 || pulseRate > 100) {
      displayError("Pulse Rate is out of range!");
      return false;
    } else if (spo2 < 90) {
      displayError("Oxygen Saturation out of range!");
      return false;
    }
    return true;
  }
}
