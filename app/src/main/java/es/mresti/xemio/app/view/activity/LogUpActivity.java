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
import es.mresti.xemio.app.view.validator.NumericValidator;

public class LogUpActivity extends BaseActivity {

  private static final String mLOGTAG = "LogsAndroid";

  private Navigator mNavigator;

  @InjectView(R.id.btn_save) Button mBtn_save;
  @InjectView(R.id.btn_deny) Button mBtn_deny;
  @InjectView(R.id.btn_login) Button mBtn_login;

  @InjectView(R.id.emailInput) EditText mEmailText;
  @InjectView(R.id.emailInputLayout) TextInputLayout mEmailInputLayout;
  private EmailValidator mEmailValidator;

  @InjectView(R.id.aliasInput) EditText mAliasText;
  @InjectView(R.id.aliasInputLayout) TextInputLayout mAliasInputLayout;
  private AlphaNumericValidator mAlphaNumericValidator;

  @InjectView(R.id.ageInput) EditText mAgeInput;
  @InjectView(R.id.ageInputLayout) TextInputLayout mAgeInputLayout;
  private NumericValidator mNumericValidator;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, LogUpActivity.class);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_register);

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
    mAliasText.addTextChangedListener(mAlphaNumericValidator);
    mNumericValidator = new NumericValidator();
    mAgeInput.addTextChangedListener(mNumericValidator);
  }

  /**
   * Goes to the dashboard screen.
   */
  @OnClick(R.id.btn_save)
  void navigateToDashboard() {
    boolean emailValid = mEmailValidator.isValid();
    boolean aliasValid = mAlphaNumericValidator.isValid();
    boolean ageValid = mNumericValidator.isValid();

    if (!emailValid) {
      mEmailInputLayout.setErrorEnabled(true);
      mEmailInputLayout.setError(getText(R.string.error_email));
      Log.w(mLOGTAG, "Not saving personal information: Invalid email");
    }else{
      mEmailInputLayout.setErrorEnabled(false);
    }

    if(!aliasValid) {
      mAliasInputLayout.setErrorEnabled(true);
      mAliasInputLayout.setError(getText(R.string.error_empty));
      Log.w(mLOGTAG, "Not saving personal information: Invalid alias");
    }else{
      mAliasInputLayout.setErrorEnabled(false);
    }

    if (!ageValid) {
      mAgeInputLayout.setErrorEnabled(true);
      mAgeInputLayout.setError(getText(R.string.error_age));
      Log.w(mLOGTAG, "Not saving personal information: Invalid age");
    }else{
      mAgeInputLayout.setErrorEnabled(false);
    }

    if(emailValid && aliasValid && ageValid) {
      this.mNavigator.navigateToVerify(this);
    }
  }

  /**
   * Goes to the user LogIn screen.
   */
  @OnClick(R.id.btn_deny)
  void navigateToFinish() {
    finish();
  }

  /**
   * Goes to the user LogIn screen.
   */
  @OnClick(R.id.btn_login)
  void navigateToLogIn() {
    this.mNavigator.navigateToUserLogIn(this);
  }
}
