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
import es.mresti.xemio.app.view.fragment.AdviceDetailFragment;
import es.mresti.xemio.app.view.fragment.AdviceListFragment;
import es.mresti.xemio.app.view.navigation.Navigator;

public class AdviceListActivity extends BaseActivity implements AdviceListFragment.AdviceListener {

  private Navigator mNavigator;

  // UI items
  @Bind(R.id.toolbar) Toolbar mToolbar;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, AdviceListActivity.class);
  }

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_advice_list);
    ButterKnife.bind(this);

    this.initialize();
  }

  private void initialize() {
    mNavigator = new Navigator();
    AdviceListFragment frgList =
        (AdviceListFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentAdviceList);

    frgList.setAdviceListener(this);

    mToolbar.setTitle(R.string.toolbar_title_effect);
    mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        onBackPressed();
      }
    });
  }

  @Override public void onAdviceClicked(String key, String name) {
    boolean existDetail =
        (getSupportFragmentManager().findFragmentById(R.id.fragmentAdviceDetail) != null);

    if (existDetail) {
      ((AdviceDetailFragment) getSupportFragmentManager().findFragmentById(
          R.id.fragmentAdviceDetail)).showDetail(key, name);
    } else {
      mNavigator.navigateToAdviceDetail(this, key, name);
    }
  }
}

