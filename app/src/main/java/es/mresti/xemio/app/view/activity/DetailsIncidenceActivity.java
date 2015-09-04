package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.afollestad.materialdialogs.MaterialDialog;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import es.mresti.xemio.R;
import es.mresti.xemio.app.model.Incidence;
import es.mresti.xemio.app.navigation.Navigator;
import es.mresti.xemio.app.presenter.DetailIncidencePresenter;
import es.mresti.xemio.app.presenter.PresenterFactory;
import es.mresti.xemio.app.view.DetailIncidenceView;

public class DetailsIncidenceActivity extends BaseActivity implements DetailIncidenceView {

  public static final String TAG = "DetailsIncidenceActivity";
  private Navigator mNavigator;
  private Firebase mIncidenceDataRef;
  private DetailIncidencePresenter mPresenter;
  private String mIncidenceID;
  private Incidence mIncidence;

  // UI items
  @Bind(R.id.toolbar) Toolbar mToolbar;
  @Bind(R.id.tvSubject) TextView mTextViewSub;
  @Bind(R.id.tvDesc) TextView mTextViewDesc;
  @Bind(R.id.fab_back) FloatingActionButton mFABBack;
  @Bind(R.id.fab_del) FloatingActionButton mFABDel;

  public static Intent getCallingIntent(Context context, String key) {
    Intent callingIntent = new Intent(context, DetailsIncidenceActivity.class);
    callingIntent.putExtra("INCIDENCE_ID", key);
    return callingIntent;
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Intent intent = getIntent();
    mIncidenceID = intent.getStringExtra("INCIDENCE_ID");
    setContentView(R.layout.activity_details_incidence);
    ButterKnife.bind(this);
    this.initialize();
  }

  /**
   * Initializes activity's private members.
   */
  private void initialize() {
    mPresenter = PresenterFactory.getDetailIncidencePresenter(this);
    setSupportActionBar(mToolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    mPresenter.initializeContext(this.getContext());
    mIncidenceDataRef = mPresenter.getRef(mIncidenceID);
    mNavigator = new Navigator();
  }

  @Override public void onStart() {
    super.onStart();

    mIncidenceDataRef.addListenerForSingleValueEvent(new ValueEventListener() {
      @Override public void onDataChange(DataSnapshot snapshot) {
        mIncidence = snapshot.getValue(Incidence.class);
        mTextViewSub.setText(mIncidence.getSubject());
        mTextViewDesc.setText(mIncidence.getDescription());
      }

      @Override public void onCancelled(FirebaseError firebaseError) {
      }
    });
  }

  @Override public void onStop() {
    super.onStop();
  }

  @OnClick(R.id.fab_back) void navigateToHistoryScreen() {
    mNavigator.navigateToHistory(this);
    finish();
  }

  @OnClick(R.id.fab_del) void deleteItem() {
    MaterialDialog dialog =
        new MaterialDialog.Builder(this).title(R.string.dialog_title_detail_incidence)
            .content(R.string.dialog_message_detail_incidence)
            .positiveText(android.R.string.ok)
            .negativeText(android.R.string.cancel)
            .callback(new MaterialDialog.ButtonCallback() {
              @Override public void onPositive(MaterialDialog dialog) {
                removeItemChild();
              }

              @Override public void onNegative(MaterialDialog dialog) {
              }
            })
            .show();
  }

  private void removeItemChild() {
    mPresenter.removeIncidence(mIncidenceID);
    mNavigator.navigateToHistory(this);
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
