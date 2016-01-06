package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import es.mresti.xemio.R;
import es.mresti.xemio.app.contract.MainContract;
import es.mresti.xemio.app.presenter.MainPresenter;
import es.mresti.xemio.app.view.navigation.Navigator;

/**
 * Main application screen. This is the app entry point.
 */
public class MainActivity extends BaseActivity implements MainContract.View {

  private MainContract.UserActionsListener mActionsListener;
  private Navigator mNavigator;

  // UI items
  @Bind(R.id.container_main) ScrollView mLayoutContainer;
  @Bind(R.id.nav_bottom) LinearLayout mLayoutNav;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, MainActivity.class);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    this.initialize();
  }

  private void initialize() {
    mNavigator = new Navigator();
    mActionsListener = new MainPresenter(this);
    mActionsListener.getUserStatus();
  }

  @Override public void showProgress() {
    mLayoutContainer.setVisibility(View.VISIBLE);
    mLayoutNav.setVisibility(View.VISIBLE);
  }

  @Override public void hideProgress() {
    mLayoutContainer.setVisibility(View.GONE);
    mLayoutNav.setVisibility(View.GONE);
  }

  @Override public Context getContext() {
    return getApplicationContext();
  }

  @Override public void resume() {
    super.onResume();
  }

  @Override public void pause() {
    super.onPause();
  }

  @Override public void openRegister() {
    mNavigator.navigateToRegister(this);
    finish();
  }

  @Override public void openDashboard() {
    mNavigator.navigateToDashboard(this);
    finish();
  }

  @Override public void closeApp() {
    finish();
  }

  /**
   * Goes to the user register screen.
   */
  @OnClick(R.id.btn_next) void openRegisterActivity() {
    this.openRegister();
  }

  /**
   * Goes to the finish activity.
   */
  @OnClick(R.id.btn_back) void closeMainActivity() {
    this.closeApp();
  }
}
