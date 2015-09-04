package es.mresti.xemio.app.presenter;

import android.content.Context;
import com.firebase.client.Firebase;
import es.mresti.xemio.app.interactor.DetailIncidenceInteractor;
import es.mresti.xemio.app.view.DetailIncidenceView;

public class DetailIncidencePresenter implements Presenter {
  private DetailIncidenceView mDetailIncidenceView;
  private DetailIncidenceInteractor mDetailIncidenceInteractor;
  private Context mContext;

  public static DetailIncidencePresenter newInstance(DetailIncidenceView view,
      DetailIncidenceInteractor interactor) {
    DetailIncidencePresenter presenter = new DetailIncidencePresenter(view, interactor);
    presenter.initialize();
    return presenter;
  }

  private DetailIncidencePresenter(DetailIncidenceView view, DetailIncidenceInteractor interactor) {
    this.mDetailIncidenceView = view;
    this.mDetailIncidenceInteractor = interactor;
  }

  private void initialize() {
    mDetailIncidenceInteractor.setPresenter(this);
  }

  @Override public void resume() {

  }

  @Override public void pause() {

  }

  public void initializeContext(Context c) {
    mContext = c;
    mDetailIncidenceInteractor.initialize(mContext);
  }

  public Firebase getRef(String key) {
    return mDetailIncidenceInteractor.getIncidenceRef(key);
  }

  public void removeIncidence(String key) {
    mDetailIncidenceInteractor.removeItem(key);
  }
}
