package pl.korbeldaniel.demo.ui.client;

public class MyModel {
    private String uuid;

    private String activeScreen;

    public MyModel() {
        uuid = UUID.get();
    }

    public MyModel(String activeScreen) {
        uuid = UUID.get();
        this.activeScreen = activeScreen;
    }

    public String getUuid() {
        return this.uuid;
    }

    public String getActiveScreen() {
        return this.activeScreen;
    }

    public void setActiveScreen(String activeScreen) {
        this.activeScreen = activeScreen;
    }
}
