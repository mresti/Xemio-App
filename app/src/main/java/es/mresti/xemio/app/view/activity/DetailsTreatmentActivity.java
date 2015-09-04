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
import es.mresti.xemio.app.model.Treatment;
import es.mresti.xemio.app.navigation.Navigator;
import es.mresti.xemio.app.presenter.DetailTreatmentPresenter;
import es.mresti.xemio.app.presenter.PresenterFactory;
import es.mresti.xemio.app.view.DetailTreatmentView;

public class DetailsTreatmentActivity extends BaseActivity implements DetailTreatmentView {

  public static final String TAG = "DetailsTreatmentActivity";
  private Navigator mNavigator;
  private Firebase mTreatmentDataRef;
  private DetailTreatmentPresenter mPresenter;
  private String mTreatmentID;
  private Treatment mTreatment;

  // UI items
  @Bind(R.id.toolbar) Toolbar mToolbar;
  @Bind(R.id.tvTitle) TextView mTextViewTitle;
  @Bind(R.id.tvDesc) TextView mTextViewDesc;
  @Bind(R.id.tvTreat) TextView mTextViewTreat;

  public static Intent getCallingIntent(Context context, String key) {
    Intent callingIntent = new Intent(context, DetailsTreatmentActivity.class);
    callingIntent.putExtra("TREATMENT_ID", key);
    return callingIntent;
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Intent intent = getIntent();
    mTreatmentID = intent.getStringExtra("TREATMENT_ID");
    setContentView(R.layout.activity_details_treatment);
    ButterKnife.bind(this);
    this.initialize();
  }

  /**
   * Initializes activity's private members.
   */
  private void initialize() {
    mPresenter = PresenterFactory.getDetailTreatmentPresenter(this);
    mNavigator = new Navigator();
    setSupportActionBar(mToolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    mPresenter.initializeContext(this.getContext());
    mTreatmentDataRef = mPresenter.getRef(mTreatmentID);
  }

  @Override public void onStart() {
    super.onStart();

    mTreatmentDataRef.addListenerForSingleValueEvent(new ValueEventListener() {
      @Override public void onDataChange(DataSnapshot snapshot) {
        mTreatment = snapshot.getValue(Treatment.class);
        mTextViewTitle.setText(mTreatment.getTitle());
        mTextViewDesc.setText(mTreatment.getDescription());
        mTextViewTreat.setText(mTreatment.getTreatments());
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

  @Override public Context getContext() {
    return getApplicationContext();
  }
}
