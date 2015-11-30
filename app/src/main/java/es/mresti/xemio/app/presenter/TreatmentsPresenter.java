package es.mresti.xemio.app.presenter;

import android.content.Context;
import android.support.annotation.NonNull;
import com.firebase.client.Firebase;
import es.mresti.xemio.R;
import es.mresti.xemio.app.contract.TreatmentsContract;

public class TreatmentsPresenter implements TreatmentsContract.UserActionsListener {

  private Firebase mFirebaseRef;
  private Context mContext;
  private final TreatmentsContract.View mTreatmentView;

  public TreatmentsPresenter(@NonNull TreatmentsContract.View treatmentsView) {
    mTreatmentView = treatmentsView;
  }

  @Override public void initializeActions(Context c) {
    mContext = c;
    mFirebaseRef = new Firebase(mContext.getResources().getString(R.string.firebase_url));
  }

  @Override public Firebase getTreatmentListRef() {
    return mFirebaseRef.child("treatments");
  }
}
