package es.mresti.xemio.app.view.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import es.mresti.xemio.R;

public class InfoFragment extends Fragment {

  private static final String TITLE = "title";

  private String title;

  /**
   * Instances a new fragment with a title page.
   *
   * @param title title page
   * @return a new page
   */
  public static InfoFragment newInstance(String title) {

    // Instantiate a new fragment
    InfoFragment fragment = new InfoFragment();

    // Save the parameters
    Bundle bundle = new Bundle();
    bundle.putString(TITLE, title);
    fragment.setArguments(bundle);
    fragment.setRetainInstance(true);

    return fragment;
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    this.title = (getArguments() != null) ? getArguments().getString(TITLE) : "Xemio";
  }

  @Override public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {

    ViewGroup rootView =
        (ViewGroup) inflater.inflate(R.layout.fragment_slide_page, container, false);

    TextView tvTitle = (TextView) rootView.findViewById(R.id.tvTitle);
    tvTitle.setText(String.valueOf(this.title));

    rootView.setBackgroundColor(Color.parseColor("#f1f1f3"));

    return rootView;
  }
}
