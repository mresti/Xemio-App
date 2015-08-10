package es.mresti.xemio.app.view;

public interface LoginView extends BaseView {
  public void showProgress();

  public void hideProgress();

  public void setUsernameError();

  public void setPasswordError();

  public void navigateToHome();
}
