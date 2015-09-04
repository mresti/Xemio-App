package es.mresti.xemio.app.model;

public class Treatment {
  private String title;
  private String description;
  private String treatments;

  public Treatment() {

  }

  public Treatment(String title, String description, String treatments) {
    this.title = title;
    this.description = description;
    this.treatments = treatments;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getTreatments() {
    return treatments;
  }

  public void setTreatments(String treatments) {
    this.treatments = treatments;
  }
}
