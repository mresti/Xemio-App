package es.mresti.xemio.app.interactor;

import es.mresti.xemio.app.presenter.RegisterPresenter;

public class RegisterInteractorImpl implements RegisterInteractor {
  private RegisterPresenter presenter;

  @Override public void setPresenter(RegisterPresenter presenter) {
    this.presenter = presenter;
  }

}
