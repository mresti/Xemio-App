package es.mresti.xemio.app.view.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import es.mresti.xemio.R;
import es.mresti.xemio.app.view.activity.AdviceListActivity;
import es.mresti.xemio.app.view.activity.ChatListActivity;
import es.mresti.xemio.app.view.activity.DashboardActivity;
import es.mresti.xemio.app.view.activity.InfoActivity;
import es.mresti.xemio.app.view.activity.TreatmentListActivity;

public class InfoListFragment extends BaseFragment {

  public InfoListFragment() {
        /* Required empty public constructor */
  }

  /**
   * Create fragment and pass bundle with data as it's arguments
   * Right now there are not arguments...but eventually there will be.
   */
  public static InfoListFragment newInstance() {
    InfoListFragment fragment = new InfoListFragment();
    Bundle args = new Bundle();
    fragment.setArguments(args);
    return fragment;
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View fragmentView = inflater.inflate(R.layout.fragment_tab_info, container, false);

    Button btn1 = (Button) fragmentView.findViewById(R.id.btn_info_screen);

    btn1.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Intent intent = new Intent(getActivity(), InfoActivity.class);
        getActivity().startActivity(intent);
      }
    });

    Button btn2 = (Button) fragmentView.findViewById(R.id.btn_treat_screen);

    btn2.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Intent intent = new Intent(getActivity(), TreatmentListActivity.class);
        getActivity().startActivity(intent);
      }
    });

    Button btn3 = (Button) fragmentView.findViewById(R.id.btn_effect_screen);

    btn3.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Intent intent = new Intent(getActivity(), AdviceListActivity.class);
        getActivity().startActivity(intent);
      }
    });

    Button btn4 = (Button) fragmentView.findViewById(R.id.btn_chat_screen);

    btn4.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Intent intent = new Intent(getActivity(), ChatListActivity.class);
        getActivity().startActivity(intent);
      }
    });

    Button btn5 = (Button) fragmentView.findViewById(R.id.btn_web_screen);

    btn5.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Intent intentToLaunch = new Intent(Intent.ACTION_VIEW);
        intentToLaunch.setData(Uri.parse("http://xemio.org"));
        ((DashboardActivity) getActivity()).startActivity(intentToLaunch);
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



