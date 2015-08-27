package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import es.mresti.xemio.R;
import es.mresti.xemio.app.navigation.Navigator;
import es.mresti.xemio.app.presenter.MainPresenter;
import es.mresti.xemio.app.presenter.PresenterFactory;
import es.mresti.xemio.app.view.MainView;

/**
 * Main application screen. This is the app entry point.
 */
public class MainActivity extends BaseActivity implements MainView {

  private Navigator mNavigator;
  private MainPresenter mPresenter;

  // UI items
  @Bind(R.id.btn_begin) Button mBtn_begin;
  @Bind(R.id.btn_deny) Button mBtn_deny;
  @Bind(R.id.container_main) LinearLayout mLayoutContainer;
  @Bind(R.id.toolbar_bottom) LinearLayout mLayoutToolbar;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, MainActivity.class);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    this.initialize();
    this.mPresenter = PresenterFactory.getMainPresenter(this);
    this.mPresenter.initializeContext(this.getContext());
    this.mPresenter.getUserStatus();
  }

  /**
   * Initializes activity's private members.
   */
  private void initialize() {
    this.mNavigator = new Navigator();
  }

  /**
   * Goes to the user register screen.
   */
  @OnClick(R.id.btn_begin) void navigateToRegisterscreen() {
    this.mNavigator.navigateToUserRegister(this);
    finish();
  }

  /**
   * Goes to the finish activity.
   */
  @OnClick(R.id.btn_deny) void navigateToFinish() {
    finish();
  }

  @Override public void showProgress() {
    mLayoutContainer.setVisibility(View.VISIBLE);
    mLayoutToolbar.setVisibility(View.VISIBLE);
  }

  @Override public void hideProgress() {
    mLayoutContainer.setVisibility(View.GONE);
    mLayoutToolbar.setVisibility(View.GONE);
  }

  @Override public void navigateToDashboardScreen() {
    this.mNavigator.navigateToDashboard(this);
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
}
