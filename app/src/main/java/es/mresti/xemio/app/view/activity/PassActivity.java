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
import es.mresti.xemio.app.view.validator.AlphaNumericValidator;
import es.mresti.xemio.app.view.validator.EmailValidator;
import es.mresti.xemio.app.view.validator.NumericValidator;


public class PassActivity extends BaseActivity {

  private static final String mLOGTAG = "LogsAndroid";

  private Navigator mNavigator;

  @InjectView(R.id.btn_next) Button mBtn_save;
  @InjectView(R.id.btn_deny) Button mBtn_Deny;

  @InjectView(R.id.passInput1) EditText mPassInput1;
  @InjectView(R.id.passInputLayout1) TextInputLayout mPassInputLayout1;

  @InjectView(R.id.passInput2) EditText mPassInput2;
  @InjectView(R.id.passInputLayout2) TextInputLayout mPassInputLayout2;

  public static Intent getCallingIntent(Context context) {
    return new Intent(context, PassActivity.class);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_pass);

    ButterKnife.inject(this);
    this.initialize();
  }

  /**
   * Initializes activity's private members.
   */
  private void initialize() {
    this.mNavigator = new Navigator();
  }

  /**
   * Goes to the dashboard screen.
   */
  @OnClick(R.id.btn_next)
  void navigateToDashboard() {
    this.mNavigator.navigateToDashboard(this);
  }

  /**
   * Goes to the user LogIn screen.
   */
  @OnClick(R.id.btn_deny)
  void navigateToFinish() {
    finish();
  }
}
