package lab4;

import java.util.ArrayList;

public class JSONContainer {
    private final String packageId, jsScript, functionName;
    private final ArrayList<TestContainer> tests

    public JSONContainer(String packageId, String jsScript, String functionName) {
        this.packageId = packageId;
        this.jsScript = jsScript;
        this.functionName = functionName;
    }

    public String getPackageId() {
        return packageId;
    }

    public String getJsScript() {
        return jsScript;
    }

    public String getFunctionName() {
        return functionName;
    }

}
