package lab4;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

import java.util.ArrayList;

public class TestContainer {
    private final String testName, expectedResult;
    private final ArrayList<Object> params;

    @JsonCreator
    public TestContainer(@JsonProperty("testName")String testName, @JsonProperty("expectedResult") String expectedResult, @JsonProperty("params") ArrayList<Object> params) {
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
