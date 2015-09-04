package es.mresti.xemio.app.model;

public class Incidence {
  private String subject;
  private String description;

  public Incidence() {
  }

  public Incidence(String subject, String description) {
    this.subject = subject;
    this.description = description;
  }

  public String getSubject() {
    return subject;
  }

  public String getDescription() {
    return description;
  }
}
