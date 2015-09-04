package es.mresti.xemio.app.presenter;

import android.content.Context;
import com.firebase.client.Firebase;
import es.mresti.xemio.app.interactor.DetailTreatmentInteractor;
import es.mresti.xemio.app.view.DetailTreatmentView;

public class DetailTreatmentPresenter implements Presenter {
  private DetailTreatmentView mDetailTreatmentView;
  private DetailTreatmentInteractor mDetailTreatmentInteractor;
  private Context mContext;

  public static DetailTreatmentPresenter newInstance(DetailTreatmentView view,
      DetailTreatmentInteractor interactor) {
    DetailTreatmentPresenter presenter = new DetailTreatmentPresenter(view, interactor);
    presenter.initialize();
    return presenter;
  }

  private DetailTreatmentPresenter(DetailTreatmentView view, DetailTreatmentInteractor interactor) {
    mDetailTreatmentView = view;
    mDetailTreatmentInteractor = interactor;
  }

  private void initialize() {
    mDetailTreatmentInteractor.setPresenter(this);
  }

  @Override public void resume() {

  }

  @Override public void pause() {

  }

  public void initializeContext(Context c) {
    mContext = c;
    mDetailTreatmentInteractor.initialize(mContext);
  }

  public Firebase getRef(String key) {
    return mDetailTreatmentInteractor.getTreatmentRef(key);
  }
}
