package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.firebase.client.Firebase;
import es.mresti.xemio.R;
import es.mresti.xemio.app.contract.NotificationListContract;
import es.mresti.xemio.app.presenter.NotificationListPresenter;
import es.mresti.xemio.app.view.adapter.FirebaseListAdapter;
import es.mresti.xemio.app.view.navigation.Navigator;
import java.util.HashMap;

public class NotificationListActivity extends BaseActivity
    implements NotificationListContract.View {

  private NotificationListContract.UserActionsListener mActionsListener;
  private Navigator mNavigator;
  private Firebase mNotificationsDatasRef;
  private FirebaseListAdapter<HashMap> mNotificationsListAdapter;

  // UI items
  @Bind(R.id.toolbar) Toolbar mToolbar;
  @Bind(R.id.listNotification) ListView mNotificationsList;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, NotificationListActivity.class);
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_notification_list);
    ButterKnife.bind(this);
    this.initialize();
  }

  private void initialize() {
    mNavigator = new Navigator();
    mActionsListener = new NotificationListPresenter(this);
    setSupportActionBar(mToolbar);
    mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        onBackPressed();
      }
    });
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
            R.layout.list_1_item, this) {
          @Override protected void populateView(View v, final HashMap model) {
            final String key =
                NotificationListActivity.this.mNotificationsListAdapter.getModelKey(model);
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
}
