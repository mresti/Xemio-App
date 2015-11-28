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
import es.mresti.xemio.app.view.activity.DashboardActivity;
import es.mresti.xemio.app.view.activity.EffectsActivity;
import es.mresti.xemio.app.view.activity.InfoActivity;
import es.mresti.xemio.app.view.activity.TreatmentsActivity;

public class InfoListFragment extends BaseFragment {

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Nullable @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View fragmentView = inflater.inflate(R.layout.fragment_info_list, container, false);

    Button btn1 = (Button) fragmentView.findViewById(R.id.btn_info_screen);

    btn1.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Intent intent = new Intent(getActivity(), InfoActivity.class);
        ((DashboardActivity) getActivity()).startActivity(intent);
      }
    });

    Button btn2 = (Button) fragmentView.findViewById(R.id.btn_treat_screen);

    btn2.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Intent intent = new Intent(getActivity(), TreatmentsActivity.class);
        ((DashboardActivity) getActivity()).startActivity(intent);
      }
    });

    Button btn3 = (Button) fragmentView.findViewById(R.id.btn_effect_screen);

    btn3.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Intent intent = new Intent(getActivity(), EffectsActivity.class);
        ((DashboardActivity) getActivity()).startActivity(intent);
      }
    });

    Button btn4 = (Button) fragmentView.findViewById(R.id.btn_web_screen);

    btn4.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        Intent intentToLaunch = new Intent(Intent.ACTION_VIEW);
        intentToLaunch.setData(Uri.parse("http://xemio.org"));
        ((DashboardActivity) getActivity()).startActivity(intentToLaunch);
      }
    });

    return fragmentView;
  }
}



