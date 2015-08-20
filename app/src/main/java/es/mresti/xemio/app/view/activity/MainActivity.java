package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
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

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    this.initialize();
    mPresenter = PresenterFactory.getMainPresenter(this);
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
    this.mPresenter.getUserStatus();
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

  }

  @Override public void hideProgress() {

  }

  @Override public void navigateToDashboardScreen() {
    this.mNavigator.navigateToDashboard(this);
    finish();
  }

  @Override public void navigateToVerifyScreen() {
    this.mNavigator.navigateToVerify(this);
    finish();
  }

  @Override public void navigateToInitScreen() {
    // Show view components
  }

  @Override public void showRetry() {

  }

  @Override public void hideRetry() {

  }

  @Override public void showError(String message) {

  }

  @Override public Context getContext() {
    return null;
  }
}
