package es.mresti.xemio.app.interactor;

import android.content.Context;
import com.firebase.client.Firebase;
import es.mresti.xemio.R;
import es.mresti.xemio.app.presenter.DetailEffectPresenter;

public class DetailEffectInteractorImpl implements DetailEffectInteractor {
  private DetailEffectPresenter mPresenter;
  private Context mContext;
  private Firebase mFirebaseRef;

  @Override public void setPresenter(DetailEffectPresenter presenter) {
    mPresenter = presenter;
  }

  @Override public void initialize(Context c) {
    mContext = c;
    mFirebaseRef = new Firebase(mContext.getResources().getString(R.string.firebase_url));
  }

  @Override public Firebase getEffectRef(String key) {
    return mFirebaseRef.child("effects").child("-Jy4JKD7Lz7PoKKIEyvI").child(key);
  }
}