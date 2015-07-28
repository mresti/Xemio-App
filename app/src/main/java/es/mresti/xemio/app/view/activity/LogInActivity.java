package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import es.mresti.xemio.R;
import es.mresti.xemio.app.navigation.Navigator;
import es.mresti.xemio.app.view.validator.EmailValidator;
import es.mresti.xemio.app.view.validator.AlphaNumericValidator;

public class LogInActivity extends BaseActivity {

  private static final String mLOGTAG = "LogsAndroid";

  private Navigator mNavigator;

  @InjectView(R.id.btn_save) Button mBtn_save;
  @InjectView(R.id.btn_deny) Button mBtn_Deny;

  @InjectView(R.id.emailInput) EditText mEmailText;
  @InjectView(R.id.emailInputLayout) TextInputLayout mEmailInputLayout;
  private EmailValidator mEmailValidator;

  @InjectView(R.id.passInput) EditText mPassText;
  @InjectView(R.id.passInputLayout) TextInputLayout mPassInputLayout;
  private AlphaNumericValidator mAlphaNumericValidator;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, LogInActivity.class);
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    ButterKnife.inject(this);
    this.initialize();
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
      this.mNavigator.navigateToDashboard(this);
    }
  }

  /**
   * Goes to the user LogIn screen.
   */
  @OnClick(R.id.btn_deny) void navigateToFinish() {
    finish();
  }
}
