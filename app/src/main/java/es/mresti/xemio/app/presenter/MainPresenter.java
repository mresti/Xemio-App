package es.mresti.xemio.app.presenter;

import android.content.Context;
import es.mresti.xemio.app.interactor.MainInteractor;
import es.mresti.xemio.app.view.MainView;

public class MainPresenter implements Presenter {
  private MainView mMainView;
  private MainInteractor mMainInteractor;

  public static MainPresenter newInstance(MainView mainView, MainInteractor mainInteractor) {
    MainPresenter presenter = new MainPresenter(mainView, mainInteractor);
    presenter.initialize();
    return presenter;
  }

  private MainPresenter(MainView mainView, MainInteractor mainInteractor) {
    this.mMainView = mainView;
    this.mMainInteractor = mainInteractor;
  }

  /**
   * Initializes the presenter by start retrieving the user list.
   */
  private void initialize() {
    mMainInteractor.setPresenter(this);
  }

  @Override public void resume() {
  }

  @Override public void pause() {
  }

  public void onSuccessAuth() {
    mMainView.hideProgress();
    mMainView.navigateToDashboardScreen();
  }

  public void onFailAuth() {
    mMainView.showProgress();
  }

  public void onSuccess() {
    mMainView.navigateToDashboardScreen();
  }

  public void getUserStatus(Context c) {
    mMainInteractor.userStatus(c);
  }
}
