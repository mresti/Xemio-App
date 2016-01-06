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
import es.mresti.xemio.app.view.fragment.TreatmentListFragment;
import es.mresti.xemio.app.view.navigation.Navigator;

public class TreatmentListActivity extends BaseActivity
    implements TreatmentListFragment.TreatmentListener {

  private Navigator mNavigator;

  // UI items
  @Bind(R.id.toolbar) Toolbar mToolbar;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, TreatmentListActivity.class);
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_treatment_list);
    ButterKnife.bind(this);

    this.initialize();
  }

  private void initialize() {
    mNavigator = new Navigator();
    TreatmentListFragment frgList =
        (TreatmentListFragment) getSupportFragmentManager().findFragmentById(
            R.id.fragmentTreatmentList);

    frgList.setTreatmentListener(this);

    mToolbar.setTitle(R.string.toolbar_title_treatment);
    mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        onBackPressed();
      }
    });
  }

  @Override public void onTreatmentClicked(String key) {

    boolean existDetail =
        (getSupportFragmentManager().findFragmentById(R.id.fragmentTreatmentDetail) != null);

    if (existDetail) {
      ((TreatmentDetailFragment) getSupportFragmentManager().findFragmentById(
          R.id.fragmentTreatmentDetail)).showDetail(key);
    } else {
      mNavigator.navigateToTreatmentDetail(this, key);
    }
  }
}
