package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import es.mresti.xemio.R;
import es.mresti.xemio.app.contract.LoginContract;
import es.mresti.xemio.app.navigation.Navigator;
import es.mresti.xemio.app.presenter.LoginPresenter;
import es.mresti.xemio.app.view.validator.EmailValidator;
import es.mresti.xemio.app.view.validator.PassValidator;

public class LoginActivity extends BaseActivity implements LoginContract.View {

  private LoginContract.UserActionsListener mActionsListener;
  private Navigator mNavigator;
  private EmailValidator mEmailValidator;
  private PassValidator mPassValidator;

  // UI items
  @Bind(R.id.btn_save) Button mBtn_save;
  @Bind(R.id.btn_deny) Button mBtn_Deny;
  @Bind(R.id.progress) ProgressBar mProgress;
  @Bind(R.id.emailInput) EditText mEmailText;
  @Bind(R.id.emailInputLayout) TextInputLayout mEmailInputLayout;
  @Bind(R.id.passInput) EditText mPassText;
  @Bind(R.id.passInputLayout) TextInputLayout mPassInputLayout;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, LoginActivity.class);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);
    ButterKnife.bind(this);
    this.initialize();
  }

  private void initialize() {
    mNavigator = new Navigator();
    mActionsListener = new LoginPresenter(this);
    mActionsListener.initializeActions(this.getContext());

    // Setup field validators.
    mEmailValidator = new EmailValidator();
    mEmailText.addTextChangedListener(mEmailValidator);
    mPassValidator = new PassValidator();
    mPassText.addTextChangedListener(mPassValidator);
  }

  @Override public void showProgress() {
    mProgress.setVisibility(View.VISIBLE);
  }

  @Override public void hideProgress() {
    mProgress.setVisibility(View.GONE);
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

  @Override public void openDashboard() {
    mNavigator.navigateToDashboard(this);
    finish();
  }

  @Override public void getBackApp() {
    mNavigator.navigateToUserRegister(this);
    finish();
  }

  @Override public void setUsernameError() {
    mEmailInputLayout.setErrorEnabled(true);
    mEmailInputLayout.setError(getString(R.string.error_email));
  }

  @Override public void setPasswordError() {
    mPassInputLayout.setErrorEnabled(true);
    mPassInputLayout.setError(getText(R.string.error_pass));
  }

  @OnClick(R.id.btn_save) void navigateToDashboard() {
    boolean emailValid = mEmailValidator.isValid();
    boolean passValid = mPassValidator.isValid();

    if (!emailValid) {
      mEmailInputLayout.setErrorEnabled(true);
      mEmailInputLayout.setError(getText(R.string.error_email));
    } else {
      mEmailInputLayout.setErrorEnabled(false);
    }

    if (!passValid) {
      mPassInputLayout.setErrorEnabled(true);
      mPassInputLayout.setError(getText(R.string.error_pass));
    } else {
      mPassInputLayout.setErrorEnabled(false);
    }

    if (emailValid && passValid) {
      mActionsListener.validateCredentials(mEmailText.getText().toString(),
          mPassText.getText().toString());
    }
  }

  @OnClick(R.id.btn_deny) void navigateToRegister() {
    this.getBackApp();
  }
}
