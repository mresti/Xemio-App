package es.mresti.xemio.app.view.adapter;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import com.firebase.client.Query;
import com.firebase.ui.FirebaseListAdapter;
import es.mresti.xemio.R;
import es.mresti.xemio.app.model.Advice;

/**
 * Populates the list_view_treatment_lists inside HistoricalListFragment
 */
public class HistoricalListAdapter extends FirebaseListAdapter<Advice> {

  /**
   * Public constructor that initializes private instance variables when adapter is created
   */
  public HistoricalListAdapter(Activity activity, Class<Advice> modelClass, int modelLayout,
      Query ref) {
    super(activity, modelClass, modelLayout, ref);
    this.mActivity = activity;
  }

  /**
   * Protected method that populates the view attached to the adapter (list_view_treatment_lists)
   * with items inflated from list_1_item.xml
   * populateView also handles data changes and updates the listView accordingly
   */
  @Override protected void populateView(View view, Advice list) {

    TextView textViewName = (TextView) view.findViewById(R.id.item_title);

    textViewName.setText(list.getEffect());
  }
}
