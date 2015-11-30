package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import es.mresti.xemio.R;
import es.mresti.xemio.app.contract.EffectDetailContract;
import es.mresti.xemio.app.model.Advice;
import es.mresti.xemio.app.navigation.Navigator;
import es.mresti.xemio.app.presenter.EffectDetailPresenter;

public class EffectDetailActivity extends BaseActivity implements EffectDetailContract.View {

  private EffectDetailContract.UserActionsListener mActionsListener;
  private Navigator mNavigator;
  private Firebase mEffectDataRef;
  private String mEffectID;
  private Advice mAdvice;

  // UI items
  @Bind(R.id.toolbar) Toolbar mToolbar;
  @Bind(R.id.tvAdvice) TextView mTextViewAdvice;
  @Bind(R.id.tvCategory) TextView mTextViewCategory;
  @Bind(R.id.tvEffect) TextView mTextViewEffect;

  public static Intent getCallingIntent(Context context, String key) {
    Intent callingIntent = new Intent(context, EffectDetailActivity.class);
    callingIntent.putExtra("EFFECT_ID", key);
    return callingIntent;
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Intent intent = getIntent();
    mEffectID = intent.getStringExtra("EFFECT_ID");
    setContentView(R.layout.activity_details_effect);
    ButterKnife.bind(this);
    this.initialize();
  }

  private void initialize() {
    mNavigator = new Navigator();
    mActionsListener = new EffectDetailPresenter(this);
    mActionsListener.initializeActions(this.getContext());
    setSupportActionBar(mToolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    mEffectDataRef = mActionsListener.getEffectRef(mEffectID);
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

  @Override public void onStart() {
    super.onStart();

    mEffectDataRef.addListenerForSingleValueEvent(new ValueEventListener() {
      @Override public void onDataChange(DataSnapshot snapshot) {
        mAdvice = snapshot.getValue(Advice.class);
        mTextViewEffect.setText(mAdvice.getEffect());
        mTextViewCategory.setText(mAdvice.getCategory());
        mTextViewAdvice.setText(mAdvice.getAdvice());
      }

      @Override public void onCancelled(FirebaseError firebaseError) {
      }
    });
  }

  @Override public void onStop() {
    super.onStop();
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


