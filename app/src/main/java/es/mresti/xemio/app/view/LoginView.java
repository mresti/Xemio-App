package es.mresti.xemio.app.view;

public interface LoginView extends BaseView {
  void showProgress();

  void hideProgress();

  void setUsernameError();

  void setPasswordError();

  void navigateToHome();
}
