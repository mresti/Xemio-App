package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import es.mresti.xemio.R;
import es.mresti.xemio.app.navigation.Navigator;
import es.mresti.xemio.app.presenter.LoginPresenter;
import es.mresti.xemio.app.presenter.PresenterFactory;
import es.mresti.xemio.app.view.LoginView;
import es.mresti.xemio.app.view.validator.EmailValidator;
import es.mresti.xemio.app.view.validator.PassValidator;

public class LoginActivity extends BaseActivity implements LoginView {

  private static final String mLOGTAG = "LoginActivity";
  private LoginPresenter presenter;
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
    presenter = PresenterFactory.getLoginPresenter(this);
  }

  /**
   * Initializes activity's private members.
   */
  private void initialize() {
    this.mNavigator = new Navigator();

    // Setup field validators.
    mEmailValidator = new EmailValidator();
    mEmailText.addTextChangedListener(mEmailValidator);
    mPassValidator = new PassValidator();
    mPassText.addTextChangedListener(mPassValidator);
  }

  /**
   * Goes to the dashboard screen.
   */
  @OnClick(R.id.btn_save) void navigateToDashboard() {
    boolean emailValid = mEmailValidator.isValid();
    boolean passValid = mPassValidator.isValid();

    if (!emailValid) {
      mEmailInputLayout.setErrorEnabled(true);
      mEmailInputLayout.setError(getText(R.string.error_email));
      Log.w(mLOGTAG, "Not saving personal information: Invalid email");
    } else {
      mEmailInputLayout.setErrorEnabled(false);
    }

    if (!passValid) {
      mPassInputLayout.setErrorEnabled(true);
      mPassInputLayout.setError(getText(R.string.error_empty));
      Log.w(mLOGTAG, "Not saving personal information: Invalid alias");
    } else {
      mPassInputLayout.setErrorEnabled(false);
    }

    if (emailValid && passValid) {
      presenter.validateCredentials(mEmailText.getText().toString(),
          mPassText.getText().toString());
    }
  }

  /**
   * Goes to the finish activity.
   */
  @OnClick(R.id.btn_deny) void navigateToFinish() {
    finish();
  }

  //TODO: check theses methods

  @Override public void showProgress() {
    mProgress.setVisibility(View.VISIBLE);
  }

  @Override public void hideProgress() {
    mProgress.setVisibility(View.GONE);
  }

  @Override public void setUsernameError() {
    mEmailInputLayout.setErrorEnabled(true);
    mEmailInputLayout.setError(getString(R.string.error_email));
  }

  @Override public void setPasswordError() {
    mPassInputLayout.setErrorEnabled(true);
    mPassInputLayout.setError(getText(R.string.error_empty));
  }

  @Override public void navigateToHome() {
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
    return null;
  }
}
