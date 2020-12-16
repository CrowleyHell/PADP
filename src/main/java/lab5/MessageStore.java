package lab5;

public class MessageStore {
    private final String url;
    private final Float time;

    public MessageStore(String url, Float time) {
        this.url = url;
        this.time = time;
    }

    public String getUrl() {
        return url;
    }

    public Float getTime() {
        return time;
    }
}
