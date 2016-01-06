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
import es.mresti.xemio.app.contract.IncidenceListContract;
import es.mresti.xemio.app.model.Incidence;
import es.mresti.xemio.app.presenter.IncidenceListPresenter;
import es.mresti.xemio.app.view.adapter.IncidenceListAdapter;

public class IncidenceListFragment extends BaseFragment implements IncidenceListContract.View {

  public IncidenceListFragment() {
        /* Required empty public constructor */
  }

  /**
   * Interface for listening incidence list events.
   */
  public interface IncidenceListener {
    void onIncidenceClicked(final String key);
  }

  public void setIncidenceListener(IncidenceListener listener) {
    this.listener = listener;
  }

  private IncidenceListContract.UserActionsListener mActionsListener;
  private Firebase mIncidencesDatasRef;
  private IncidenceListAdapter mIncidenceListAdapter;
  private IncidenceListener listener;

  // UI items
  @Bind(R.id.list_view_1_item) ListView mIncidenceList;

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_1_list, container, false);
    ButterKnife.bind(this, view);

    mActionsListener = new IncidenceListPresenter(this);
    mIncidencesDatasRef = mActionsListener.getIncidenceListRef();

    return view;
  }

  @OnItemClick(R.id.list_view_1_item) void onItemSelected(int position) {
    Incidence selectList = mIncidenceListAdapter.getItem(position);
    if (selectList != null) {
      listener.onIncidenceClicked(mIncidenceListAdapter.getRef(position).getKey());
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

    Query orderedTreatmentListsRef = mIncidencesDatasRef;

    mIncidenceListAdapter =
        new IncidenceListAdapter(getActivity(), Incidence.class, R.layout.list_1_item,
            orderedTreatmentListsRef);
    mIncidenceList.setAdapter(mIncidenceListAdapter);
  }

  @Override public void onPause() {
    super.onPause();
    mIncidenceListAdapter.cleanup();
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    ButterKnife.unbind(this);
  }
}
