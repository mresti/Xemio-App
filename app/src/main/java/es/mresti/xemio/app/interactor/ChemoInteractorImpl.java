package es.mresti.xemio.app.interactor;

import android.content.Context;
import com.firebase.client.Firebase;
import es.mresti.xemio.R;
import es.mresti.xemio.app.presenter.ChemoPresenter;

public class ChemoInteractorImpl implements ChemoInteractor {
  private ChemoPresenter presenter;

  @Override public void setPresenter(ChemoPresenter presenter) {
    this.presenter = presenter;
  }

  @Override public void setChemo(Context c) {
    Context mContext = c;
    Firebase mFirebaseRef = new Firebase(mContext.getResources().getString(R.string.firebase_url));

    presenter.onSuccess();
  }
}
