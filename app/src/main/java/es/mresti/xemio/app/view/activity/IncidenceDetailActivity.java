package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.Bind;
import butterknife.ButterKnife;
import es.mresti.xemio.R;
import es.mresti.xemio.app.view.fragment.IncidenceDetailFragment;

public class IncidenceDetailActivity extends BaseActivity
    implements IncidenceDetailFragment.IncidenceListener {

  // UI items
  @Bind(R.id.toolbar) Toolbar mToolbar;

  public static Intent getCallingIntent(Context context, String key) {
    Intent callingIntent = new Intent(context, IncidenceDetailActivity.class);
    callingIntent.putExtra("INCIDENCE_ID", key);
    return callingIntent;
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Intent intent = getIntent();
    String mIncidenceID = intent.getStringExtra("INCIDENCE_ID");
    setContentView(R.layout.activity_incidence_detail);
    ButterKnife.bind(this);
    this.initialize();

    IncidenceDetailFragment detail =
        (IncidenceDetailFragment) getSupportFragmentManager().findFragmentById(
            R.id.fragmentIncidenceDetail);
    detail.showDetail(mIncidenceID);
  }

  private void initialize() {
    mToolbar.setTitle(R.string.toolbar_title_incidence_detail);
    mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        onBackPressed();
      }
    });

    IncidenceDetailFragment frgList =
        (IncidenceDetailFragment) getSupportFragmentManager().findFragmentById(
            R.id.fragmentIncidenceDetail);

    frgList.setIncidenceListener(this);
  }

  @Override public void onDeleteClicked() {
    onBackPressed();
  }
}



