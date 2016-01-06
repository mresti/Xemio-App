package es.mresti.xemio.app.view.fragment;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import es.mresti.xemio.R;
import es.mresti.xemio.app.contract.IncidenceDetailContract;
import es.mresti.xemio.app.model.Incidence;
import es.mresti.xemio.app.presenter.IncidenceDetailPresenter;

public class IncidenceDetailFragment extends BaseFragment implements IncidenceDetailContract.View {

  public IncidenceDetailFragment() {
        /* Required empty public constructor */
  }

  /**
   * Interface for listening incidence list events.
   */
  public interface IncidenceListener {
    void onDeleteClicked();
  }

  public void setIncidenceListener(IncidenceListener listener) {
    this.listener = listener;
  }

  private IncidenceDetailContract.UserActionsListener mActionsListener;
  private Firebase mIncidenceDataRef;
  private String mIncidenceID;
  private Incidence mIncidence;
  private IncidenceListener listener;

  // UI items
  @Bind(R.id.tvSubject) TextView mTextViewSub;
  @Bind(R.id.tvDesc) TextView mTextViewDesc;
  @Bind(R.id.fab_del) FloatingActionButton mFABDel;
  @Bind(R.id.content_detail) ScrollView mScrollView;

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_incidence_detail, container, false);
    ButterKnife.bind(this, view);
    mActionsListener = new IncidenceDetailPresenter(this);
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

    if (mIncidenceDataRef != null) {
      updatedData();
    }
  }

  @OnClick(R.id.fab_del) void deleteItem() {
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
    builder.setTitle(getString(R.string.dialog_title_detail_incidence));
    builder.setMessage(getString(R.string.dialog_message_detail_incidence));

    String positiveText = getString(android.R.string.ok);
    builder.setPositiveButton(positiveText, new DialogInterface.OnClickListener() {
      @Override public void onClick(DialogInterface dialog, int which) {
        // positive button logic
        removeItemChild();
      }
    });

    String negativeText = getString(android.R.string.cancel);
    builder.setNegativeButton(negativeText, new DialogInterface.OnClickListener() {
      @Override public void onClick(DialogInterface dialog, int which) {
        // negative button logic
      }
    });

    AlertDialog dialog = builder.create();
    // display dialog
    dialog.show();
  }

  private void removeItemChild() {
    mActionsListener.removeIncidence(mIncidenceID);
    listener.onDeleteClicked();
  }

  public void updatedData() {
    mIncidenceDataRef.addListenerForSingleValueEvent(new ValueEventListener() {
      @Override public void onDataChange(DataSnapshot snapshot) {
        mIncidence = snapshot.getValue(Incidence.class);
        mTextViewSub.setText(mIncidence.getSubject());
        mTextViewDesc.setText(mIncidence.getDescription());
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
    mIncidenceDataRef = mActionsListener.getIncidenceRef(key);
    mIncidenceID = key;
    updatedData();
  }
}