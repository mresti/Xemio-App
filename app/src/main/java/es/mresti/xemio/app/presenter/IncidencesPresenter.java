package es.mresti.xemio.app.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import es.mresti.xemio.R;
import es.mresti.xemio.app.contract.IncidencesContract;

public class IncidencesPresenter implements IncidencesContract.UserActionsListener {

  private Firebase mFirebaseRef;
  private Context mContext;
  private AuthData mAuthData;
  private final IncidencesContract.View mIncidenceView;

  public IncidencesPresenter(@NonNull IncidencesContract.View incidencesView) {
    mIncidenceView = incidencesView;
  }

  @Override public void initializeActions(Context c) {
    mContext = c;
    mFirebaseRef = new Firebase(mContext.getResources().getString(R.string.firebase_url));
    mAuthData = mFirebaseRef.getAuth();
  }

  @Override public Firebase getIncidenceListRef() {
    return mFirebaseRef.child("incidences").child(mAuthData.getUid());
  }
}


