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
import es.mresti.xemio.app.view.validator.EmailValidator;
import es.mresti.xemio.app.view.validator.PassValidator;

public class LogupActivity extends BaseActivity implements LogupView {

  public static final String TAG = "LogupActivity";
  private LogupPresenter mPresenter;
  private Navigator mNavigator;
  private EmailValidator mEmailValidator;
  private PassValidator mPassValidator1;
  private PassValidator mPassValidator2;

  // UI items
  @Bind(R.id.btn_save) Button mBtn_save;
  @Bind(R.id.btn_deny) Button mBtn_deny;
  @Bind(R.id.progress) ProgressBar mProgress;
  @Bind(R.id.emailInput) EditText mEmailText;
  @Bind(R.id.emailInputLayout) TextInputLayout mEmailInputLayout;
  @Bind(R.id.passInput1) EditText mPassInput1;
  @Bind(R.id.passInputLayout1) TextInputLayout mPassInputLayout1;
  @Bind(R.id.passInput2) EditText mPassInput2;
  @Bind(R.id.passInputLayout2) TextInputLayout mPassInputLayout2;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, LogupActivity.class);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_logup);
    ButterKnife.bind(this);
    this.initialize();
  }

  /**
   * Initializes activity's private members.
   */
  private void initialize() {
    mPresenter = PresenterFactory.getLogupPresenter(this);
    mPresenter.initializeContext(this.getContext());
    mNavigator = new Navigator();

    // Setup field validators.
    mEmailValidator = new EmailValidator();
    mEmailText.addTextChangedListener(mEmailValidator);
    mPassValidator1 = new PassValidator();
    mPassInput1.addTextChangedListener(mPassValidator1);
    mPassValidator2 = new PassValidator();
    mPassInput2.addTextChangedListener(mPassValidator2);
  }

  /**
   * Goes to the dashboard screen.
   */
  @OnClick(R.id.btn_save) void navigateToDashboard() {
    boolean emailValid = mEmailValidator.isValid();
    boolean passValid1 = mPassValidator1.isValid();
    boolean passValid2 = mPassValidator2.isValid();

    if (!emailValid) {
      mEmailInputLayout.setErrorEnabled(true);
      mEmailInputLayout.setError(getText(R.string.error_email));
    } else {
      mEmailInputLayout.setErrorEnabled(false);
    }

    if (!passValid1) {
      mPassInputLayout1.setErrorEnabled(true);
      mPassInputLayout1.setError(getText(R.string.error_pass));
    } else {
      mPassInputLayout1.setErrorEnabled(false);
    }

    if (!passValid2) {
      mPassInputLayout2.setErrorEnabled(true);
      mPassInputLayout2.setError(getText(R.string.error_pass));
    } else {
      mPassInputLayout2.setErrorEnabled(false);
    }

    if (emailValid && passValid1 && passValid2) {
      mPresenter.setRegister(mEmailText.getText().toString(), mPassInput1.getText().toString(),
          mPassInput2.getText().toString());
    }
  }

  /**
   * Goes to the finish activity.
   */
  @OnClick(R.id.btn_deny) void navigateToFinish() {
    mNavigator.navigateToUserRegister(this);
    finish();
  }

  @Override public void showProgress() {
    mProgress.setVisibility(View.VISIBLE);
  }

  @Override public void hideProgress() {
    mProgress.setVisibility(View.GONE);
  }

  @Override public void setEmailError() {
    mEmailInputLayout.setErrorEnabled(true);
    mEmailInputLayout.setError(getString(R.string.error_email));
  }

  @Override public void setPass1Error() {
    mPassInputLayout1.setErrorEnabled(true);
    mPassInputLayout1.setError(getText(R.string.error_pass));
  }

  @Override public void setPass2Error() {
    mPassInputLayout2.setErrorEnabled(true);
    mPassInputLayout2.setError(getText(R.string.error_pass));
  }

  @Override public void setPassDistinctError() {
    mPassInputLayout1.setErrorEnabled(true);
    mPassInputLayout1.setError(getText(R.string.error_pass_diff));
    mPassInputLayout2.setErrorEnabled(true);
    mPassInputLayout2.setError(getText(R.string.error_pass_diff));
  }

  @Override public void navigateToExtraScreen() {
    mNavigator.navigateToExtra(this);
    finish();
  }

  @Override public Context getContext() {
    return getApplicationContext();
  }
}
