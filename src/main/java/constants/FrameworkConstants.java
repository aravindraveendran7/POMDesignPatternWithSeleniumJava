package constants;

import enums.ConfigProperties;
import utils.ReadPropertyFile;

public final class FrameworkConstants {
    private static final String RESOURCEPATH=System.getProperty("user.dir")+"/src/test/Resources";
    private static final String CONFIGFILEPATH=RESOURCEPATH+"/config/config.properties";
    private static final String TESTDATAPATH=RESOURCEPATH+"/testdata/TestData.xlsx";
    private static final int EXPLICITWAIT=20;
    private static final String EXTENTREPORTFOLDERPATH=RESOURCEPATH+"/extentreports/";
    private static String extentReportFilePath="";

    private FrameworkConstants(){}
    public static String getConfigFilePath() {
        return CONFIGFILEPATH;
    }
    public static int getExplicitWait() {
        return EXPLICITWAIT;
    }
    public static String getExtentReportFolderPath() throws Exception {
        if (extentReportFilePath.isEmpty()){
            extentReportFilePath=createReportPath();
        }
        return extentReportFilePath;
    }
    private static String createReportPath() throws Exception {
        if (ReadPropertyFile.get(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no")) {
            return EXTENTREPORTFOLDERPATH+System.currentTimeMillis()+"index.html";
        }
        else {
            return EXTENTREPORTFOLDERPATH+"/index.html";
        }
    }
    public static String getTestDataPath() {
        return TESTDATAPATH;
    }
}
