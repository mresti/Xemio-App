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
import es.mresti.xemio.app.contract.TreatmentsContract;
import es.mresti.xemio.app.navigation.Navigator;
import es.mresti.xemio.app.presenter.TreatmentsPresenter;
import es.mresti.xemio.app.view.adapter.FirebaseListAdapter;
import java.util.HashMap;

public class TreatmentsActivity extends BaseActivity implements TreatmentsContract.View {

  private TreatmentsContract.UserActionsListener mActionsListener;
  private Navigator mNavigator;
  private Firebase mTreatmentsDatasRef;
  private FirebaseListAdapter<HashMap> mTreatmentsListAdapter;

  // UI items
  @Bind(R.id.toolbar) Toolbar mToolbar;
  @Bind(R.id.listTreatment) ListView mTreatmentList;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, TreatmentsActivity.class);
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_list_treatments);
    ButterKnife.bind(this);
    this.initialize();
  }

  private void initialize() {
    mNavigator = new Navigator();
    mActionsListener = new TreatmentsPresenter(this);
    mActionsListener.initializeActions(this.getContext());
    setSupportActionBar(mToolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    mTreatmentsDatasRef = mActionsListener.getTreatmentListRef();
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
    mTreatmentsListAdapter = new FirebaseListAdapter<HashMap>(mTreatmentsDatasRef, HashMap.class,
        R.layout.item_list_1_tv, this) {

      @Override protected void populateView(View v, HashMap model) {
        final String key = TreatmentsActivity.this.mTreatmentsListAdapter.getModelKey(model);
        ((TextView) v.findViewById(R.id.item_title)).setText(model.get("title").toString());
        v.setClickable(true);
        v.setOnClickListener(new View.OnClickListener() {
          @Override public void onClick(View v) {
            selectIncidenceItem(key);
          }
        });
      }
    };
    mTreatmentList.setAdapter(mTreatmentsListAdapter);
    mTreatmentsListAdapter.registerDataSetObserver(new DataSetObserver() {
      @Override public void onChanged() {
        super.onChanged();
        mTreatmentList.setSelection(mTreatmentsListAdapter.getCount() - 1);
      }
    });
  }

  @Override protected void onStop() {
    super.onStop();
    mTreatmentsListAdapter.cleanup();
  }

  private void selectIncidenceItem(String key) {
    Intent intent = new Intent(this.getContext(), TreatmentDetailActivity.class);
    intent.putExtra("TREATMENT_ID", key);
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
