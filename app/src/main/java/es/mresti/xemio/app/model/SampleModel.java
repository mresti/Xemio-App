package es.mresti.xemio.app.model;

public class SampleModel {
  private String mText;

  public SampleModel(String text) {
    this.mText = text;
  }

  public void setSampleText(String text) {
    this.mText = text;
  }

  public String getSampleText() {
    return mText;
  }
}