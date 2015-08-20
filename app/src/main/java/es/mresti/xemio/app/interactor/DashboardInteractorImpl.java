package es.mresti.xemio.app.interactor;

import es.mresti.xemio.app.presenter.DashboardPresenter;

public class DashboardInteractorImpl implements DashboardInteractor {
  private DashboardPresenter presenter;

  @Override public void setPresenter(DashboardPresenter presenter) {
    this.presenter = presenter;
  }
}

