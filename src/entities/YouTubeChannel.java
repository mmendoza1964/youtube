package entities;

public class YouTubeChannel {
    private String name;
    private int subscribers;

    public YouTubeChannel(String name, int subscribers) {
        this.name = name;
        this.subscribers = subscribers;
    }

    public String name() {
        return name;
    }

    public void name(String name) {
        this.name = name;
    }

    public int subscribers() {
        return subscribers;
    }

    public void subscribers(int subscribers) {
        this.subscribers = subscribers;
    }
}
