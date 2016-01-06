package es.mresti.xemio.app.view.adapter;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;
import com.firebase.client.Query;
import com.firebase.ui.FirebaseListAdapter;
import es.mresti.xemio.R;
import es.mresti.xemio.app.model.Channel;

/**
 * Populates the list_view_treatment_lists inside ChatListFragment
 */
public class ChatListAdapter extends FirebaseListAdapter<Channel> {

  /**
   * Public constructor that initializes private instance variables when adapter is created
   */
  public ChatListAdapter(Activity activity, Class<Channel> modelClass, int modelLayout, Query ref) {
    super(activity, modelClass, modelLayout, ref);
    this.mActivity = activity;
  }

  /**
   * Protected method that populates the view attached to the adapter (list_view_treatment_lists)
   * with items inflated from list_1_item.xml
   * populateView also handles data changes and updates the listView accordingly
   */
  @Override protected void populateView(View view, Channel list) {

    TextView textViewName = (TextView) view.findViewById(R.id.item_title);

    textViewName.setText(list.getFoundation());
  }
}

