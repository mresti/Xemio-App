package es.mresti.xemio.app.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
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
import es.mresti.xemio.app.contract.AdviceListContract;
import es.mresti.xemio.app.model.Advice;
import es.mresti.xemio.app.presenter.AdviceListPresenter;
import es.mresti.xemio.app.view.adapter.AdviceListAdapter;

public class AdviceListFragment extends BaseFragment implements AdviceListContract.View {

  public AdviceListFragment() {
        /* Required empty public constructor */
  }

  /**
   * Interface for listening treatment list events.
   */
  public interface AdviceListener {
    void onAdviceClicked(final String key, final String name);
  }

  public void setAdviceListener(AdviceListener listener) {
    this.listener = listener;
  }

  private AdviceListContract.UserActionsListener mActionsListener;
  private Firebase mAdvicesDatasRef;
  private AdviceListAdapter mAdvicesListAdapter;
  private AdviceListener listener;

  // UI items
  @Bind(R.id.list_view_1_item) ListView mAdviceList;

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_1_list, container, false);
    ButterKnife.bind(this, view);

    mActionsListener = new AdviceListPresenter(this);
    mAdvicesDatasRef = mActionsListener.getAdviceListRef();

    return view;
  }

  @OnItemClick(R.id.list_view_1_item) void onItemSelected(int position) {
    Advice selectList = mAdvicesListAdapter.getItem(position);
    Log.e("evento onclick", selectList.toString());
    if (selectList != null) {
      listener.onAdviceClicked(mAdvicesListAdapter.getRef(position).getKey(),
          selectList.getEffect());
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

    Query orderedTreatmentListsRef = mAdvicesDatasRef;

    mAdvicesListAdapter = new AdviceListAdapter(getActivity(), Advice.class, R.layout.list_1_item,
        orderedTreatmentListsRef);
    mAdviceList.setAdapter(mAdvicesListAdapter);
  }

  @Override public void onPause() {
    super.onPause();
    mAdvicesListAdapter.cleanup();
  }

  @Override public void onDestroyView() {
    super.onDestroyView();
    ButterKnife.unbind(this);
  }
}
