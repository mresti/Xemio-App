package es.mresti.xemio.app.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import com.firebase.client.Firebase;
import es.mresti.xemio.R;
import es.mresti.xemio.app.contract.EffectsContract;

import static android.support.test.espresso.core.deps.guava.base.Preconditions.checkNotNull;

public class EffectsPresenter implements EffectsContract.UserActionsListener {

  private Firebase mFirebaseRef;
  private Context mContext;
  private final EffectsContract.View mEffectView;

  public EffectsPresenter(@NonNull EffectsContract.View effectsView) {
    mEffectView = checkNotNull(effectsView, "effectsView cannot be null!");
  }

  @Override public void initializeActions(Context c) {
    mContext = c;
    mFirebaseRef = new Firebase(mContext.getResources().getString(R.string.firebase_url));
  }

  @Override public Firebase getEffectListRef() {
    // TODO: retrieve idchemo by user
    return mFirebaseRef.child("effects").child("-Jy4JKD7Lz7PoKKIEyvI");
  }
}
