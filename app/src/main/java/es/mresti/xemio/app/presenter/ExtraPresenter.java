package es.mresti.xemio.app.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import es.mresti.xemio.R;
import es.mresti.xemio.app.contract.ExtraContract;
import java.util.HashMap;
import java.util.Map;

import static android.support.test.espresso.core.deps.guava.base.Preconditions.checkNotNull;

public class ExtraPresenter implements ExtraContract.UserActionsListener {

  private Firebase mFirebaseRef;
  private Context mContext;
  private final ExtraContract.View mExtraView;

  public ExtraPresenter(@NonNull ExtraContract.View extraView) {
    mExtraView = checkNotNull(extraView, "extraView cannot be null!");
  }

  @Override public void initializeActions(Context c) {
    mContext = c;
    mFirebaseRef = new Firebase(mContext.getResources().getString(R.string.firebase_url));
  }

  @Override public void setRegister(String username, String age) {
    mExtraView.showProgress();
    this.saveExtraData(username, age);
  }

  private void saveExtraData(final String username, final String age) {
    boolean error = false;
    if (TextUtils.isEmpty(username)) {
      this.onUsernameError();
      error = true;
    }
    if (TextUtils.isEmpty(age)) {
      this.onAgeError();
      error = true;
    }
    if (!error) {
      AuthData authData = mFirebaseRef.getAuth();
      Firebase userRef = mFirebaseRef.child("users").child(authData.getUid());

      Map<String, Object> person = new HashMap<String, Object>();
      person.put("fullName", username);
      person.put("age", age);
      userRef.updateChildren(person);

      this.onSuccess();
    }
  }

  public void onUsernameError() {
    mExtraView.setUsernameError();
    mExtraView.hideProgress();
  }

  public void onAgeError() {
    mExtraView.setAgeError();
    mExtraView.hideProgress();
  }

  public void onSuccess() {
    mExtraView.openChemo();
  }
}
