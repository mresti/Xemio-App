package es.mresti.xemio.app.interactor;

import es.mresti.xemio.app.presenter.MainPresenter;

public class MainInteractorImpl implements MainInteractor {
  private MainPresenter presenter;

  @Override public void setPresenter(MainPresenter presenter) {
    this.presenter = presenter;
  }

  @Override public void userStatus() {
    // show dashboardActivity

    // show verifyActivity

    // show mainActivity

  }
}
