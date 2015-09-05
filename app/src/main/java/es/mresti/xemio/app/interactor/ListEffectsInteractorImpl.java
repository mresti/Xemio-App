package es.mresti.xemio.app.interactor;

import android.content.Context;
import com.firebase.client.Firebase;
import es.mresti.xemio.R;
import es.mresti.xemio.app.presenter.ListEffectsPresenter;

public class ListEffectsInteractorImpl implements ListEffectsInteractor {
  private ListEffectsPresenter mPresenter;
  private Context mContext;
  private Firebase mFirebaseRef;

  @Override public void setPresenter(ListEffectsPresenter presenter) {
    mPresenter = presenter;
  }

  @Override public Firebase getEffectListRef() {
    // TODO: retrieve idchemo by user
    return mFirebaseRef.child("effects").child("-Jy4JKD7Lz7PoKKIEyvI");
  }

  @Override public void initialize(Context c) {
    mContext = c;
    mFirebaseRef = new Firebase(mContext.getResources().getString(R.string.firebase_url));
  }
}
