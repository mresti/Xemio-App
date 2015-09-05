package es.mresti.xemio.app.interactor;

import android.content.Context;
import com.firebase.client.AuthData;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import es.mresti.xemio.R;
import es.mresti.xemio.app.model.User;
import es.mresti.xemio.app.presenter.ListEffectsPresenter;

public class ListEffectsInteractorImpl implements ListEffectsInteractor {
  private ListEffectsPresenter mPresenter;
  private Context mContext;
  private Firebase mFirebaseRef;
  private AuthData mAuthData;

  @Override public void setPresenter(ListEffectsPresenter presenter) {
    mPresenter = presenter;
  }

  @Override public Firebase getEffectListRef() {

    final Firebase[] effectUser1 = { mFirebaseRef.getRef() };
    Firebase user1 = mFirebaseRef.child("users").child(mAuthData.getUid());
    user1.addListenerForSingleValueEvent(new ValueEventListener() {
      @Override public void onDataChange(DataSnapshot dataSnapshot) {
        User user = dataSnapshot.getValue(User.class);
        effectUser1[0] = mFirebaseRef.child("effects").child(user.getIdChemo());
      }

      @Override public void onCancelled(FirebaseError firebaseError) {

      }
    });

    return effectUser1[0];
  }

  @Override public void initialize(Context c) {
    mContext = c;
    mFirebaseRef = new Firebase(mContext.getResources().getString(R.string.firebase_url));
    mAuthData = mFirebaseRef.getAuth();
  }
}
