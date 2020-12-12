package lab4;

import java.util.ArrayList;

public class UnitT {
    private final String packageID, jsScript, functionName, testName, expectedResult;
    private final ArrayList<Integer> params;

    public UnitT(String packageID, String jsScript, String functionName, String testName, String expectedResulr, ArrayList<Integer> params) {
        this.packageID = packageID;
        this.jsScript = jsScript;
        this.functionName = functionName;
        this.testName = testName;
        this.expectedResult = expectedResulr;
        this.params = params;
    }

    public String getPackageID() {
        return packageID;
    }

    public String getJsScript() {
        return jsScript;
    }

    public String getFunctionName() {
        return functionName;
    }

    public String getTestName() {
        return testName;
    }

    public String getExpectedResulr() {
        return expectedResult;
    }

    public ArrayList<Integer> getParams() {
        return params;
    }

    @Override
    public String toString() {
        return "UnitT{" +
                "params=" + params +
                '}';
    }
}
