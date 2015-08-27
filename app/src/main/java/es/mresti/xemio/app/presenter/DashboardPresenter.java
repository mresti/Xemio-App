package es.mresti.xemio.app.presenter;

import android.content.Context;
import es.mresti.xemio.app.interactor.DashboardInteractor;
import es.mresti.xemio.app.view.DashboardView;

public class DashboardPresenter implements Presenter {
  private DashboardView mDashboardView;
  private DashboardInteractor mDashboardInteractor;
  private Context mContext;

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

  public void initializeContext(Context c) {
    this.mContext = c;
  }

  @Override public void resume() {
  }

  @Override public void pause() {
  }

  public void onSuccessAuth() {
  }

  public void onFailAuth() {
    mDashboardView.navigateToMainScreen();
  }

  public void getUserStatus() {
    mDashboardView.hideProgress();
    mDashboardInteractor.userStatus(this.mContext);
  }
}