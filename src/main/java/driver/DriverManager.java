package driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {
    private DriverManager(){}
    private static ThreadLocal<WebDriver>driverThreadLocal=new ThreadLocal<>();
    public static WebDriver getDriver(){
        return driverThreadLocal.get();
    }
    public static void setDriver(WebDriver driverref){
        driverThreadLocal.set(driverref);
    }
    public static void unLoad(){
        driverThreadLocal.remove();
    }
}