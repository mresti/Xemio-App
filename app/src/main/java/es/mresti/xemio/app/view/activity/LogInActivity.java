package es.mresti.xemio.app.view.activity;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import es.mresti.xemio.R;
import es.mresti.xemio.app.navigation.Navigator;
import es.mresti.xemio.app.view.validator.EmailValidator;
import es.mresti.xemio.app.view.validator.ContentValidator;

public class LogInActivity extends BaseActivity {

  private static final String mLOGTAG = "LogsAndroid";

  private Navigator mNavigator;

  @InjectView(R.id.btn_save)
  Button mBtn_save;

  // The input field where the user enters his email.
  @InjectView(R.id.emailInput) EditText mEmailText;

  @InjectView(R.id.emailInputLayout) TextInputLayout mEmailInputLayout;

  // The validator for the email input field.
  private EmailValidator mEmailValidator;

  // The input field where the user enters his alias.
  @InjectView(R.id.aliasInput) EditText mAliasText;

  @InjectView(R.id.aliasInputLayout) TextInputLayout mAliasInputLayout;

  // The validator for the alias input field.
  private ContentValidator mContentValidator;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, LogInActivity.class);
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
    mContentValidator = new ContentValidator();
    mAliasText.addTextChangedListener(mContentValidator);
  }

  /**
   * Goes to the dashboard screen.
   */
  @OnClick(R.id.btn_save)
  void navigateToDashboard() {
    if (!mEmailValidator.isValid()) {
      mEmailInputLayout.setError(getText(R.string.error_email));
      Log.w(mLOGTAG, "Not saving personal information: Invalid email");
    }else if(!mContentValidator.isValid()) {
      mAliasInputLayout.setError(getText(R.string.error_empty));
      Log.w(mLOGTAG, "Not saving personal information: Invalid alias");
    }else{
      this.mNavigator.navigateToDashboard(this);
    }
  }
}
