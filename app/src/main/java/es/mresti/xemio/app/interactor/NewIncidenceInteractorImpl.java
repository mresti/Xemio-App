package es.mresti.xemio.app.interactor;

import android.content.Context;
import android.text.TextUtils;
import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import es.mresti.xemio.R;
import es.mresti.xemio.app.model.Incidence;
import es.mresti.xemio.app.presenter.NewIncidencePresenter;

public class NewIncidenceInteractorImpl implements NewIncidenceInteractor {
  private NewIncidencePresenter mPresenter;
  private Firebase mFirebaseRef;
  private Context mContext;

  @Override public void setPresenter(NewIncidencePresenter presenter) {
    mPresenter = presenter;
  }

  @Override public void initialize(Context c) {
    mContext = c;
    mFirebaseRef = new Firebase(mContext.getResources().getString(R.string.firebase_url));
  }

  @Override public void register(String subject, String description) {
    boolean error = false;
    if (TextUtils.isEmpty(subject)) {
      mPresenter.onSubjectError();
      error = true;
    }
    if (TextUtils.isEmpty(description)) {
      mPresenter.onDescriptionError();
      error = true;
    }

    if (!error) {
      AuthData authData = mFirebaseRef.getAuth();
      Firebase inciUserRef = mFirebaseRef.child("incidences").child(authData.getUid());

      // item 1
      Firebase item = inciUserRef.push();

      Incidence ala = new Incidence(subject, description);
      item.setValue(ala);

      mPresenter.onSuccess();
    }
  }
}
