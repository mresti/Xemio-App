package es.mresti.xemio.app.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import com.firebase.client.Firebase;
import es.mresti.xemio.R;
import es.mresti.xemio.app.contract.EffectDetailContract;

public class EffectDetailPresenter implements EffectDetailContract.UserActionsListener {

  private Firebase mFirebaseRef;
  private Context mContext;
  private final EffectDetailContract.View mEffectDetailView;

  public EffectDetailPresenter(@NonNull EffectDetailContract.View effectDetailView) {
    mEffectDetailView = effectDetailView;
  }

  @Override public void initializeActions(Context c) {
    mContext = c;
    mFirebaseRef = new Firebase(mContext.getResources().getString(R.string.firebase_url));
  }

  @Override public Firebase getEffectRef(String key) {
    return mFirebaseRef.child("effects").child("-Jy4JKD7Lz7PoKKIEyvI").child(key);
  }
}



