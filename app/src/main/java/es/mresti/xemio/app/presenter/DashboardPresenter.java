package es.mresti.xemio.app.presenter;

import es.mresti.xemio.app.interactor.DashboardInteractor;
import es.mresti.xemio.app.view.DashboardView;

public class DashboardPresenter implements Presenter {
  private DashboardView mDashboardView;
  private DashboardInteractor mDashboardInteractor;

  public static DashboardPresenter newInstance(DashboardView dashboardView,
      DashboardInteractor dashboardInteractor) {
    DashboardPresenter presenter = new DashboardPresenter(dashboardView, dashboardInteractor);
    presenter.initialize();
    return presenter;
  }

  private DashboardPresenter(DashboardView dashboardView, DashboardInteractor dashboardInteractor) {
    this.mDashboardView = dashboardView;
    this.mDashboardInteractor = dashboardInteractor;
  }

  /**
   * Initializes the presenter by start retrieving the user list.
   */
  private void initialize() {
    mDashboardInteractor.setPresenter(this);
  }

  @Override public void resume() {
  }

  @Override public void pause() {
  }
}