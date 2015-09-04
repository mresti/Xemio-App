package es.mresti.xemio.app.model;

public class Advice {
  private String idCategory;
  private String advice;

  public Advice() {
  }

  public Advice(String idCategory, String advice) {
    this.idCategory = idCategory;
    this.advice = advice;
  }

  public String getIdCategory() {
    return idCategory;
  }

  public String getAdvice() {
    return advice;
  }
}
