package es.mresti.xemio.app.view;

public interface ExtraView extends BaseView {
  void showProgress();

  void hideProgress();

  void setUsernameError();

  void setAgeError();

  void navigateToChemoScreen();
}

