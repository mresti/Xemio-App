package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import com.firebase.client.Firebase;
import es.mresti.xemio.R;
import es.mresti.xemio.app.navigation.Navigator;
import es.mresti.xemio.app.presenter.ListIncidencesPresenter;
import es.mresti.xemio.app.presenter.PresenterFactory;
import es.mresti.xemio.app.view.ListIncidencesView;
import es.mresti.xemio.app.view.adapter.FirebaseListAdapter;
import java.util.HashMap;

public class ListIncidencesActivity extends BaseActivity implements ListIncidencesView {

  public static final String TAG = "ListIncidencesActivity";
  private Navigator mNavigator;
  private Firebase mIncidencesDatasRef;
  private FirebaseListAdapter<HashMap> mIncidencesListAdapter;
  private ListIncidencesPresenter mPresenter;

  // UI items
  @Bind(R.id.toolbar) Toolbar mToolbar;
  @Bind(R.id.container_empty) RelativeLayout mLayoutEmptyView;
  @Bind(R.id.layout_list) LinearLayout mLayoutList;
  @Bind(R.id.listIncidence) ListView mIncidenceList;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, ListIncidencesActivity.class);
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_list_incidences);
    ButterKnife.bind(this);
    this.initialize();
  }

  /**
   * Initializes activity's private members.
   */
  private void initialize() {
    mPresenter = PresenterFactory.getListIncidencesPresenter(this);
    mNavigator = new Navigator();
    setSupportActionBar(mToolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    mPresenter.initializeContext(this.getContext());
    mIncidencesDatasRef = mPresenter.getRef();
  }

  @Override protected void onStart() {
    super.onStart();
    mLayoutList.setVisibility(View.GONE);
    mIncidencesListAdapter = new FirebaseListAdapter<HashMap>(mIncidencesDatasRef, HashMap.class,
        R.layout.item_list_1_tv, this) {
      @Override protected void populateView(View v, final HashMap model) {
        final String key = ListIncidencesActivity.this.mIncidencesListAdapter.getModelKey(model);
        ((TextView) v.findViewById(R.id.item_title)).setText(model.get("subject").toString());
        v.setClickable(true);
        v.setOnClickListener(new View.OnClickListener() {
          @Override public void onClick(View v) {
            selectIncidenceItem(key);
          }
        });
      }
    };
    mIncidenceList.setAdapter(mIncidencesListAdapter);
    mIncidencesListAdapter.registerDataSetObserver(new DataSetObserver() {
      @Override public void onChanged() {
        super.onChanged();
        mIncidenceList.setSelection(mIncidencesListAdapter.getCount() - 1);
        if (mIncidencesListAdapter.getCount() != 0) {
          mLayoutEmptyView.setVisibility(View.GONE);
          mLayoutList.setVisibility(View.VISIBLE);
        } else {
          mLayoutEmptyView.setVisibility(View.VISIBLE);
          mLayoutList.setVisibility(View.GONE);
        }
      }
    });
  }

  @Override protected void onStop() {
    super.onStop();
    mIncidencesListAdapter.cleanup();
  }

  private void selectIncidenceItem(String key) {
    Intent intent = new Intent(this.getContext(), DetailsIncidenceActivity.class);
    intent.putExtra("INCIDENCE_ID", key);
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
