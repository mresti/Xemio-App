package es.mresti.xemio.app.presenter;

import es.mresti.xemio.app.RegisterModel;

public class LogInPresenter implements Presenter {

  private LogInView mLoginView;
  private RegisterModel mRegisterModel;

  public LogInPresenter(LogInView logInView, RegisterModel registerModel) {
    if (logInView == null || registerModel == null) {
      throw new IllegalArgumentException("Constructor parameters cannot be null!!!");
    }
    this.mLoginView = logInView;
    this.mRegisterModel = registerModel;
  }

  @Override public void resume() {}

  @Override public void pause() {}

  /**
   * Initializes the presenter by start retrieving the user list.
   */
  public void initialize() {
    this.loadUserList();
  }

  /**
   * Loads all users.
   */
  private void loadUserList() {
    this.hideViewRetry();
    this.showViewLoading();
  }

  private void showViewLoading() {

  }

  private void hideViewLoading() {

  }

  private void showViewRetry() {

  }

  private void hideViewRetry() {

  }
}
