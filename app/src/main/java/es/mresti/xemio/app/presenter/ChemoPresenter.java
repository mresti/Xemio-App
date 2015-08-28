package es.mresti.xemio.app.presenter;

import android.content.Context;
import es.mresti.xemio.app.interactor.ChemoInteractor;
import es.mresti.xemio.app.view.ChemoView;

public class ChemoPresenter implements Presenter {
  private ChemoView mChemoView;
  private ChemoInteractor mChemoInteractor;
  private Context mContext;

  public static ChemoPresenter newInstance(ChemoView chemoView, ChemoInteractor chemoInteractor) {
    ChemoPresenter presenter = new ChemoPresenter(chemoView, chemoInteractor);
    presenter.initialize();
    return presenter;
  }

  private ChemoPresenter(ChemoView chemoView, ChemoInteractor chemoInteractor) {
    this.mChemoView = chemoView;
    this.mChemoInteractor = chemoInteractor;
  }

  /**
   * Initializes the presenter by start retrieving the user list.
   */
  private void initialize() {
    mChemoInteractor.setPresenter(this);
  }

  @Override public void resume() {
  }

  @Override public void pause() {
  }

  public void setChemo() {
    mChemoView.showProgress();
    mChemoInteractor.setChemo(this.mContext);
  }

  public void onSuccess() {
    mChemoView.hideProgress();
    mChemoView.navigateToPassScreen();
  }

  public void initializeContext(Context c) {
    this.mContext = c;
  }
}