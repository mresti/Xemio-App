package es.mresti.xemio.app.presenter;

import es.mresti.xemio.app.interactor.CancerInteractor;
import es.mresti.xemio.app.view.CancerView;

public class CancerPresenter implements Presenter {
  private CancerView mCancerView;
  private CancerInteractor mCancerInteractor;

  public static CancerPresenter newInstance(CancerView cancerView,
      CancerInteractor cancerInteractor) {
    CancerPresenter presenter = new CancerPresenter(cancerView, cancerInteractor);
    presenter.initialize();
    return presenter;
  }

  private CancerPresenter(CancerView cancerView, CancerInteractor cancerInteractor) {
    this.mCancerView = cancerView;
    this.mCancerInteractor = cancerInteractor;
  }

  /**
   * Initializes the presenter by start retrieving the user list.
   */
  private void initialize() {
    mCancerInteractor.setPresenter(this);
  }

  @Override public void resume() {
  }

  @Override public void pause() {
  }

  public void setCancer() {
    mCancerView.showProgress();
    mCancerInteractor.setCancer();
  }

  public void onSuccess() {
    mCancerView.hideProgress();
    mCancerView.navigateToChemoScreen();
  }
}