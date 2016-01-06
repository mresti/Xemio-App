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
import es.mresti.xemio.app.contract.HistoricalListContract;
import es.mresti.xemio.app.presenter.HistoricalListPresenter;
import es.mresti.xemio.app.view.adapter.FirebaseListAdapter;
import es.mresti.xemio.app.view.navigation.Navigator;
import java.util.HashMap;

public class HistoricalListActivity extends BaseActivity implements HistoricalListContract.View {

  private HistoricalListContract.UserActionsListener mActionsListener;
  private Navigator mNavigator;
  private Firebase mHistoricalDatasRef;
  private FirebaseListAdapter<HashMap> mHistoricalListAdapter;

  // UI items
  @Bind(R.id.toolbar) Toolbar mToolbar;
  @Bind(R.id.listItems) ListView mEffectsList;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, HistoricalListActivity.class);
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_list_items);
    ButterKnife.bind(this);
    this.initialize();
  }

  private void initialize() {
    mNavigator = new Navigator();
    mActionsListener = new HistoricalListPresenter(this);
    setSupportActionBar(mToolbar);
    if (getSupportActionBar() != null) {
      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    mHistoricalDatasRef = mActionsListener.getHistoricalListRef();
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

    mHistoricalListAdapter =
        new FirebaseListAdapter<HashMap>(mHistoricalDatasRef, HashMap.class, R.layout.list_1_item,
            this) {
          @Override protected void populateView(View v, final HashMap model) {
            ((TextView) v.findViewById(R.id.item_title)).setText(
                model.get("adviceName").toString());
            v.setClickable(true);
            v.setOnClickListener(new View.OnClickListener() {
              @Override public void onClick(View v) {
                selectIncidenceItem(model.get("adviceKey").toString(),
                    model.get("adviceName").toString());
              }
            });
          }
        };
    mEffectsList.setAdapter(mHistoricalListAdapter);
    mHistoricalListAdapter.registerDataSetObserver(new DataSetObserver() {
      @Override public void onChanged() {
        super.onChanged();
        mEffectsList.setSelection(mHistoricalListAdapter.getCount() - 1);
      }
    });
  }

  @Override protected void onStop() {
    super.onStop();
    mHistoricalListAdapter.cleanup();
  }

  private void selectIncidenceItem(String key, String effect) {
    Intent intent = new Intent(this.getContext(), HistoricalDetailActivity.class);
    intent.putExtra("EFFECT_ID", key);
    intent.putExtra("EFFECT_NAME", effect);
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
}
