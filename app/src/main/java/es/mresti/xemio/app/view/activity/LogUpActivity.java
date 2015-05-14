package es.mresti.xemio.app.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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


public class LogUpActivity extends BaseActivity {

  private static final String mLOGTAG = "LogsAndroid";

  private Navigator mNavigator;

  @InjectView(R.id.toolbar)
  Toolbar mtoolbar;

  @InjectView(R.id.btn_save)
  Button btn_save;

  // The input field where the user enters his email.
  @InjectView(R.id.emailInput)
  EditText mEmailText;

  // The validator for the email input field.
  private EmailValidator mEmailValidator;

  // The input field where the user enters his nickname.
  @InjectView(R.id.aliasInput)
  EditText mAliasText;

  // The validator for the nickname input field.
  private ContentValidator mContentValidator;

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
    setSupportActionBar(mtoolbar);

    // Setup field validators.
    mEmailValidator = new EmailValidator();
    mEmailText.addTextChangedListener(mEmailValidator);
    mContentValidator = new ContentValidator();
    mAliasText.addTextChangedListener(mContentValidator);
  }

  /**
   * Goes to the user verify screen.
   */
  @OnClick(R.id.btn_save)
  void navigateToVerify() {
    if (!mEmailValidator.isValid()) {
      mEmailText.setError("Invalid email");
      Log.w(mLOGTAG, "Not saving personal information: Invalid email");
      return;
    }else if(!mContentValidator.isValid()) {
      mAliasText.setError("Invalid alias");
      Log.w(mLOGTAG, "Not saving personal information: Invalid alias");
      return;
    }else{
      this.mNavigator.navigateToVerify(this);
    }
  }
}
