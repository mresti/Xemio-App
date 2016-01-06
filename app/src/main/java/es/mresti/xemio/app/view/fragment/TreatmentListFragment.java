package es.mresti.xemio.app.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemClick;
import com.firebase.client.Firebase;
import com.firebase.client.Query;
import es.mresti.xemio.R;
import es.mresti.xemio.app.contract.TreatmentListContract;
import es.mresti.xemio.app.model.Treatment;
import es.mresti.xemio.app.presenter.TreatmentListPresenter;
import es.mresti.xemio.app.view.adapter.TreatmentListAdapter;

public class TreatmentListFragment extends BaseFragment implements TreatmentListContract.View {

  public TreatmentListFragment() {
        /* Required empty public constructor */
  }

  /**
   * Interface for listening treatment list events.
   */
  public interface TreatmentListener {
    void onTreatmentClicked(final String key);
  }

  public void setTreatmentListener(TreatmentListener listener) {
    this.listener = listener;
  }

  private TreatmentListContract.UserActionsListener mActionsListener;
  private Firebase mTreatmentsDatasRef;
  private TreatmentListAdapter mTreatmentsListAdapter;
  private TreatmentListener listener;

  // UI items
  @Bind(R.id.list_view_1_item) ListView mTreatmentList;

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_1_list, container, false);
    ButterKnife.bind(this, view);

    mActionsListener = new TreatmentListPresenter(this);
    mTreatmentsDatasRef = mActionsListener.getTreatmentListRef();

    return view;
  }

  @OnItemClick(R.id.list_view_1_item) void onItemSelected(int position) {
    Treatment selectList = mTreatmentsListAdapter.getItem(position);
    if (selectList != null) {
      listener.onTreatmentClicked(mTreatmentsListAdapter.getRef(position).getKey());
    }
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

    Query orderedTreatmentListsRef = mTreatmentsDatasRef;

    mTreatmentsListAdapter =
        new TreatmentListAdapter(getActivity(), Treatment.class, R.layout.list_1_item,
            orderedTreatmentListsRef);
    mTreatmentList.setAdapter(mTreatmentsListAdapter);
  }

  @Override public void onPause() {
    super.onPause();
    mTreatmentsListAdapter.cleanup();
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    ButterKnife.unbind(this);
  }
}
