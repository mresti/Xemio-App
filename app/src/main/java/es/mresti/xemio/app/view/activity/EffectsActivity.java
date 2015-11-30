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
import es.mresti.xemio.app.contract.EffectsContract;
import es.mresti.xemio.app.navigation.Navigator;
import es.mresti.xemio.app.presenter.EffectsPresenter;
import es.mresti.xemio.app.view.adapter.FirebaseListAdapter;
import java.util.HashMap;

public class EffectsActivity extends BaseActivity implements EffectsContract.View {

  private EffectsContract.UserActionsListener mActionsListener;
  private Navigator mNavigator;
  private Firebase mEffectsDatasRef;
  private FirebaseListAdapter<HashMap> mEffectsListAdapter;

  // UI items
  @Bind(R.id.toolbar) Toolbar mToolbar;
  @Bind(R.id.listEffect) ListView mEffectsList;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, EffectsActivity.class);
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_list_effects);
    ButterKnife.bind(this);
    this.initialize();
  }

  private void initialize() {
    mNavigator = new Navigator();
    mActionsListener = new EffectsPresenter(this);
    mActionsListener.initializeActions(this.getContext());
    setSupportActionBar(mToolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    mEffectsDatasRef = mActionsListener.getEffectListRef();
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

    mEffectsListAdapter =
        new FirebaseListAdapter<HashMap>(mEffectsDatasRef, HashMap.class, R.layout.item_list_1_tv,
            this) {
          @Override protected void populateView(View v, final HashMap model) {
            final String key = EffectsActivity.this.mEffectsListAdapter.getModelKey(model);
            ((TextView) v.findViewById(R.id.item_title)).setText(model.get("effect").toString());
            v.setClickable(true);
            v.setOnClickListener(new View.OnClickListener() {
              @Override public void onClick(View v) {
                selectIncidenceItem(key);
              }
            });
          }
        };
    mEffectsList.setAdapter(mEffectsListAdapter);
    mEffectsListAdapter.registerDataSetObserver(new DataSetObserver() {
      @Override public void onChanged() {
        super.onChanged();
        mEffectsList.setSelection(mEffectsListAdapter.getCount() - 1);
      }
    });
  }

  @Override protected void onStop() {
    super.onStop();
    mEffectsListAdapter.cleanup();
  }

  private void selectIncidenceItem(String key) {
    Intent intent = new Intent(this.getContext(), EffectDetailActivity.class);
    intent.putExtra("EFFECT_ID", key);
    startActivity(intent);
    finish();
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
