package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import butterknife.Bind;
import butterknife.ButterKnife;
import es.mresti.xemio.R;
import es.mresti.xemio.app.view.fragment.IncidenceDetailFragment;
import es.mresti.xemio.app.view.fragment.IncidenceListFragment;
import es.mresti.xemio.app.view.navigation.Navigator;

public class IncidenceListActivity extends BaseActivity
    implements IncidenceListFragment.IncidenceListener {

  private Navigator mNavigator;

  // UI items
  @Bind(R.id.toolbar) Toolbar mToolbar;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, IncidenceListActivity.class);
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_incidence_list);
    ButterKnife.bind(this);

    this.initialize();
  }

  private void initialize() {
    mNavigator = new Navigator();
    IncidenceListFragment frgList =
        (IncidenceListFragment) getSupportFragmentManager().findFragmentById(
            R.id.fragmentIncidenceList);

    frgList.setIncidenceListener(this);

    mToolbar.setTitle(R.string.toolbar_title_incidence);
    mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        onBackPressed();
      }
    });
  }

  @Override public void onIncidenceClicked(String key) {
    boolean existDetail =
        (getSupportFragmentManager().findFragmentById(R.id.fragmentIncidenceDetail) != null);
    Log.e("estoy pobando key", key);
    if (existDetail) {
      ((IncidenceDetailFragment) getSupportFragmentManager().findFragmentById(
          R.id.fragmentIncidenceDetail)).showDetail(key);
    } else {
      mNavigator.navigateToIncidenceDetail(this, key);
    }
  }
}

