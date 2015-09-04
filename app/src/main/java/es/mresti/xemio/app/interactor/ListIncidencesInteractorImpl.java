package es.mresti.xemio.app.interactor;

import android.content.Context;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import es.mresti.xemio.R;
import es.mresti.xemio.app.presenter.ListIncidencesPresenter;

public class ListIncidencesInteractorImpl implements ListIncidencesInteractor {
  private ListIncidencesPresenter mPresenter;
  private Context mContext;
  private Firebase mFirebaseRef;
  private AuthData mAuthData;

  @Override public void setPresenter(ListIncidencesPresenter presenter) {
    mPresenter = presenter;
  }

  @Override public Firebase getIncidenceListRef() {
    return mFirebaseRef.child("incidences").child(mAuthData.getUid());
  }

  @Override public void initialize(Context c) {
    mContext = c;
    mFirebaseRef = new Firebase(mContext.getResources().getString(R.string.firebase_url));
    mAuthData = mFirebaseRef.getAuth();
  }
}
