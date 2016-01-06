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
import es.mresti.xemio.app.contract.HistoricalDetailContract;
import es.mresti.xemio.app.model.Advice;
import es.mresti.xemio.app.presenter.HistoricalDetailPresenter;

public class HistoricalDetailFragment extends BaseFragment
    implements HistoricalDetailContract.View {

  public HistoricalDetailFragment() {
        /* Required empty public constructor */
  }

  private HistoricalDetailContract.UserActionsListener mActionsListener;
  private Firebase mHistoricalDataRef;
  private String mAdviceID;
  private String MAdviceName;
  private Advice mAdvice;

  // UI items
  @Bind(R.id.tvAdvice) TextView mTextViewAdvice;
  @Bind(R.id.tvCategory) TextView mTextViewCategory;
  @Bind(R.id.tvEffect) TextView mTextViewEffect;
  @Bind(R.id.content_detail) ScrollView mScrollView;

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_advice_detail, container, false);
    ButterKnife.bind(this, view);
    mActionsListener = new HistoricalDetailPresenter(this);
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

    if (mHistoricalDataRef != null) {
      updatedData();
    }
  }

  public void updatedData() {
    mHistoricalDataRef.addListenerForSingleValueEvent(new ValueEventListener() {
      @Override public void onDataChange(DataSnapshot snapshot) {
        mAdvice = snapshot.getValue(Advice.class);
        mTextViewEffect.setText(mAdvice.getEffect());
        mTextViewCategory.setText(mAdvice.getCategory());
        mTextViewAdvice.setText(mAdvice.getAdvice());
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
    mHistoricalDataRef = mActionsListener.getHistoricalRef(key);
    mAdviceID = key;
    updatedData();
  }
}

