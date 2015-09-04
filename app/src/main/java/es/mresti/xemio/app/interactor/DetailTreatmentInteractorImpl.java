package es.mresti.xemio.app.interactor;

import android.content.Context;
import com.firebase.client.Firebase;
import es.mresti.xemio.R;
import es.mresti.xemio.app.presenter.DetailTreatmentPresenter;

public class DetailTreatmentInteractorImpl implements DetailTreatmentInteractor {
  private DetailTreatmentPresenter mPresenter;
  private Context mContext;
  private Firebase mFirebaseRef;

  @Override public void setPresenter(DetailTreatmentPresenter presenter) {
    mPresenter = presenter;
  }

  @Override public void initialize(Context c) {
    mContext = c;
    mFirebaseRef = new Firebase(mContext.getResources().getString(R.string.firebase_url));
  }

  @Override public Firebase getTreatmentRef(String key) {
    return mFirebaseRef.child("treatments").child(key);
  }
}
