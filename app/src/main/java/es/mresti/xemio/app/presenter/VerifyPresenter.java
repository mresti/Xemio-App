package es.mresti.xemio.app.presenter;

import es.mresti.xemio.app.interactor.VerifyInteractor;
import es.mresti.xemio.app.view.VerifyView;

public class VerifyPresenter implements Presenter {
  private VerifyView mVerifyView;
  private VerifyInteractor mVerifyInteractor;

  public static VerifyPresenter newInstance(VerifyView verifyView,
      VerifyInteractor verifyInteractor) {
    VerifyPresenter presenter = new VerifyPresenter(verifyView, verifyInteractor);
    presenter.initialize();
    return presenter;
  }

  private VerifyPresenter(VerifyView verifyView, VerifyInteractor verifyInteractor) {
    this.mVerifyView = verifyView;
    this.mVerifyInteractor = verifyInteractor;
  }

  /**
   * Initializes the presenter by start retrieving the user list.
   */
  private void initialize() {
    mVerifyInteractor.setPresenter(this);
  }

  @Override public void resume() {
  }

  @Override public void pause() {
  }

  public void getVerifyUser() {
    mVerifyView.showProgress();
    mVerifyInteractor.getVerify();
  }

  public void onSuccess() {
    mVerifyView.hideProgress();
    mVerifyView.navigateToCancerScreen();
  }

  public void sendEmail() {
    mVerifyView.showProgress2();
    mVerifyInteractor.sendEmailUser();
  }

  public void onSuccess2() {
    mVerifyView.hideProgress2();
    mVerifyView.showDialogSuccess();
  }
}
