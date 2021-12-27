package reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import constants.FrameworkConstants;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
public final class ExtentReport {
    private  ExtentReport() {
    }
    private static ExtentReports extent;
    public static void initReports() throws Exception {
        if(Objects.isNull(extent)) {
            extent = new ExtentReports();
            ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFolderPath());
            extent.attachReporter(spark);
            spark.config().setTheme(Theme.STANDARD);
            spark.config().setDocumentTitle("Swag Labs Automation Report");
            spark.config().setReportName("Run Results");
        }
    }
    public static void flushReports() throws IOException {
        if(Objects.nonNull(extent)) {
            extent.flush();
            try {
                ExtentManager.unLoad();
                Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFolderPath()).toURI());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void createTest(String username) {
        ExtentManager.setExtentTest(extent.createTest(username));
    }
}

