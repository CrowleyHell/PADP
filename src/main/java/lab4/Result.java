package lab4;

import java.util.Map;

public class Result {
    private String id;
    private Map<Integer, String> result;

    public Result(String id, Map<Integer, String> result) {
        this.id = id;
        this.result = result;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<Integer, String> getResult() {
        return result;
    }

    public void setResult(Map<Integer, String> result) {
        this.result = result;
    }
}
