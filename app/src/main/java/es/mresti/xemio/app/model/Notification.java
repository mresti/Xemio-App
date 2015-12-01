package es.mresti.xemio.app.model;

public class Notification {
  private String date;
  private String message;

  public Notification() {
  }

  public Notification(String date, String message) {
    this.date = date;
    this.message = message;
  }

  public String getDate() {
    return date;
  }

  public String getMessage() {
    return message;
  }
}
