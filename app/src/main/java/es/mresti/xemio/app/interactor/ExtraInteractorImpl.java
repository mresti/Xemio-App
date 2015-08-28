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
  private ExtraPresenter presenter;

  @Override public void setPresenter(ExtraPresenter presenter) {
    this.presenter = presenter;
  }

  @Override public void saveExtraData(Context c, final String username, final String age) {
    Context mContext = c;
    Firebase mFirebaseRef = new Firebase(mContext.getResources().getString(R.string.firebase_url));
    boolean error = false;
    if (TextUtils.isEmpty(username)) {
      presenter.onUsernameError();
      error = true;
    }
    if (TextUtils.isEmpty(age)) {
      presenter.onAgeError();
      error = true;
    }
    if (!error) {
      AuthData authData = mFirebaseRef.getAuth();
      Firebase userRef = mFirebaseRef.child("users").child(authData.getUid());

      Map<String, Object> person = new HashMap<String, Object>();
      person.put("fullName", username);
      person.put("age", age);
      userRef.updateChildren(person);

      presenter.onSuccess();
    }
  }
}
