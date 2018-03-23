package jsonParser.jsonParserHelpers;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

import java.io.IOException;

public class ExceptionCustom implements TestExecutionExceptionHandler {
    @Override
    public void handleTestExecutionException(ExtensionContext extensionContext, Throwable throwable) throws Throwable {
        if (throwable instanceof IOException) {
            return;
        }
        throw throwable;
    }
}
