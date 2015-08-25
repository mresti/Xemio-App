package es.mresti.xemio.app.presenter;

import es.mresti.xemio.app.interactor.LogupInteractor;
import es.mresti.xemio.app.view.LogupView;

public class LogupPresenter implements Presenter {
  private LogupView mLogupView;
  private LogupInteractor mLogupInteractor;

  public static LogupPresenter newInstance(LogupView logupView, LogupInteractor logupInteractor) {
    LogupPresenter presenter = new LogupPresenter(logupView, logupInteractor);
    presenter.initialize();
    return presenter;
  }

  private LogupPresenter(LogupView logupView, LogupInteractor logupInteractor) {
    this.mLogupView = logupView;
    this.mLogupInteractor = logupInteractor;
  }

  /**
   * Initializes the presenter by start retrieving the user list.
   */
  private void initialize() {
    mLogupInteractor.setPresenter(this);
  }

  @Override public void resume() {
  }

  @Override public void pause() {
  }

  public void setRegister(String email, String password1, String password2) {
    mLogupView.showProgress();
    mLogupInteractor.register(email, password1, password2);
  }

  public void onEmailError() {
    mLogupView.setEmailError();
    mLogupView.hideProgress();
  }

  public void onPassError1() {
    mLogupView.setPass1Error();
    mLogupView.hideProgress();
  }

  public void onPassError2() {
    mLogupView.setPass2Error();
    mLogupView.hideProgress();
  }

  public void onPassErrorDistinct() {
    mLogupView.setPassDistinctError();
    mLogupView.hideProgress();
  }

  public void onSuccess() {
    mLogupView.navigateToExtraScreen();
  }
}
