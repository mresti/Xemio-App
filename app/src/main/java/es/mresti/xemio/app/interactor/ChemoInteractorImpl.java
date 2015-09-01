package es.mresti.xemio.app.interactor;

import android.content.Context;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import es.mresti.xemio.R;
import es.mresti.xemio.app.presenter.ChemoPresenter;
import java.util.HashMap;
import java.util.Map;

public class ChemoInteractorImpl implements ChemoInteractor {
  private ChemoPresenter mPresenter;
  private Context mContext;
  private Firebase mFirebaseRef;

  @Override public void setPresenter(ChemoPresenter presenter) {
    mPresenter = presenter;
  }

  @Override public Firebase getChemoRef() {
    return mFirebaseRef.child("chemo");
  }

  @Override public void initialize(Context c) {
    mContext = c;
    mFirebaseRef = new Firebase(mContext.getResources().getString(R.string.firebase_url));
  }

  @Override public void setChemo(String key) {
    AuthData authData = mFirebaseRef.getAuth();
    Firebase userRef = mFirebaseRef.child("users").child(authData.getUid());

    Map<String, Object> person = new HashMap<String, Object>();
    person.put("idChemo", key);
    userRef.updateChildren(person);

    mPresenter.onSuccess();
  }
}
