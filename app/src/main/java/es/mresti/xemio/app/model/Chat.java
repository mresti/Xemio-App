package es.mresti.xemio.app.model;

public class Chat {
  private String message;
  private String author;

  public Chat(String message, String author) {
    this.message = message;
    this.author = author;
  }

  public Chat() {
  }

  public String getMessage() {
    return message;
  }

  public String getAuthor() {
    return author;
  }
}
