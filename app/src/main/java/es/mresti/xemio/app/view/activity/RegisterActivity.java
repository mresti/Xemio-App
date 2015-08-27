package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import es.mresti.xemio.R;
import es.mresti.xemio.app.navigation.Navigator;
import es.mresti.xemio.app.presenter.PresenterFactory;
import es.mresti.xemio.app.presenter.RegisterPresenter;
import es.mresti.xemio.app.view.RegisterView;

public class RegisterActivity extends BaseActivity implements RegisterView {

  private Navigator mNavigator;
  private RegisterPresenter mPresenter;

  // UI items
  @Bind(R.id.btn_login) Button mBtn_login;
  @Bind(R.id.btn_logup) Button mBtn_logup;
  @Bind(R.id.btn_deny) Button mBtn_deny;
  @Bind(R.id.btn_begin) Button mBtn_begin;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, RegisterActivity.class);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_register);
    ButterKnife.bind(this);
    this.initialize();
    mPresenter = PresenterFactory.getRegisterPresenter(this);
  }

  /**
   * Initializes activity's private members.
   */
  private void initialize() {
    this.mNavigator = new Navigator();
    mBtn_begin.setVisibility(View.GONE);
  }

  /**
   * Goes to the finish activity.
   */
  @OnClick(R.id.btn_deny) void navigateToFinish() {
    finish();
  }

  /**
   * Goes to the user LogIn screen.
   */
  @OnClick(R.id.btn_login) void navigateToLogIn() {
    this.mNavigator.navigateToUserLogIn(this);
    finish();
  }

  /**
   * Goes to the user LogUp screen.
   */
  @OnClick(R.id.btn_logup) void navigateToLogUp() {
    this.mNavigator.navigateToUserLogUp(this);
    finish();
  }

  @Override public void showProgress() {

  }

  @Override public void hideProgress() {

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
