package es.mresti.xemio.app.presenter;

import android.content.Context;
import es.mresti.xemio.app.interactor.DashboardInteractor;
import es.mresti.xemio.app.view.DashboardView;

public class DashboardPresenter implements Presenter {
  private DashboardView mDashboardView;
  private DashboardInteractor mDashboardInteractor;
  private Context mContext;

  public static DashboardPresenter newInstance(DashboardView view, DashboardInteractor interactor) {
    DashboardPresenter presenter = new DashboardPresenter(view, interactor);
    presenter.initialize();
    return presenter;
  }

  private DashboardPresenter(DashboardView view, DashboardInteractor interactor) {
    this.mDashboardView = view;
    this.mDashboardInteractor = interactor;
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

  public void initializeContext(Context c) {
    mContext = c;
    mDashboardInteractor.initialize(mContext);
  }

  public void onFailAuth() {
    mDashboardView.navigateToMainScreen();
  }

  public void getUserStatus() {
    mDashboardInteractor.userStatus();
  }
}