package es.mresti.xemio.app.presenter;

import android.content.Context;
import es.mresti.xemio.app.interactor.RegisterInteractor;
import es.mresti.xemio.app.view.RegisterView;

public class RegisterPresenter implements Presenter {
  private RegisterView mRegisterView;
  private RegisterInteractor mRegisterInteractor;
  private Context mContext;

  public static RegisterPresenter newInstance(RegisterView registerView,
      RegisterInteractor registerInteractor) {
    RegisterPresenter presenter = new RegisterPresenter(registerView, registerInteractor);
    presenter.initialize();
    return presenter;
  }

  private RegisterPresenter(RegisterView registerView, RegisterInteractor registerInteractor) {
    this.mRegisterView = registerView;
    this.mRegisterInteractor = registerInteractor;
  }

  /**
   * Initializes the presenter by start retrieving the user list.
   */
  private void initialize() {
    mRegisterInteractor.setPresenter(this);
  }

  @Override public void resume() {
  }

  @Override public void pause() {
  }

  public void initializeContext(Context c) {
    mContext = c;
    mRegisterInteractor.initialize(mContext);
  }
}
