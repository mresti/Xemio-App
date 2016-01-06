package es.mresti.xemio.app.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import es.mresti.xemio.R;
import es.mresti.xemio.app.view.activity.HistoricalListActivity;
import es.mresti.xemio.app.view.activity.IncidenceListActivity;

public class HistoryListFragment extends BaseFragment {

  public HistoryListFragment() {
        /* Required empty public constructor */
  }

  /**
   * Create fragment and pass bundle with data as it's arguments
   * Right now there are not arguments...but eventually there will be.
   */
  public static HistoryListFragment newInstance() {
    HistoryListFragment fragment = new HistoryListFragment();
    Bundle args = new Bundle();
    fragment.setArguments(args);
    return fragment;
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View fragmentView = inflater.inflate(R.layout.fragment_tab_history, container, false);

    Button btn1 = (Button) fragmentView.findViewById(R.id.btn_advices_screen);

    btn1.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Intent intent = new Intent(getActivity(), HistoricalListActivity.class);
        getActivity().startActivity(intent);
      }
    });

    Button btn2 = (Button) fragmentView.findViewById(R.id.btn_incidences_screen);

    btn2.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Intent intent = new Intent(getActivity(), IncidenceListActivity.class);
        getActivity().startActivity(intent);
      }
    });

    return fragmentView;
  }

  /**
   * Cleanup the adapter when activity is destroyed.
   */
  @Override public void onDestroy() {
    super.onDestroy();
  }

  /**
   * Link list view from XML
   */
  private void initializeScreen(View rootView) {
    //mListView = (ListView) rootView.findViewById(R.id.list_view_active_lists);
  }
}
