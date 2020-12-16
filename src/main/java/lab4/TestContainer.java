package lab4;

import java.util.ArrayList;

public class TestContainer {
    private final String testName, expectedResult;
    private final ArrayList<Object> params;

    public TestContainer(String testName, String expectedResult, ArrayList<Object> params) {
        this.testName = testName;
        this.expectedResult = expectedResult;
        this.params = params;
    }

    public String getTestName() {
        return testName;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public ArrayList<Object> getParams() {
        return params;
    }
}
