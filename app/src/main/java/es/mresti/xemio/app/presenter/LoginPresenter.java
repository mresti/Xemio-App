package es.mresti.xemio.app.presenter;

import es.mresti.xemio.app.interactor.LoginInteractor;
import es.mresti.xemio.app.view.LoginView;

public class LoginPresenter implements Presenter {
  private LoginView mLoginView;
  private LoginInteractor mLoginInteractor;

  public static LoginPresenter newInstance(LoginView loginView, LoginInteractor loginInteractor) {
    LoginPresenter presenter = new LoginPresenter(loginView, loginInteractor);
    presenter.initialize();
    return presenter;
  }

  private LoginPresenter(LoginView loginView, LoginInteractor loginInteractor) {
    this.mLoginView = loginView;
    this.mLoginInteractor = loginInteractor;
  }

  /**
   * Initializes the presenter by start retrieving the user list.
   */
  private void initialize() {
    mLoginInteractor.setPresenter(this);
  }

  @Override public void resume() {
  }

  @Override public void pause() {
  }

  public void validateCredentials(String username, String password) {
    mLoginView.showProgress();
    mLoginInteractor.login(username, password);
  }

  public void onUsernameError() {
    mLoginView.setUsernameError();
    mLoginView.hideProgress();
  }

  public void onPasswordError() {
    mLoginView.setPasswordError();
    mLoginView.hideProgress();
  }

  public void onSuccess() {
    mLoginView.navigateToHome();
  }
}