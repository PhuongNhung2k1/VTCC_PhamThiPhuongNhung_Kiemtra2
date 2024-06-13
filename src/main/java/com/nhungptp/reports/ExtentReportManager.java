package com.nhungptp.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports getExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("exports/reports/extentreport/extentreport.html");
        reporter.config().setReportName("Extent Report | Nhungptp");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Framework Name", "Selenium Java | Nhungptp");
        extentReports.setSystemInfo("Author", "Nhungptp");
        return extentReports;
    }

}

