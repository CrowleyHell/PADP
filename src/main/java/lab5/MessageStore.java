package lab5;

public class MessageStore {
    private final String url;
    private final int time;

    public MessageStore(String url, int time) {
        this.url = url;
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public int getTime() {
        return time;
    }
}
