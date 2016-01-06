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
import es.mresti.xemio.app.contract.HistoricalListContract;
import es.mresti.xemio.app.model.Advice;
import es.mresti.xemio.app.presenter.HistoricalListPresenter;
import es.mresti.xemio.app.view.adapter.HistoricalListAdapter;

public class HistoricalListFragment extends BaseFragment implements HistoricalListContract.View {

  public HistoricalListFragment() {
        /* Required empty public constructor */
  }

  /**
   * Interface for listening treatment list events.
   */
  public interface HistoricalListener {
    void onHistoricalClicked(final String key);
  }

  public void setHistoricalListener(HistoricalListener listener) {
    this.listener = listener;
  }

  private HistoricalListContract.UserActionsListener mActionsListener;
  private Firebase mHistoricalDatasRef;
  private HistoricalListAdapter mHistoricalListAdapter;
  private HistoricalListener listener;

  // UI items
  @Bind(R.id.list_view_1_item) ListView mHistoricalList;

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_1_list, container, false);
    ButterKnife.bind(this, view);

    mActionsListener = new HistoricalListPresenter(this);
    mHistoricalDatasRef = mActionsListener.getHistoricalListRef();

    return view;
  }

  @OnItemClick(R.id.list_view_1_item) void onItemSelected(int position) {
    Advice selectList = mHistoricalListAdapter.getItem(position);
    if (selectList != null) {
      listener.onHistoricalClicked(mHistoricalListAdapter.getRef(position).getKey());
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

    Query orderedHistoricalListsRef = mHistoricalDatasRef;

    mHistoricalListAdapter =
        new HistoricalListAdapter(getActivity(), Advice.class, R.layout.list_1_item,
            orderedHistoricalListsRef);
    mHistoricalList.setAdapter(mHistoricalListAdapter);
  }

  @Override public void onPause() {
    super.onPause();
    mHistoricalListAdapter.cleanup();
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    ButterKnife.unbind(this);
  }
}

