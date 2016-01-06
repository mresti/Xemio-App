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
import es.mresti.xemio.app.contract.ChatAddContract;
import es.mresti.xemio.app.presenter.ChatAddPresenter;
import es.mresti.xemio.app.utils.Constants;
import es.mresti.xemio.app.view.adapter.FirebaseListAdapter;
import es.mresti.xemio.app.view.navigation.Navigator;
import java.util.HashMap;

public class ChatAddActivity extends BaseActivity implements ChatAddContract.View {

  private ChatAddContract.UserActionsListener mActionsListener;
  private Navigator mNavigator;
  private Firebase mChannelsDatasRef;
  private FirebaseListAdapter<HashMap> mChannelsListAdapter;
  private String mUsername;

  // UI items
  @Bind(R.id.toolbar) Toolbar mToolbar;
  @Bind(R.id.listItems) ListView mEffectsList;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, ChatAddActivity.class);
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_list_items);
    ButterKnife.bind(this);
    this.initialize();
  }

  private void initialize() {
    mNavigator = new Navigator();
    mActionsListener = new ChatAddPresenter(this);
    setSupportActionBar(mToolbar);
    if (getSupportActionBar() != null) {
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    mChannelsDatasRef = mActionsListener.getFoundationListRef();
    mUsername = "Esteban"; //TODO: cambiar esto
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

    mChannelsListAdapter =
        new FirebaseListAdapter<HashMap>(mChannelsDatasRef, HashMap.class, R.layout.list_1_item,
            this) {
          @Override protected void populateView(View v, final HashMap model) {
            final String key = ChatAddActivity.this.mChannelsListAdapter.getModelKey(model);
            ((TextView) v.findViewById(R.id.item_title)).setText(model.get("name").toString());
            v.setClickable(true);
            v.setOnClickListener(new View.OnClickListener() {
              @Override public void onClick(View v) {
                selectChannelItem(model.get("name").toString(), key);
              }
            });
          }
        };
    mEffectsList.setAdapter(mChannelsListAdapter);
    mChannelsListAdapter.registerDataSetObserver(new DataSetObserver() {
      @Override public void onChanged() {
        super.onChanged();
        mEffectsList.setSelection(mChannelsListAdapter.getCount() - 1);
      }
    });
  }

  @Override protected void onStop() {
    super.onStop();
    mChannelsListAdapter.cleanup();
  }

  private void selectChannelItem(String found, String key) {
    mActionsListener.addChat(mUsername, found, key);
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
      onBackPressed();
    }
    return super.onOptionsItemSelected(item);
  }

  @Override public void openChannel(String chatId) {
    Intent intent = new Intent(this.getContext(), DashboardActivity.class);
    intent.putExtra(Constants.KEY_CHAT_ID, chatId);
    startActivity(intent);
  }
}
