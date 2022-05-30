package utils;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.AfterTestExecutionCallback;
import org.junit.jupiter.api.extension.ExtensionContext;

public class RunnerExtension implements AfterTestExecutionCallback {

    @Override
    public void afterTestExecution(ExtensionContext context) throws Exception {
        Boolean testResult = context.getExecutionException().isPresent();
        if (testResult){//false - SUCCESS, true - FAILED
            Utils.saveScreenshotPNG();
            Allure.description("Test is Failed on Chrome v.102.0");
        }


    }
}
