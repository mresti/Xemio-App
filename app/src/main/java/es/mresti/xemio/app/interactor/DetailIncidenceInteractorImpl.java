package es.mresti.xemio.app.interactor;

import android.content.Context;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import es.mresti.xemio.R;
import es.mresti.xemio.app.presenter.DetailIncidencePresenter;

public class DetailIncidenceInteractorImpl implements DetailIncidenceInteractor {
  private DetailIncidencePresenter mPresenter;
  private Context mContext;
  private Firebase mFirebaseRef;
  private AuthData mAuthData;

  @Override public void setPresenter(DetailIncidencePresenter presenter) {
    mPresenter = presenter;
  }

  @Override public void initialize(Context c) {
    mContext = c;
    mFirebaseRef = new Firebase(mContext.getResources().getString(R.string.firebase_url));
    mAuthData = mFirebaseRef.getAuth();
  }

  @Override public Firebase getIncidenceRef(String key) {
    return mFirebaseRef.child("incidences").child(mAuthData.getUid()).child(key);
  }

  @Override public void removeItem(String key) {
    mFirebaseRef.child("incidences").child(mAuthData.getUid()).child(key).removeValue();
  }
}
