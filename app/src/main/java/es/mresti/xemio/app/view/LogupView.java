package es.mresti.xemio.app.view;

public interface LogupView extends BaseView {
  void showProgress();

  void hideProgress();

  void setUsernameError();

  void setEmailError();

  void setAgeError();

  void navigateToVerifyScreen();
}
