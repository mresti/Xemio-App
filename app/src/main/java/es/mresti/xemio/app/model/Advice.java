package es.mresti.xemio.app.model;

public class Advice {
  private String category;
  private String advice;
  private String effect;

  public Advice() {
  }

  public Advice(String category,String effect, String advice) {
    this.category = category;
    this.advice = advice;
    this.effect = effect;
  }

  public String getCategory() {
    return category;
  }

  public String getEffect() {
    return effect;
  }

  public String getAdvice() {
    return advice;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public void setAdvice(String advice) {
    this.advice = advice;
  }

  public void setEffect(String effect) {
    this.effect = effect;
  }
}
