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
import es.mresti.xemio.app.navigation.Navigator;
import es.mresti.xemio.app.presenter.ListTreatmentsPresenter;
import es.mresti.xemio.app.presenter.PresenterFactory;
import es.mresti.xemio.app.view.ListTreatmentView;
import es.mresti.xemio.app.view.adapter.FirebaseListAdapter;
import java.util.HashMap;

public class ListTreatmentActivity extends BaseActivity implements ListTreatmentView {

  public static final String TAG = "kListTreatmentActivity";
  private Navigator mNavigator;
  private Firebase mTreatmentsDatasRef;
  private FirebaseListAdapter<HashMap> mTreatmentsListAdapter;
  private ListTreatmentsPresenter mPresenter;

  // UI items
  @Bind(R.id.toolbar) Toolbar mToolbar;
  @Bind(R.id.listTreatment) ListView mTreatmentList;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, ListTreatmentActivity.class);
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_list_treatments);
    ButterKnife.bind(this);
    this.mPresenter = PresenterFactory.getListTreatmentPresenter(this);
    this.mNavigator = new Navigator();
    this.initialize();
  }

  /**
   * Initializes activity's private members.
   */
  private void initialize() {
    setSupportActionBar(mToolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    mPresenter.initializeContext(this.getContext());
    mTreatmentsDatasRef = mPresenter.getRef();
  }

  @Override protected void onStart() {
    super.onStart();
    mTreatmentsListAdapter = new FirebaseListAdapter<HashMap>(mTreatmentsDatasRef, HashMap.class,
        R.layout.item_list_1_tv, this) {

      @Override protected void populateView(View v, HashMap model) {
        final String key = ListTreatmentActivity.this.mTreatmentsListAdapter.getModelKey(model);
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
    Intent intent = new Intent(this.getContext(), DetailsTreatmentActivity.class);
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

  @Override public Context getContext() {
    return getApplicationContext();
  }
}