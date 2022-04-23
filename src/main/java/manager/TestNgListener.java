package manager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;
import org.testng.*;

public class TestNgListener implements ITestListener, ISuiteListener {

    Logger logger= LoggerFactory.getLogger(TestNgListener.class);


    @Override
    public void onTestStart(ITestResult result) { //genereate->override->onStart
        ITestListener.super.onTestStart(result);
        logger.info("onTestStart"+result.getTestName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
    }



    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
    }


    @Override
    public void onStart(ISuite suite) {
        ISuiteListener.super.onStart(suite);
        logger.info("onStart(ISuite suite)");
    }


    @Override
    public void onFinish(ISuite suite) {
        ISuiteListener.super.onFinish(suite);
        logger.info("onFinish(ISuite suite)");
    }
}
