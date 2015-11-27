package es.mresti.xemio.app.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import es.mresti.xemio.R;
import es.mresti.xemio.app.contract.IncidenceDetailContract;

import static android.support.test.espresso.core.deps.guava.base.Preconditions.checkNotNull;

public class IncidenceDetailPresenter implements IncidenceDetailContract.UserActionsListener {

  private Firebase mFirebaseRef;
  private Context mContext;
  private AuthData mAuthData;
  private final IncidenceDetailContract.View mIncidenceDetailView;

  public IncidenceDetailPresenter(@NonNull IncidenceDetailContract.View incidenceDetailView) {
    mIncidenceDetailView = checkNotNull(incidenceDetailView, "incidenceDetailView cannot be null!");
  }

  @Override public void initializeActions(Context c) {
    mContext = c;
    mFirebaseRef = new Firebase(mContext.getResources().getString(R.string.firebase_url));
    mAuthData = mFirebaseRef.getAuth();
  }

  @Override public Firebase getIncidenceRef(String key) {
    return mFirebaseRef.child("incidences").child(mAuthData.getUid()).child(key);
  }

  @Override public void removeIncidence(String key) {
    mFirebaseRef.child("incidences").child(mAuthData.getUid()).child(key).removeValue();
  }
}
