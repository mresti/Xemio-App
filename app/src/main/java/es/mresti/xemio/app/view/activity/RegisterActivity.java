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
import es.mresti.xemio.app.contract.RegisterContract;
import es.mresti.xemio.app.navigation.Navigator;
import es.mresti.xemio.app.presenter.RegisterPresenter;

public class RegisterActivity extends BaseActivity implements RegisterContract.View {

  private RegisterContract.UserActionsListener mActionsListener;
  private Navigator mNavigator;

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
  }

  private void initialize() {
    mNavigator = new Navigator();
    mActionsListener = new RegisterPresenter(this);
    mActionsListener.initializeActions(this.getContext());
    mBtn_begin.setVisibility(View.GONE);
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

  @Override public void openLogin() {
    mNavigator.navigateToUserLogIn(this);
    finish();
  }

  @Override public void openLogup() {
    mNavigator.navigateToUserLogUp(this);
    finish();
  }

  @Override public void closeApp() {
    finish();
  }

  @OnClick(R.id.btn_deny) void closeMainActivity() {
    this.closeApp();
  }

  @OnClick(R.id.btn_login) void openLoginActivity() {
    this.openLogin();
  }

  @OnClick(R.id.btn_logup) void openLogupActivity() {
    this.openLogup();
  }
}
