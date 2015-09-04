package es.mresti.xemio.app.interactor;

import android.content.Context;
import com.firebase.client.Firebase;
import es.mresti.xemio.R;
import es.mresti.xemio.app.presenter.ListTreatmentsPresenter;

public class ListTreatmentsInteractorImpl implements ListTreatmentsInteractor {
  private ListTreatmentsPresenter mPresenter;
  private Context mContext;
  private Firebase mFirebaseRef;

  @Override public void setPresenter(ListTreatmentsPresenter presenter) {
    mPresenter = presenter;
  }

  @Override public void initialize(Context c) {
    mContext = c;
    mFirebaseRef = new Firebase(mContext.getResources().getString(R.string.firebase_url));
  }

  @Override public Firebase getTreatmentListRef() {
    return mFirebaseRef.child("treatments");
  }
}
