package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import es.mresti.xemio.R;
import es.mresti.xemio.app.contract.MainContract;
import es.mresti.xemio.app.navigation.Navigator;
import es.mresti.xemio.app.presenter.MainPresenter;

/**
 * Main application screen. This is the app entry point.
 */
public class MainActivity extends BaseActivity implements MainContract.View {

  private MainContract.UserActionsListener mActionsListener;
  private Navigator mNavigator;

  // UI items
  @Bind(R.id.btn_begin) Button mBtn_begin;
  @Bind(R.id.btn_deny) Button mBtn_deny;
  @Bind(R.id.container_main) ScrollView mLayoutContainer;
  @Bind(R.id.toolbar_bottom) LinearLayout mLayoutToolbar;

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
    mActionsListener.initializeActions(this.getContext());
    mActionsListener.getUserStatus();
  }

  @Override public void showProgress() {
    mLayoutContainer.setVisibility(View.VISIBLE);
    mLayoutToolbar.setVisibility(View.VISIBLE);
  }

  @Override public void hideProgress() {
    mLayoutContainer.setVisibility(View.GONE);
    mLayoutToolbar.setVisibility(View.GONE);
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
    mNavigator.navigateToUserRegister(this);
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
  @OnClick(R.id.btn_begin) void openRegisterActivity() {
    this.openRegister();
  }

  /**
   * Goes to the finish activity.
   */
  @OnClick(R.id.btn_deny) void closeMainActivity() {
    this.closeApp();
  }
}
