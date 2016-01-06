package es.mresti.xemio.app.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import es.mresti.xemio.R;
import es.mresti.xemio.app.contract.TreatmentDetailContract;
import es.mresti.xemio.app.model.Treatment;
import es.mresti.xemio.app.presenter.TreatmentDetailPresenter;

public class TreatmentDetailFragment extends BaseFragment implements TreatmentDetailContract.View {

  public TreatmentDetailFragment() {
        /* Required empty public constructor */
  }

  private TreatmentDetailContract.UserActionsListener mActionsListener;
  private Firebase mTreatmentDataRef;
  private String mTreatmentID;
  private Treatment mTreatment;

  // UI items
  @Bind(R.id.tvTitle) TextView mTextViewTitle;
  @Bind(R.id.tvDesc) TextView mTextViewDesc;
  @Bind(R.id.tvTreat) TextView mTextViewTreat;
  @Bind(R.id.content_detail) ScrollView mScrollView;

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_treatment_detail, container, false);
    ButterKnife.bind(this, view);
    mActionsListener = new TreatmentDetailPresenter(this);
    return view;
  }

  @Override public Context getContext() {
    return getActivity().getApplicationContext();
  }

  @Override public void resume() {
    super.onResume();
  }

  @Override public void pause() {
    super.onPause();
  }

  @Override public void onResume() {
    super.onResume();

    if (mTreatmentDataRef != null) {
      updatedData();
    }
  }

  public void updatedData() {
    mTreatmentDataRef.addListenerForSingleValueEvent(new ValueEventListener() {
      @Override public void onDataChange(DataSnapshot snapshot) {
        mTreatment = snapshot.getValue(Treatment.class);
        mTextViewTitle.setText(mTreatment.getTitle());
        mTextViewDesc.setText(mTreatment.getDescription());
        mTextViewTreat.setText(mTreatment.getTreatments());
        mScrollView.setVisibility(View.VISIBLE);
      }

      @Override public void onCancelled(FirebaseError firebaseError) {
      }
    });
  }

  @Override public void onPause() {
    super.onPause();
  }

  public void showDetail(String key) {
    mTreatmentDataRef = mActionsListener.getTreatmentRef(key);
    mTreatmentID = key;
    updatedData();
  }
}
