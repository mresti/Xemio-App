package es.mresti.xemio.app.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import com.firebase.client.Firebase;
import es.mresti.xemio.R;
import es.mresti.xemio.app.contract.RegisterContract;

import static android.support.test.espresso.core.deps.guava.base.Preconditions.checkNotNull;

public class RegisterPresenter implements RegisterContract.UserActionsListener {

  private Firebase mFirebaseRef;
  private Context mContext;
  private final RegisterContract.View mRegisterView;

  public RegisterPresenter(@NonNull RegisterContract.View registerView) {
    mRegisterView = checkNotNull(registerView, "notesView cannot be null!");
  }

  @Override public void initializeActions(Context c) {
    mContext = c;
    mFirebaseRef = new Firebase(mContext.getResources().getString(R.string.firebase_url));
  }
}
