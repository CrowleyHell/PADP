package lab4;

import java.util.ArrayList;

public class UnitT {
    private final String packageID, jsScript, functionName, testName, expectedResulr;
    private final ArrayList<Integer> params;

    public UnitT(String packageID, String jsScript, String functionName, String testName, String expectedResulr, ArrayList<Integer> params) {
        this.packageID = packageID;
        this.jsScript = jsScript;
        this.functionName = functionName;
        this.testName = testName;
        this.expectedResulr = expectedResulr;
        this.params = params;
    }
}
