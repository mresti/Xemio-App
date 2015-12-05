package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.firebase.client.Firebase;
import es.mresti.xemio.R;
import es.mresti.xemio.app.contract.NotificationsContract;
import es.mresti.xemio.app.navigation.Navigator;
import es.mresti.xemio.app.presenter.NotificationsPresenter;
import es.mresti.xemio.app.view.adapter.FirebaseListAdapter;
import java.util.HashMap;

public class NotificationsActivity extends BaseActivity implements NotificationsContract.View {

  private NotificationsContract.UserActionsListener mActionsListener;
  private Navigator mNavigator;
  private Firebase mNotificationsDatasRef;
  private FirebaseListAdapter<HashMap> mNotificationsListAdapter;

  // UI items
  @Bind(R.id.toolbar) Toolbar mToolbar;
  @Bind(R.id.listNotification) ListView mNotificationsList;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, NotificationsActivity.class);
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_list_notifications);
    ButterKnife.bind(this);
    this.initialize();
  }

  private void initialize() {
    mNavigator = new Navigator();
    mActionsListener = new NotificationsPresenter(this);
    mActionsListener.initializeActions(this.getContext());
    setSupportActionBar(mToolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    mNotificationsDatasRef = mActionsListener.getNotificationListRef();
  }

  @Override public Context getContext() {
    return getApplicationContext();
  }

  @Override public void resume() {
    super.onResume();
  }

  @Override public void pause() {
    super.onPause();
  }

  @Override protected void onStart() {
    super.onStart();

    mNotificationsListAdapter =
        new FirebaseListAdapter<HashMap>(mNotificationsDatasRef, HashMap.class,
            R.layout.item_list_1_tv, this) {
          @Override protected void populateView(View v, final HashMap model) {
            final String key =
                NotificationsActivity.this.mNotificationsListAdapter.getModelKey(model);
            ((TextView) v.findViewById(R.id.item_title)).setText(model.get("message").toString());
          }
        };
    mNotificationsList.setAdapter(mNotificationsListAdapter);
    mNotificationsListAdapter.registerDataSetObserver(new DataSetObserver() {
      @Override public void onChanged() {
        super.onChanged();
        mNotificationsList.setSelection(mNotificationsListAdapter.getCount() - 1);
      }
    });
  }

  @Override protected void onStop() {
    super.onStop();
    mNotificationsListAdapter.cleanup();
  }

  @Override public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    //getMenuInflater().inflate(R.menu.menu_incidence, menu);
    return true;
  }

  @Override public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    if (id == android.R.id.home) {
      finish();
    }
    return super.onOptionsItemSelected(item);
  }
}
