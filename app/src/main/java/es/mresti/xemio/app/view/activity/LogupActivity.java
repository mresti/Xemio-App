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
import es.mresti.xemio.app.navigation.Navigator;
import es.mresti.xemio.app.presenter.LogupPresenter;
import es.mresti.xemio.app.presenter.PresenterFactory;
import es.mresti.xemio.app.view.LogupView;
import es.mresti.xemio.app.view.validator.AlphaNumericValidator;
import es.mresti.xemio.app.view.validator.EmailValidator;
import es.mresti.xemio.app.view.validator.NumericValidator;

public class LogupActivity extends BaseActivity implements LogupView {

  private LogupPresenter presenter;
  private Navigator mNavigator;
  private ProgressBar progressBar;
  private EmailValidator mEmailValidator;
  private AlphaNumericValidator mAlphaNumericValidator;
  private NumericValidator mNumericValidator;

  // UI items
  @Bind(R.id.btn_save) Button mBtn_save;
  @Bind(R.id.btn_deny) Button mBtn_deny;
  @Bind(R.id.progress) ProgressBar mProgress;
  @Bind(R.id.emailInput) EditText mEmailText;
  @Bind(R.id.emailInputLayout) TextInputLayout mEmailInputLayout;
  @Bind(R.id.aliasInput) EditText mAliasText;
  @Bind(R.id.aliasInputLayout) TextInputLayout mAliasInputLayout;
  @Bind(R.id.ageInput) EditText mAgeInput;
  @Bind(R.id.ageInputLayout) TextInputLayout mAgeInputLayout;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, LogupActivity.class);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_logup);
    ButterKnife.bind(this);
    this.initialize();
    presenter = PresenterFactory.getLogupPresenter(this);
  }

  /**
   * Initializes activity's private members.
   */
  private void initialize() {
    this.mNavigator = new Navigator();
    progressBar = (ProgressBar) findViewById(R.id.progress);

    // Setup field validators.
    mEmailValidator = new EmailValidator();
    mEmailText.addTextChangedListener(mEmailValidator);
    mAlphaNumericValidator = new AlphaNumericValidator();
    mAliasText.addTextChangedListener(mAlphaNumericValidator);
    mNumericValidator = new NumericValidator();
    mAgeInput.addTextChangedListener(mNumericValidator);
  }

  /**
   * Goes to the dashboard screen.
   */
  @OnClick(R.id.btn_save) void navigateToDashboard() {
    boolean emailValid = mEmailValidator.isValid();
    boolean aliasValid = mAlphaNumericValidator.isValid();
    boolean ageValid = mNumericValidator.isValid();

    if (!emailValid) {
      mEmailInputLayout.setErrorEnabled(true);
      mEmailInputLayout.setError(getText(R.string.error_email));
    } else {
      mEmailInputLayout.setErrorEnabled(false);
    }

    if (!aliasValid) {
      mAliasInputLayout.setErrorEnabled(true);
      mAliasInputLayout.setError(getText(R.string.error_empty));
    } else {
      mAliasInputLayout.setErrorEnabled(false);
    }

    if (!ageValid) {
      mAgeInputLayout.setErrorEnabled(true);
      mAgeInputLayout.setError(getText(R.string.error_age));
    } else {
      mAgeInputLayout.setErrorEnabled(false);
    }

    if (emailValid && aliasValid && ageValid) {
      presenter.setRegister(mAliasText.getText().toString(), mEmailText.getText().toString(),
          mAgeInput.getText().toString());
    }
  }

  /**
   * Goes to the finish activity.
   */
  @OnClick(R.id.btn_deny) void navigateToFinish() {
    finish();
  }

  @Override public void showProgress() {
    mProgress.setVisibility(View.VISIBLE);
  }

  @Override public void hideProgress() {
    mProgress.setVisibility(View.GONE);
  }

  @Override public void setUsernameError() {
    mAliasInputLayout.setErrorEnabled(true);
    mAliasInputLayout.setError(getString(R.string.error_empty));
  }

  @Override public void setEmailError() {
    mEmailInputLayout.setErrorEnabled(true);
    mEmailInputLayout.setError(getString(R.string.error_email));
  }

  @Override public void setAgeError() {
    mAgeInputLayout.setErrorEnabled(true);
    mAgeInputLayout.setError(getString(R.string.error_age));
  }

  @Override public void navigateToVerifyScreen() {
    this.mNavigator.navigateToVerify(this);
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
