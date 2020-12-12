package lab4;

public class TestResult {
    private String name, res, ID;

    public TestResult(String ID, String name, String res) {
        this.ID = ID;
        this.name = name;
        this.res = res;
    }

    public String getID() {
        return ID;
    }

    public String getRes() {
        return res;
    }

    public String getName() {
        return name;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRes(String res) {
        this.res = res;
    }
}
