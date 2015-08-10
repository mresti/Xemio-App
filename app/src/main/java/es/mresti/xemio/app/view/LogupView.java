package es.mresti.xemio.app.view;

public interface LogupView extends BaseView {
  public void showProgress();

  public void hideProgress();

  public void setUsernameError();

  public void setEmailError();

  public void setAgeError();

  public void navigateToVerifyScreen();
}
