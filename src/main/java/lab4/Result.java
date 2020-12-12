package lab4;

import java.util.Map;

public class Result {
    private int id;
    private Map<Integer, String> result;

    public Result(int id, Map<Integer, String> result) {
        this.id = id;
        this.result = result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<Integer, String> getResult() {
        return result;
    }

    public void setResult(Map<Integer, String> result) {
        this.result = result;
    }
}
