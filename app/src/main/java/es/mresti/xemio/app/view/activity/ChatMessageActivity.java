package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.firebase.client.Firebase;
import es.mresti.xemio.R;
import es.mresti.xemio.app.contract.ChatMessageContract;
import es.mresti.xemio.app.presenter.ChatMessagePresenter;
import es.mresti.xemio.app.view.adapter.ChatMessageAdapter;
import es.mresti.xemio.app.view.navigation.Navigator;

public class ChatMessageActivity extends BaseActivity implements ChatMessageContract.View {

  private ChatMessageContract.UserActionsListener mActionsListener;
  private Navigator mNavigator;
  private Firebase mRoomDatasRef;
  private ChatMessageAdapter mRoomListAdapter;
  private String mUsername;
  private String mChatID;
  private String mFoundation;

  // UI items
  @Bind(R.id.toolbar) Toolbar mToolbar;
  @Bind(R.id.listChat) ListView mRoomList;
  @Bind(R.id.messageInput) EditText mInputText;
  @Bind(R.id.sendButton) ImageButton mSendButton;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, ChatMessageActivity.class);
  }

  public static Intent getCallingIntent(Context context, String key) {
    Intent callingIntent = new Intent(context, ChatMessageActivity.class);
    callingIntent.putExtra("CHAT_ID", key);
    return callingIntent;
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mFoundation = "Fundacion iSYS";
    Intent intent = getIntent();
    mChatID = intent.getStringExtra("CHAT_ID");
    setContentView(R.layout.activity_chat);
    ButterKnife.bind(this);
    this.initialize();
  }

  private void initialize() {
    mNavigator = new Navigator();
    mActionsListener = new ChatMessagePresenter(this);
    mToolbar.setTitle(mFoundation);
    setSupportActionBar(mToolbar);
    if (getSupportActionBar() != null) {
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    mRoomDatasRef = mActionsListener.getChatMessageListRef(mChatID);
    mUsername = "Esteban"; //TODO: cambiar esto

    mInputText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
      @Override public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
        if (actionId == EditorInfo.IME_NULL && keyEvent.getAction() == KeyEvent.ACTION_DOWN) {
          sendMessage();
        }
        return true;
      }
    });
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
    mRoomListAdapter =
        new ChatMessageAdapter(mRoomDatasRef.limitToLast(50), this, R.layout.item_chat_message,
            mUsername);

    mRoomList.setAdapter(mRoomListAdapter);
    mRoomListAdapter.registerDataSetObserver(new DataSetObserver() {
      @Override public void onChanged() {
        super.onChanged();
        mRoomList.setSelection(mRoomListAdapter.getCount() - 1);
      }
    });
  }

  @Override protected void onStop() {
    super.onStop();
    mRoomListAdapter.cleanup();
  }

  private void selectChannelItem(String key) {
    Intent intent = new Intent(this.getContext(), DashboardActivity.class);
    intent.putExtra("CHAT_ID", key);
    startActivity(intent);
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

  @OnClick(R.id.sendButton) void sendMessage() {
    EditText inputText = (EditText) findViewById(R.id.messageInput);
    String input = inputText.getText().toString();
    if (!input.equals("")) {
      mActionsListener.sendMessageChat(input, mUsername, mChatID);
      inputText.setText("");
    }
  }
}
