package lab4;

import java.util.ArrayList;

public class JSONContainer {
    private final String packageID, jsScript, functionName;
    private final ArrayList<TestContainer> test

    public JSONContainer(String packageID, String jsScript, String functionName) {
        this.packageID = packageID;
        this.jsScript = jsScript;
        this.functionName = functionName;
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

}
