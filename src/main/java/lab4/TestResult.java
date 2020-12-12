package lab4;

public class TestResult {
    private int ID;
    private String name, res;

    public TestResult(int ID, String name, String res) {
        this.ID = ID;
        this.name = name;
        this.res = res;
    }

    public int getID() {
        return ID;
    }

    public String getRes() {
        return res;
    }

    public String getName() {
        return name;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRes(String res) {
        this.res = res;
    }
}
