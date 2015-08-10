package es.mresti.xemio.app.presenter;

import es.mresti.xemio.app.interactor.PassInteractor;
import es.mresti.xemio.app.view.PassView;

public class PassPresenter implements Presenter {
  private PassView mPassView;
  private PassInteractor mPassInteractor;

  public static PassPresenter newInstance(PassView passView, PassInteractor passInteractor) {
    PassPresenter presenter = new PassPresenter(passView, passInteractor);
    presenter.initialize();
    return presenter;
  }

  private PassPresenter(PassView passView, PassInteractor passInteractor) {
    this.mPassView = passView;
    this.mPassInteractor = passInteractor;
  }

  /**
   * Initializes the presenter by start retrieving the user list.
   */
  private void initialize() {
    mPassInteractor.setPresenter(this);
  }

  @Override public void resume() {
  }

  @Override public void pause() {
  }

  public void validatePass(String password1, String password2) {
    mPassView.showProgress();
    mPassInteractor.setPass(password1, password2);
  }

  public void onPassError1() {
    mPassView.setPass1Error();
    mPassView.hideProgress();
  }

  public void onPassError2() {
    mPassView.setPass2Error();
    mPassView.hideProgress();
  }

  public void onPassErrorDistinct() {
    mPassView.setPassDistinctError();
    mPassView.hideProgress();
  }

  public void onSuccess() {
    mPassView.navigateToHome();
  }
}
