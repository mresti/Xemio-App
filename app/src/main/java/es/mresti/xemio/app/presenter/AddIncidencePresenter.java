package es.mresti.xemio.app.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import es.mresti.xemio.R;
import es.mresti.xemio.app.contract.AddIncidenceContract;
import es.mresti.xemio.app.model.Incidence;

public class AddIncidencePresenter implements AddIncidenceContract.UserActionsListener {

  private Firebase mFirebaseRef;
  private Context mContext;
  private final AddIncidenceContract.View mAddIncidenceView;

  public AddIncidencePresenter(@NonNull AddIncidenceContract.View addIncidenceView) {
    mAddIncidenceView = addIncidenceView;
  }

  @Override public void initializeActions(Context c) {
    mContext = c;
    mFirebaseRef = new Firebase(mContext.getResources().getString(R.string.firebase_url));
  }

  @Override public void addIncidence(String subject, String description) {
    boolean error = false;
    if (TextUtils.isEmpty(subject)) {
      this.onSubjectError();
      error = true;
    }
    if (TextUtils.isEmpty(description)) {
      this.onDescriptionError();
      error = true;
    }

    if (!error) {
      AuthData authData = mFirebaseRef.getAuth();
      Firebase inciUserRef = mFirebaseRef.child("incidences").child(authData.getUid());

      // item 1
      Firebase item = inciUserRef.push();

      Incidence ala = new Incidence(subject, description);
      item.setValue(ala);

      this.onSuccess();
    }
  }

  private void onSubjectError() {
    mAddIncidenceView.setSubjectError();
  }

  private void onDescriptionError() {
    mAddIncidenceView.setDescriptionError();
  }

  private void onSuccess() {
    mAddIncidenceView.showNotificationCreated();
  }
}
