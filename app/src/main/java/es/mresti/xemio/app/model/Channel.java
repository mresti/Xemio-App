package es.mresti.xemio.app.model;

public class Channel {
  String pacient;
  String foundation;
  String chatId;

  public Channel(String pacient, String foundation, String chatId) {
    this.pacient = pacient;
    this.foundation = foundation;
    this.chatId = chatId;
  }

  public Channel() {
  }

  public String getPacient() {
    return pacient;
  }

  public String getFoundation() {
    return foundation;
  }

  public String getChatId() {
    return chatId;
  }
}
