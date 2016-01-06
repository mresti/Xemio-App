package es.mresti.xemio.app.model;

public class Historical {
  private String adviceKey;
  private String adviceName;

  public Historical(String key, String name) {
    this.adviceKey = key;
    this.adviceName = name;
  }

  public Historical() {
  }

  public String getAdviceKey() {
    return adviceKey;
  }

  public String getAdviceName() {
    return adviceName;
  }
}
