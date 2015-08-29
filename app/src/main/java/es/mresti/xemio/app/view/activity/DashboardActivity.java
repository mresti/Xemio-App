package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import butterknife.Bind;
import butterknife.ButterKnife;
import es.mresti.xemio.R;
import es.mresti.xemio.app.navigation.Navigator;
import es.mresti.xemio.app.presenter.DashboardPresenter;
import es.mresti.xemio.app.presenter.PresenterFactory;
import es.mresti.xemio.app.view.DashboardView;
import es.mresti.xemio.app.view.adapter.DashboardIconAdapter;

public class DashboardActivity extends BaseActivity
    implements DashboardView, AdapterView.OnItemClickListener {

  private Navigator mNavigator;
  private DashboardPresenter mPresenter;

  // UI items
  @Bind(R.id.toolbar) Toolbar mToolbar;
  @Bind(R.id.dashboard_grid) GridView mGridView;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, DashboardActivity.class);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_dashboard);
    ButterKnife.bind(this);
    this.initialize();
    this.mPresenter = PresenterFactory.getDashboardPresenter(this);
    this.mPresenter.initializeContext(this.getContext());
    this.mPresenter.getUserStatus();
  }

  /**
   * Initializes activity's private members.
   */
  private void initialize() {
    this.mNavigator = new Navigator();
    setSupportActionBar(mToolbar);

    Snackbar.make(findViewById(R.id.main_content), "¡¡Bienvenida!!", Snackbar.LENGTH_LONG).show();

    mGridView.setAdapter(new DashboardIconAdapter(this));
    mGridView.setOnItemClickListener(this);

    // Hack to disable GridView scrolling
    mGridView.setOnTouchListener(new View.OnTouchListener() {
      @Override public boolean onTouch(View v, MotionEvent event) {
        return event.getAction() == MotionEvent.ACTION_MOVE;
      }
    });
  }

  @Override public void showProgress() {

  }

  @Override public void hideProgress() {

  }

  @Override public void navigateToMainScreen() {
    this.mNavigator.navigateToMain(this);
    finish();
  }

  @Override public void showRetry() {

  }

  @Override public void hideRetry() {

  }

  @Override public void showError(String message) {

  }

  @Override public Context getContext() {
    return getApplicationContext();
  }

  @Override public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
    switch (position) {
      case 0:
        //Goes to the info screen.
        this.mNavigator.navigateToInfo(this);
        break;
      case 1:
        //Goes to the trata screen.
        this.mNavigator.navigateToTrata(this);
        break;
      case 2:
        //Goes to the incidence screen.
        this.mNavigator.navigateToNewIncidence(this);
        break;
      case 3:
        //Goes to the history screen.
        this.mNavigator.navigateToHistory(this);
        break;
      case 4:
        //Goes to the settings screen.
        this.mNavigator.navigateToSettings(this);
        finish();
        break;
      case 5:
        // Goes to the xemio website.
        this.mNavigator.navigateToXemioWeb(this);
        break;
      default:
        break;
    }
  }
}
