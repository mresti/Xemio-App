package es.mresti.xemio.app.view;

public interface LogupView extends BaseView {
  void showProgress();

  void hideProgress();

  void setEmailError();

  void setPass1Error();

  void setPass2Error();

  void setPassDistinctError();

  void navigateToExtraScreen();
}
