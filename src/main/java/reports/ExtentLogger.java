package reports;
import com.aventstack.extentreports.MediaEntityBuilder;
import enums.ConfigProperties;
import utils.ReadPropertyFile;
import utils.ScreenShotUtil;
public final class ExtentLogger {
    private ExtentLogger(){}
    public static void pass(String message){
        ExtentManager.getExtentTest().pass(message);
    }
     public static void fail(String message){
        ExtentManager.getExtentTest().fail(message);
    }
     public static  void skip(String message){
        ExtentManager.getExtentTest().skip(message);
     }
     public static void pass(String message,boolean isScreenShotNeeded) throws Exception {
        if (ReadPropertyFile.get(ConfigProperties.PASSEDSTEPSCREENSHOT).equalsIgnoreCase("yes")&&
            isScreenShotNeeded){
            ExtentManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtil.getBase64Image()).build());
        }else{
            pass(message);
        }
     }
    public static void fail(String message,boolean isScreenShotNeeded) throws Exception {
        if (ReadPropertyFile.get(ConfigProperties.FAILEDSTEPSCREENSHOT).equalsIgnoreCase("yes")&&
                isScreenShotNeeded){
            ExtentManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtil.getBase64Image()).build());
        }else{
            fail(message);
        }
    }
    public static void skip(String message,boolean isScreenShotNeeded) throws Exception {
        if (ReadPropertyFile.get(ConfigProperties.SKIPPEDSTEPSCREENSHOT).equalsIgnoreCase("yes")&&
                isScreenShotNeeded){
            ExtentManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(ScreenShotUtil.getBase64Image()).build());
        }else {
            skip(message);
        }
    }


}
