package com.expertzlab.listener;

import org.junit.runner.Description;
import org.junit.runner.notification.RunListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * Created by gireeshbabu on 03/05/17.
 */
public class MvnListener implements ITestListener {


    public void onTestStart(ITestResult result) {
        System.out.println("Starting Test -"+ result.getTestClass());
    }

    public void onTestSuccess(ITestResult result) {

    }

    public void onTestFailure(ITestResult result) {

    }

    public void onTestSkipped(ITestResult result) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext context) {



    }

    public void onFinish(ITestContext context) {

    }
}
