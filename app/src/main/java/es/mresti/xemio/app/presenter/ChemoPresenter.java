package es.mresti.xemio.app.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import es.mresti.xemio.R;
import es.mresti.xemio.app.contract.ChemoContract;
import java.util.HashMap;
import java.util.Map;

import static android.support.test.espresso.core.deps.guava.base.Preconditions.checkNotNull;

public class ChemoPresenter implements ChemoContract.UserActionsListener {

  private Firebase mFirebaseRef;
  private Context mContext;
  private final ChemoContract.View mChemoView;

  public ChemoPresenter(@NonNull ChemoContract.View chemoView) {
    mChemoView = checkNotNull(chemoView, "chemoView cannot be null!");
  }

  @Override public void initializeActions(Context c) {
    mContext = c;
    mFirebaseRef = new Firebase(mContext.getResources().getString(R.string.firebase_url));
  }

  @Override public Firebase getChemoRef() {
    return mFirebaseRef.child("chemo");
  }

  @Override public void setChemo(String key) {
    AuthData authData = mFirebaseRef.getAuth();
    Firebase userRef = mFirebaseRef.child("users").child(authData.getUid());

    Map<String, Object> person = new HashMap<String, Object>();
    person.put("idChemo", key);
    userRef.updateChildren(person);

    this.onSuccess();
  }

  private void onSuccess() {
    mChemoView.openDashboard();
  }
}