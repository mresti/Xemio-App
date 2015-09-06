package es.mresti.xemio.app.presenter;

import android.content.Context;
import com.firebase.client.Firebase;
import es.mresti.xemio.app.interactor.DetailEffectInteractor;
import es.mresti.xemio.app.view.DetailEffectView;

public class DetailEffectPresenter implements Presenter {
  private DetailEffectView mDetailEffectView;
  private DetailEffectInteractor mDetailEffectInteractor;
  private Context mContext;

  public static DetailEffectPresenter newInstance(DetailEffectView view,
      DetailEffectInteractor interactor) {
    DetailEffectPresenter presenter = new DetailEffectPresenter(view, interactor);
    presenter.initialize();
    return presenter;
  }

  private DetailEffectPresenter(DetailEffectView view, DetailEffectInteractor interactor) {
    mDetailEffectView = view;
    mDetailEffectInteractor = interactor;
  }

  private void initialize() {
    mDetailEffectInteractor.setPresenter(this);
  }

  @Override public void resume() {

  }

  @Override public void pause() {

  }

  public void initializeContext(Context c) {
    mContext = c;
    mDetailEffectInteractor.initialize(mContext);
  }

  public Firebase getRef(String key) {
    return mDetailEffectInteractor.getEffectRef(key);
  }
}
