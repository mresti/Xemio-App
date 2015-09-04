package es.mresti.xemio.app.presenter;

import android.content.Context;
import com.firebase.client.Firebase;
import es.mresti.xemio.app.interactor.ListTreatmentsInteractor;
import es.mresti.xemio.app.view.ListTreatmentView;

public class ListTreatmentsPresenter implements Presenter {
  private ListTreatmentView mListTreatmentView;
  private ListTreatmentsInteractor mListTreatmentsInteractor;
  private Context mContext;

  public static ListTreatmentsPresenter newInstance(ListTreatmentView view,
      ListTreatmentsInteractor interactor) {
    ListTreatmentsPresenter presenter = new ListTreatmentsPresenter(view, interactor);
    presenter.initialize();
    return presenter;
  }

  private ListTreatmentsPresenter(ListTreatmentView view, ListTreatmentsInteractor interactor) {
    mListTreatmentView = view;
    mListTreatmentsInteractor = interactor;
  }

  private void initialize() {
    mListTreatmentsInteractor.setPresenter(this);
  }

  @Override public void resume() {
  }

  @Override public void pause() {
  }

  public void initializeContext(Context c) {
    mContext = c;
    mListTreatmentsInteractor.initialize(mContext);
  }

  public Firebase getRef() {
    return mListTreatmentsInteractor.getTreatmentListRef();
  }
}




