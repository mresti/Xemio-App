package es.mresti.xemio.app.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import com.firebase.client.Firebase;
import es.mresti.xemio.R;
import es.mresti.xemio.app.contract.TreatmentDetailContract;

import static android.support.test.espresso.core.deps.guava.base.Preconditions.checkNotNull;

public class TreatmentDetailPresenter implements TreatmentDetailContract.UserActionsListener {

  private Firebase mFirebaseRef;
  private Context mContext;
  private final TreatmentDetailContract.View mTreatmentDetailView;

  public TreatmentDetailPresenter(@NonNull TreatmentDetailContract.View treatmentDetailView) {
    mTreatmentDetailView = checkNotNull(treatmentDetailView, "treatmentDetailView cannot be null!");
  }

  @Override public void initializeActions(Context c) {
    mContext = c;
    mFirebaseRef = new Firebase(mContext.getResources().getString(R.string.firebase_url));
  }

  @Override public Firebase getTreatmentRef(String key) {
    return mFirebaseRef.child("treatments").child(key);
  }
}
