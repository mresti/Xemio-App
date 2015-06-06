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


public class LogUpActivity extends BaseActivity {

  private static final String mLOGTAG = "LogsAndroid";

  private Navigator mNavigator;

  @InjectView(R.id.btn_save)
  Button btn_save;

  // The input field where the user enters his email.
  @InjectView(R.id.emailInput) EditText mEmailText;

  @InjectView(R.id.emailInputLayout) TextInputLayout mEmailInputLayout;

  // The validator for the email input field.
  private EmailValidator mEmailValidator;

  // The input field where the user enters his alias.
  @InjectView(R.id.aliasInput) EditText mAliasText;

  @InjectView(R.id.aliasInputLayout) TextInputLayout mAliasInputLayout;

  // The validator for the alias input field.
  private AlphaNumericValidator mAlphaNumericValidator;

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
  }

  /**
   * Goes to the user verify screen.
   */
  @OnClick(R.id.btn_save)
  void navigateToVerify() {
    if (!mEmailValidator.isValid()) {
      mEmailInputLayout.setError(getText(R.string.error_email));
      Log.w(mLOGTAG, "Not saving personal information: Invalid email");
    }else if(!mAlphaNumericValidator.isValid()) {
      mAliasInputLayout.setError(getText(R.string.error_empty));
      Log.w(mLOGTAG, "Not saving personal information: Invalid alias");
    }else{
      this.mNavigator.navigateToVerify(this);
    }
  }
}
