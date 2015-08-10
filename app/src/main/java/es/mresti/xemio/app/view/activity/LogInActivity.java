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
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import es.mresti.xemio.R;
import es.mresti.xemio.app.navigation.Navigator;
import es.mresti.xemio.app.presenter.LoginPresenter;
import es.mresti.xemio.app.presenter.PresenterFactory;
import es.mresti.xemio.app.view.LoginView;
import es.mresti.xemio.app.view.validator.AlphaNumericValidator;
import es.mresti.xemio.app.view.validator.EmailValidator;

public class LoginActivity extends BaseActivity implements LoginView {

  private static final String mLOGTAG = "LoginActivity";
  private LoginPresenter presenter;
  private Navigator mNavigator;
  private EmailValidator mEmailValidator;
  private AlphaNumericValidator mAlphaNumericValidator;

  // UI items
  @InjectView(R.id.btn_save) Button mBtn_save;
  @InjectView(R.id.btn_deny) Button mBtn_Deny;
  @InjectView(R.id.progress) ProgressBar mProgress;
  @InjectView(R.id.emailInput) EditText mEmailText;
  @InjectView(R.id.emailInputLayout) TextInputLayout mEmailInputLayout;
  @InjectView(R.id.passInput) EditText mPassText;
  @InjectView(R.id.passInputLayout) TextInputLayout mPassInputLayout;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, LoginActivity.class);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    ButterKnife.inject(this);
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
    mAlphaNumericValidator = new AlphaNumericValidator();
    mPassText.addTextChangedListener(mAlphaNumericValidator);
  }

  /**
   * Goes to the dashboard screen.
   */
  @OnClick(R.id.btn_save) void navigateToDashboard() {
    boolean emailValid = mEmailValidator.isValid();
    boolean passValid = mAlphaNumericValidator.isValid();

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

  @Override public void showLoading() {

  }

  @Override public void hideLoading() {

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
