package es.mresti.xemio.app.presenter;

import android.content.Context;
import com.firebase.client.Firebase;
import es.mresti.xemio.app.interactor.ChemoInteractor;
import es.mresti.xemio.app.view.ChemoView;

public class ChemoPresenter implements Presenter {
  private ChemoView mChemoView;
  private ChemoInteractor mChemoInteractor;
  private Context mContext;

  public static ChemoPresenter newInstance(ChemoView view, ChemoInteractor interactor) {
    ChemoPresenter presenter = new ChemoPresenter(view, interactor);
    presenter.initialize();
    return presenter;
  }

  private ChemoPresenter(ChemoView view, ChemoInteractor interactor) {
    mChemoView = view;
    mChemoInteractor = interactor;
  }

  private void initialize() {
    mChemoInteractor.setPresenter(this);
  }

  @Override public void resume() {
  }

  @Override public void pause() {
  }

  public void initializeContext(Context c) {
    mContext = c;
    mChemoInteractor.initialize(mContext);
  }

  public void setChemo(String key) {
    mChemoInteractor.setChemo(key);
  }

  public void onSuccess() {
    mChemoView.navigateToDashboardScreen();
  }

  public Firebase getRef() {
    return mChemoInteractor.getChemoRef();
  }
}