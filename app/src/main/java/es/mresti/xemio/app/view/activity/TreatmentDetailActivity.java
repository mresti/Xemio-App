package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.Bind;
import butterknife.ButterKnife;
import es.mresti.xemio.R;
import es.mresti.xemio.app.view.fragment.TreatmentDetailFragment;

public class TreatmentDetailActivity extends BaseActivity {

  // UI items
  @Bind(R.id.toolbar) Toolbar mToolbar;

  public static Intent getCallingIntent(Context context, String key) {
    Intent callingIntent = new Intent(context, TreatmentDetailActivity.class);
    callingIntent.putExtra("TREATMENT_ID", key);
    return callingIntent;
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Intent intent = getIntent();
    String mTreatmentID = intent.getStringExtra("TREATMENT_ID");
    setContentView(R.layout.activity_treatment_detail);
    ButterKnife.bind(this);
    this.initialize();

    TreatmentDetailFragment detail =
        (TreatmentDetailFragment) getSupportFragmentManager().findFragmentById(
            R.id.fragmentTreatmentDetail);
    detail.showDetail(mTreatmentID);
  }

  private void initialize() {
    mToolbar.setTitle(R.string.toolbar_title_treatment_detail);
    mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        onBackPressed();
      }
    });
  }
}



