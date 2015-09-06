package es.mresti.xemio.app.interactor;

import android.content.Context;
import android.text.TextUtils;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import es.mresti.xemio.R;
import es.mresti.xemio.app.presenter.ExtraPresenter;
import java.util.HashMap;
import java.util.Map;

public class ExtraInteractorImpl implements ExtraInteractor {
  private ExtraPresenter mPresenter;
  private Context mContext;
  private Firebase mFirebaseRef;

  @Override public void setPresenter(ExtraPresenter presenter) {
    mPresenter = presenter;
  }

  @Override public void initialize(Context c) {
    mContext = c;
    mFirebaseRef = new Firebase(mContext.getResources().getString(R.string.firebase_url));
  }

  @Override public void saveExtraData(final String username, final String age) {
    boolean error = false;
    if (TextUtils.isEmpty(username)) {
      mPresenter.onUsernameError();
      error = true;
    }
    if (TextUtils.isEmpty(age)) {
      mPresenter.onAgeError();
      error = true;
    }
    if (!error) {
      AuthData authData = mFirebaseRef.getAuth();
      Firebase userRef = mFirebaseRef.child("users").child(authData.getUid());

      Map<String, Object> person = new HashMap<String, Object>();
      person.put("fullName", username);
      person.put("age", age);
      userRef.updateChildren(person);

      mPresenter.onSuccess();
    }
  }
}
