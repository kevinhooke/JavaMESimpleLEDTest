package javameledtest;

import javax.microedition.midlet.MIDlet;
import jdk.dio.DeviceManager;
import jdk.dio.gpio.GPIOPin;
import jdk.dio.gpio.GPIOPinConfig;
import static jdk.dio.gpio.GPIOPinConfig.DIR_OUTPUT_ONLY;

/**
 * 
 * @author kevinhooke
 */
public class JavaMELedTest extends MIDlet {

    private GPIOPin led;

    @Override
    public void startApp() {
            try {
                this.led = (GPIOPin) DeviceManager.open(new GPIOPinConfig.Builder()
                        .setPinNumber(27)
                        .setDirection(DIR_OUTPUT_ONLY)
                        .build());
                //this.led = DeviceManager.open("GPIO27", GPIOPin.class, GPIOPinConfig.DIR_OUTPUT_ONLY);
                //this.led = DeviceManager.open(9, GPIOPin.class, GPIOPinConfig.DIR_OUTPUT_ONLY);
                this.testLed();
            } catch (Exception e) {
                e.printStackTrace();

            }
        //}
    }

    @Override
    public void destroyApp(boolean unconditional) {
    }

    private void testLed() throws Exception {
        //while(true){
        System.out.println("turning on...");
        this.led.setValue(true);
        Thread.sleep(1000);
        System.out.println("turning off...");
        this.led.setValue(false);
        Thread.sleep(1000);
    }
}